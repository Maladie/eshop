package com.shop.service.utils;

import javax.servlet.http.HttpServletRequest;

public interface FtpConnector {

    public String uploadFile(HttpServletRequest request);
}
