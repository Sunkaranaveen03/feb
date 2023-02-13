package com.example.springboot.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;


import com.example.springboothibernet.Repo.ProductRepo;
import com.example.springboothibernet.entity.Product;

@RestController
public class ProductController {
    @Autowired
	public ProductRepo productRepo;
    @PostMapping("saveProduct")
    public ResponseEntity<Product>saveProduct(@Valid @RequestBody Product product)
    {
    	
        productRepo.save(product);
      return ResponseEntity.ok(product);
    }
    @GetMapping("saveFile")
    public void saveFile(MultipartFile multipartFile) throws IllegalStateException, IOException
    {
    	System.out.println(multipartFile.getOriginalFilename());
    	System.out.println(multipartFile.getSize());
    	System.out.println(multipartFile.getContentType());
    	File file=new File("C:\\Users\\sunka\\30-01-2023\\"+multipartFile.getOriginalFilename());
    	multipartFile.transferTo(file);
    }
    
    @GetMapping("getproduById/{id}")
	public Product getproduById(@PathVariable(name="id") Integer id)
	{
		System.out.println("Id:"+id);
		Optional<Product> opt=productRepo.findById(id);
		
		if(opt.isPresent())
		{
			System.out.println("product:"+opt.get());
			return opt.get();
			
		}else {
			System.out.println("no book found");
			return null;
		}
}}
