package com.qf.farmer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.service.ISynDataService;
import com.qf.farmer.util.KafkaProperties;
import com.qf.farmer.util.KafkaUtil;
import com.qf.farmer.util.StringUtil;

@Service("synDataService")
public class SynDataServiceImpl implements ISynDataService{

	@Autowired
	private KafkaProperties kafkaProperties;
	
	private static final Logger logger = LoggerFactory.getLogger(SynDataServiceImpl.class);
	
	@Override
	public void storesAdd(String storesId) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(kafkaProperties.getStoreAdd());
			sb.append(storesId);
			KafkaUtil.send(kafkaProperties.getTopic(),kafkaProperties.getBrokenList(), storesId, StringUtil.Str2utf(sb.toString()));
			logger.info("新增店铺"+sb.toString());
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void storesDel(String storesId) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(kafkaProperties.getStoreDel());
			sb.append(storesId);
			KafkaUtil.send(kafkaProperties.getTopic(),kafkaProperties.getBrokenList(), storesId, StringUtil.Str2utf(sb.toString()));
			logger.info("删除店铺"+sb.toString());
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void storeBatchAdd(List<String> storeIdList) {
		logger.info("开始店铺批量新增"+storeIdList.size());
		for(String storeId : storeIdList){
			storesAdd(storeId);
		}
		logger.info("店铺批量新增完了");
	}

	@Override
	public void storeBatchDel(List<String> storeIdList) {
		logger.info("开始店铺批量删除"+storeIdList.size());
		for(String storeId : storeIdList){
			storesDel(storeId);
		}
		logger.info("店铺批量删除完了");
	}
}
