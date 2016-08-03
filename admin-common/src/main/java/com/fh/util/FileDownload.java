package com.fh.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载文件
 */
public class FileDownload {

    /**
     * @param response
     * @param filePath //文件完整路径(包括文件名和扩展名)
     * @param fileName //下载后看到的文件名
     * @return 文件名
     */
    public static void fileDownload(HttpServletResponse response, HttpServletRequest request, String filePath,
            String fileName) throws Exception {
        String userAgent = request.getHeader("USER-AGENT");
        String finalFileName = null;
        if (StringUtils.contains(userAgent, "MSIE")) {// IE浏览器
            finalFileName = URLEncoder.encode(fileName, "UTF8");
        } else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
            finalFileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
        }
        byte[] data = FileUtil.toByteArray2(filePath);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream;charset=UTF-8");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
        response.flushBuffer();
    }
}
