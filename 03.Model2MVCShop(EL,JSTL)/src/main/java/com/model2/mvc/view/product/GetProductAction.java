package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class GetProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));

		
		//���Ķ����menu�� manage��� updateproductView.do �ΰ���
		//���Ķ����menu�� search��� readProductjsp�ΰ���
		ProductService service = new ProductServiceImpl();
		Product product = service.getProduct(prodNo);
	
		request.setAttribute("product", product);
		request.getParameter("menu");
		
		System.out.println(request.getParameter("menu"));
		
		if(request.getParameter("menu")!=null) {
			if(request.getParameter("menu").equals("manage")) {
				return "forward:/updateProductView.do";
				
			}else if(request.getParameter("menu").equals("search")){
				return "forward:/product/readProduct.jsp";
			}
		}
		return "forward:/product/readProduct.jsp";
	}

}