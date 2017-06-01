package com.qf.farmer.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: Properties 
 * @Description: TODO
 * @author: qinfei
 * @date: 2017年5月11日 下午3:33:53 
 */
@Component("system")
public class KafkaProperties implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("${kafka.broker.list}")
	private String brokenList;
	@Value("${kafka.topic}")
	private String topic;
	@Value("${store.add}")
	private String storeAdd;
	@Value("${store.del}")
	private String storeDel;
	/**
	 * @return brokenList
	 */
	public String getBrokenList() {
		return brokenList;
	}
	/**
	 * @param brokenList the brokenList to set
	 */
	public void setBrokenList(String brokenList) {
		this.brokenList = brokenList;
	}
	/**
	 * @return topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return storeAdd
	 */
	public String getStoreAdd() {
		return storeAdd;
	}
	/**
	 * @param storeAdd the storeAdd to set
	 */
	public void setStoreAdd(String storeAdd) {
		this.storeAdd = storeAdd;
	}
	/**
	 * @return storeDel
	 */
	public String getStoreDel() {
		return storeDel;
	}
	/**
	 * @param storeDel the storeDel to set
	 */
	public void setStoreDel(String storeDel) {
		this.storeDel = storeDel;
	}
}
