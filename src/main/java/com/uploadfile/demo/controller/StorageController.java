package com.uploadfile.demo.controller;

import com.uploadfile.demo.entity.FileData;
import com.uploadfile.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class StorageController {

    @Autowired
    StoreService storeService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadFileToSystem(@RequestParam("fileName") MultipartFile file,  FileData fileData) throws IOException {
        System.out.println("file"+file.getOriginalFilename());
        System.out.println("fileData"+fileData.getName());
        String upLoadFile=storeService.uploadFileToSystem(file,fileData);
        return ResponseEntity.status(HttpStatus.OK)
                .body(upLoadFile);
    }
}
