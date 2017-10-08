package com.stfo.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/images")
@Controller
public class ImageController {
	
	private final String UPLOADED_FOLDER = "images/";

	@PostMapping("")
	public ResponseEntity<String> uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) {
		String fileName = UUID.randomUUID().toString();
		file.getContentType();
		String body = "";
		HttpStatus status;
		if (file.isEmpty()) {
			body = "";
			status = HttpStatus.NO_CONTENT;
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName + ".jpg");
			Files.write(path, bytes);
			status = HttpStatus.OK;
			body = fileName;
		} catch (IOException e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			body = "";
			e.printStackTrace();
		}
		return new ResponseEntity<String>(body, status);
	}
	
	@GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable("imageId") String imageId) {
		byte[] bytes;
		HttpStatus status;
		Path path = Paths.get(UPLOADED_FOLDER + imageId + ".jpg");
		try {
			bytes = Files.readAllBytes(path);
			status = HttpStatus.OK;
		} catch (IOException e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			bytes = null;
		}
		return new ResponseEntity<byte[]>(bytes, status);
	}

}
