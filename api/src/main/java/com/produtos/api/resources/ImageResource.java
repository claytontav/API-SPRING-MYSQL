package com.produtos.api.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ImageResource {

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file){

        if(file.isEmpty()){
            throw new RuntimeException("File given is not valid!");
        }

        String folder = "src/main/java/com/produtos/api/assets/";

        try {
            Path pathFolder = Paths.get(folder);
            Files.createDirectories(pathFolder);

            Path pathFlie = Paths.get(folder + file.getOriginalFilename());
            Files.write(pathFlie, file.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
