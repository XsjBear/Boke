package com.boke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.TypeInfo;
import com.boke.service.ITypeInfoService;

@RestController
@RequestMapping("/type")
@ResponseBody
public class TypeInfoController {
	@Autowired
	private ITypeInfoService service;
	
	@RequestMapping("/findAll")
	private List<TypeInfo> findAll(){
		return service.findAll();
	}
	
	@RequestMapping("/finds")
	private List<TypeInfo> finds(){
		return service.finds();
	}
}
