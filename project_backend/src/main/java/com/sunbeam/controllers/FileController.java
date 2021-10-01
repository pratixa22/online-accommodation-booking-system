package com.sunbeam.controllers;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sunbeam.utils.StorageService;

@CrossOrigin
@Controller
public class FileController {
	
	@Autowired
	private StorageService storageService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("uploadFile") CommonsMultipartFile file) {		
		//System.out.println(file.getBytes());
		//System.out.println(file.getName());
		try {
			FileOutputStream out = new FileOutputStream("D:/Project" + file.getName());
			FileCopyUtils.copy(file.getInputStream(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("file uploaded");
	}
	
	//http://localhost:8080/1f1ec2aaa2144b6c8af588dfa2d5bb8f  --> thumbnail name in the database or uploads folder
	@RequestMapping(value="/{fileName}", produces = "image/*")
	public void download(@PathVariable("fileName") String fileName, HttpServletResponse resp) {
		//System.out.println("Loading file: " + fileName);
		Resource resource = storageService.load(fileName);
		if(resource != null) {
			try(InputStream in = resource.getInputStream()) {
				ServletOutputStream out = resp.getOutputStream();
				FileCopyUtils.copy(in, out);
				//System.out.println("image loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
