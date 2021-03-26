package com.dell.webapp.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dell.webapp.springjdbc.bean.EProduct;

public class EProductDAO {

	// jdbc template
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// write crud jdbc operation
	// list all product
	
	public List<EProduct> getProducts(){
		return template.query("select * from eproduct", new RowMapper<EProduct>() {
			public EProduct mapRow(ResultSet res, int row) throws SQLException {
				// object mapping
				EProduct product = new EProduct();
				product.setId(res.getLong(1));
				product.setName(res.getString(2));
				product.setPrice(res.getBigDecimal(3));
				product.setDateAdded(res.getDate(4));
				return product;
			}
		});
	}
	
	// add product
	public int addProduct(EProduct product) {
		String query = "insert into eproduct(name,price) values('"+product.getName()
		+"','"+product.getPrice()+"')";
		return template.update(query);
	}
	
	// update product
	
	// delete product
}
