package com.example.filehandling.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:55 2018/10/18
 */
@RestController
public class FilterUploadController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        File covertFile = new File("F:/StudyProject/springboot_studyII/filehandling/" + file.getOriginalFilename());
        covertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(covertFile);
        fout.write(file.getBytes());
        fout.close();
        return "file is upload successfully";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
        String fileName = "C:/Users/wds/Desktop/test.txt";
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream((file)));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",String.format("attachment;filename=\"%s\"",file.getName()));
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/text")).body(resource);
        return responseEntity;
    }

    @RequestMapping(value = "/upload/multi", method = RequestMethod.POST)
    public String mutliFileUplod(@RequestParam(value = "files") MultipartFile[] files){
        for(MultipartFile file : files){
            System.out.println(file.getOriginalFilename());
        }
        return "multiple files upload successfully";
    }
}
