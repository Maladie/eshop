package com.shop.service.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.impl.FtpClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class WebProsFtpConnector implements FtpConnector {

    private static FtpConnector ftpConnector;

    private String hostname;
    private String login;
    private String password;

    public static FtpConnector getFtpConnector() {
        if (ftpConnector != null) {
            return ftpConnector;
        }
        ftpConnector = new WebProsFtpConnector();
        return ftpConnector;
    }

    public WebProsFtpConnector() {
        this.hostname = "ftp.webpros-dev.nazwa.pl";
        this.login = "webpros-dev_java2kat";
        this.password = "Java2Kat";
    }

    @Override
    public String uploadFile(HttpServletRequest request) {
        FTPClient client = new FTPClient();
        InputStream fileContent = null;
        String filePath = null;
        try {
            Part filePart = request.getPart("image");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            fileContent = filePart.getInputStream();
            client.connect(hostname);
            client.login(login, password);
            client.setFileType(FTP.BINARY_FILE_TYPE);
            client.enterLocalPassiveMode();
            filePath = buildFilePath(fileName);
            client.storeFile(filePath, fileContent);
            client.logout();
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        } finally {
            closeConnection(client, fileContent);
        }
        return buildFullServerPath(filePath);
    }

    private String buildFilePath(String fileName){
       return "/eshop/produkty/" + fileName;
    }

    private void closeConnection(FTPClient client, InputStream fileContent) {
        try {
            if (fileContent != null) {
                fileContent.close();
            }
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildFullServerPath(String filePath){
        return "http://java2kat.webpros.pl" + filePath;
    }
}
