package com.shopin.oneposition.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shopin.oneposition.service.MovieCollectService;
import com.shopin.oneposition.service.UserManageBeanService;
import com.shopin.oneposition.utils.MyRestTemplate;

/**
 * @author changePosition
 * @version 2017年7月9日 下午12:10:53
 * @DESC controller基类
 */
@Controller
public class BaseController {
	protected Logger logger = LogManager.getLogger(BaseController.class);
	@Autowired
	MyRestTemplate restTemplate;
	
	@Autowired
	UserManageBeanService userService;
	
	@Autowired
	MovieCollectService collectService;
}
