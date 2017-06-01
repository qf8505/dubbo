package com.qf.farmer.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.client.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/storeAdd")
	public String storeAdd(){
		storeService.storeAdd("11");
		return "";
	}
}
