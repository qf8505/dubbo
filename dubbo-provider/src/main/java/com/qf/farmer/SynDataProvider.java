package com.qf.farmer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.container.Container;

public class SynDataProvider {
	public static final String APP_NAME = "dubbo-provider";
	private static final Logger logger = LoggerFactory.getLogger(SynDataProvider.class);
	private static final ExtensionLoader<Container> loader = ExtensionLoader.getExtensionLoader(Container.class);
	private static volatile boolean running = true;

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml", "config/provider.xml");
			context.start();
			logger.info("Dubbo " + APP_NAME + "!");
			System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " Dubbo " + APP_NAME + " started!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			System.exit(1);
		}
		synchronized (SynDataProvider.class) {
			while (running) {
				try {
					SynDataProvider.class.wait();
				} catch (Throwable e) {
				}
			}
		}
	}
}
