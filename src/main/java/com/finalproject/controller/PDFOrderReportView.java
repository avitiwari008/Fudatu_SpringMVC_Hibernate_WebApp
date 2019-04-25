package com.finalproject.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.finalproject.pojo.OrderDetails;
import com.finalproject.pojo.Restaurant;
import com.finalproject.pojo.User;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PDFOrderReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("content-Disposition", "attachment; filename=\" user_list.pdf\"");
		List<OrderDetails> ord= (List<OrderDetails>) model.get("orderList");
		
		Table t=new Table(4);
		t.addCell("OrderId");
		t.addCell("Orderdetails");
		t.addCell("Restaurant_id");
		t.addCell("User_Id");
		
		for(OrderDetails o:ord) {
			
			
//			Restaurant r =o.getRestaurant();
//			String rs=r.getRestaurantName();
//			User u=o.getUser();
//			String us=u.getFirstName();
			
		t.addCell(String.valueOf(o.getOrderId()));
			t.addCell(String.valueOf(o.getOrderdetails()));
			t.addCell(String.valueOf(o.getUser().getUserId()));
			t.addCell(String.valueOf(o.getRestaurant().getRestaurantId()));
			
			document.add(t);
			
		}
		
		
	}

}
