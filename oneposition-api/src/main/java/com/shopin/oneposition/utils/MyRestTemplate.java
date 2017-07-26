package com.shopin.oneposition.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/** 
* @author changePosition 
* @version 2017年7月9日 下午6:59:51 
* @DESC 继承自RestTemplate，便于被spring容器注入
*/
@Component
public class MyRestTemplate extends RestTemplate {
	
}
