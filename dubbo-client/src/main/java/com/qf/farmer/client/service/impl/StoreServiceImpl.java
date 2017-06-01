package com.qf.farmer.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.client.service.StoreService;
import com.qf.farmer.service.ISynDataService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private ISynDataService synDataService;
	
	@Override
	public void storeAdd(String id) {
		synDataService.storesAdd(id);
	}

}
