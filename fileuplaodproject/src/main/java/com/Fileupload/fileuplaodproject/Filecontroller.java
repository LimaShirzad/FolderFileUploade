package com.Fileupload.fileuplaodproject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class Filecontroller {

   @PostMapping("/upload")
    public ResponseEntity<String> uploadefile(@RequestParam("file")MultipartFile file) throws IOException {
        try {

//            where the file must be store
            String uplaodDir="uploads/";
            Path path= Paths.get(uplaodDir+file.getOriginalFilename());  //

//            making folder
            Files.createDirectories(path.getParent());

            Files.write(path,file.getBytes());

            return  ResponseEntity.ok("files uploaded  successfully   " + file.getOriginalFilename());

        }catch (IOException e)
        {
               return
                       ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FILE NOT UPLADED");
        }
   }




}
