package com.shop.service.utils;

import javax.servlet.http.HttpServletRequest;

public interface FtpConnector {

    void uploadFile(HttpServletRequest request);
}
