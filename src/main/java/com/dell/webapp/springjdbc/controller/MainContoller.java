package com.dell.webapp.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dell.webapp.springjdbc.bean.EProduct;
import com.dell.webapp.springjdbc.dao.EProductDAO;

@Controller
public class MainContoller {
	
	@Autowired
	EProductDAO eproductDAO;
	
	@RequestMapping(value="/listproducts" , method=RequestMethod.GET)
	public String listProducts(ModelMap map) {
		
		List<EProduct> list = eproductDAO.getProducts();		
		map.addAttribute("list", list);
		
		return "listProduct";
	}
	
	@RequestMapping(value="/addproduct" , method=RequestMethod.GET)
	public String addProduct(ModelMap map) {
		EProduct eProduct = new EProduct();
		map.put("eProduct", eProduct);
		return "addproduct";
	}
	
	@RequestMapping(value="/add-product" , method=RequestMethod.POST)
	public String addProductPost(ModelMap map,@ModelAttribute("eProduct") EProduct eProduct) {
		eproductDAO.addProduct(eProduct);
		return "success";
	}
}
