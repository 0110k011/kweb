package com.api.kweb.controllers;

import com.api.kweb.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/ofx", consumes = "multipart/form-data")
    @Operation(summary = "OFX file upload", description = "Allows to upload an OFX file for processing.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File processed successfully!"),
            @ApiResponse(responseCode = "400", description = "Invalid or empty file.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error processing the file.", content = @Content)
    })
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String originalFilename = file.getOriginalFilename();


        if (file.isEmpty() || originalFilename == null || !originalFilename.endsWith(".ofx")) {
            return ResponseEntity.badRequest().body("is not a valid OFX file.");
        }

        try {
            Path tempFile = Files.createTempFile("uploaded-", ".ofx");
            Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

            // Processar o arquivo .OFX
            // ofxProcessor.processOFX(tempFile.toFile());

            Files.delete(tempFile);

            return ResponseEntity.ok("File processed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error processing the file.");
        }
    }
}