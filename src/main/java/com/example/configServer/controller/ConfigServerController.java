package com.example.configServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.configServer.model.TestModel;


@RestController
public class ConfigServerController {

	@Autowired
	private DiscoveryClient eurekaClient;
	
	@RequestMapping(value ="/ServerTest",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public TestModel getTest(HttpServletRequest request) {
		TestModel tm = new TestModel();
		tm.setUrl(request.getRequestURL().toString());
		tm.setMsg("请求访问成功");
		
		return tm;
	}
}
