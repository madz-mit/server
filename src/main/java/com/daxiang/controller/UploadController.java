package com.daxiang.controller;

import com.daxiang.model.Response;
import com.daxiang.model.UploadFile;
import com.daxiang.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jiangyitao.
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/file/{fileType}")
    public Response uploadFile(MultipartFile file, @PathVariable Integer fileType) {
        UploadFile uploadFile = uploadService.upload(file, fileType);
        return Response.success(uploadFile);
    }
}
