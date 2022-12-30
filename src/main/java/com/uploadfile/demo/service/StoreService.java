package com.uploadfile.demo.service;


import com.uploadfile.demo.entity.FileData;
import com.uploadfile.demo.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class StoreService {

    @Autowired
    private  FileRepo fileRepo;
    public String uploadFileToSystem(MultipartFile file,FileData fileData) throws IOException {
        String fileDir="C:/myFile/" +file.getOriginalFilename();
       /* FileData fileData=fileRepo.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(fileDir).build());
*/
        fileData.setName(fileData.getName());
        fileData.setFilePath(fileDir);
        fileData.setType(file.getContentType());
        fileRepo.save(fileData);
              file.transferTo(new File(fileDir));
                if(file!=null){
                   return  "file uploaded successfully" +file.getOriginalFilename();
                }

                return null;

    }
}
