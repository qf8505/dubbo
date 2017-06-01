package com.qf.farmer.service;

import java.util.List;

/**
 * 数据同步接口
 * @author qf
 */
public interface ISynDataService {

	/**
	 * 店铺新增(放在设置成可以被搜索到的状态方法后)
	 * @param 店铺id
	 * @throws Exception
	 */
	public void storesAdd(String storesId);
	
	/**
	 * 店铺封停(放在封停店铺成功后)
	 * @param 店铺id
	 * @throws Exception
	 */
	public void storesDel(String storesId);
	/**
	 * 	
	 * @Title storeBatchAdd
	 * @Description 店铺批量新增
	 * @param storeBatchDel
	 * @throws Exception
	 * @return void
	 */
	public void storeBatchAdd(List<String> storeIdList);
	
	/**
	 * @Title storeBatchDel
	 * @Description 店铺批量删除
	 * @param storeIdList
	 * @throws Exception
	 * @return void
	 */
	public void storeBatchDel(List<String> storeIdList);
}
