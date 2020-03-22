package com.wx.speaking.controller;

import com.wx.speaking.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class RecordController {

    @Autowired
    RecordService recordService;

    @PostMapping("/sendResult")
    public String sendResult(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        String savePath = "F:\\J2EE\\speaking\\src\\main\\resources\\record";

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        //获取上传文件
        MultipartFile recordFile = req.getFile("wx_record");
        System.out.println(id);
        System.out.println(password);

        String desFile = savePath + recordFile.getOriginalFilename();

        File file = new File(desFile);
        recordFile.transferTo(file);
        System.out.println(file);

        String textPath = "[content]She refused to speak to me at first.";
        String result = recordService.callApi("read_sentence", file.toString(), textPath);
        return result;

    }
}
