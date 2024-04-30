package com.cy.school1.controller;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("file")
public class FileController extends BaseController{

        @GetMapping("/download_1")
        @ResponseBody
        public String downLoad (HttpServletRequest request, HttpServletResponse response) throws IOException {
            // 1. 读取文件
            String realPath = "src/main/resources/static/file/lead.pdf";
            File file = new File(realPath);
            String filename = file.getName();
            // 2. 设置浏览器以下载方式打开， 此处不设置，会直接在浏览器预览图片
            response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));

            // 3. 读取文件，写到输出流
            InputStream in = new FileInputStream(file);
            byte[] buf = new byte[1024];
            while (in.read(buf) > 0) {
                response.getOutputStream().write(buf, 0, buf.length);
            }
            in.close();
            return "下载完成";
    }


}
