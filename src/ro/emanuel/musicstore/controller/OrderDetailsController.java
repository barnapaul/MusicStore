package ro.emanuel.musicstore.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.musicstore.dao.OrderDetailDAO;
import ro.emanuel.musicstore.pojo.OrderDetail;

@Controller
public class OrderDetailsController {

	@RequestMapping (value="orderdetails.htm")
	public ModelAndView showOrderDetail() throws SQLException{
		ModelMap model = new ModelMap();
		
		ArrayList<OrderDetail> orderdetails = OrderDetailDAO.getOrderDetails();
		model.addAttribute("orderdetailsList", orderdetails);
		
		return new ModelAndView("/orderdetails/list","model", model);
	}

	
	@RequestMapping(value = "/orderdetails/detalii/{orderdetailId}")
	public ModelAndView vizualizareDetalii(@PathVariable String orderdetailId, Model model)
			throws NumberFormatException, SQLException {

		OrderDetail od = OrderDetailDAO.getOrderDetailById(Integer.parseInt(orderdetailId));
		model.addAttribute("orderdetail", od);

		return new ModelAndView("/orderdetails/detalii", "model", model);
	}

	@RequestMapping(value = "/orderdetails/editeaza/{orderdetailId}")
	public ModelAndView editDetalii(@PathVariable String orderdetailId, Model model)
			throws NumberFormatException, SQLException {

		OrderDetail od = OrderDetailDAO.getOrderDetailById(Integer.parseInt(orderdetailId));
		model.addAttribute("orderdetailForm", od);

		return new ModelAndView("/orderdetails/edit", "model", model);
	}

	@RequestMapping(value = "/orderdetails/save", method = RequestMethod.POST)
	public ModelAndView saveOrderDetail(@ModelAttribute("orderdetailForm") OrderDetail orderdetail, ModelMap model, BindingResult result) {

		OrderDetail orderdetailObj;
		try {
			orderdetailObj = OrderDetailDAO.getOrderDetailById(Integer.valueOf(orderdetail.getId()));
			orderdetailObj.setOrderId(orderdetail.getOrderId());
			orderdetailObj.setProductId(orderdetail.getProductId());
			orderdetailObj.setQuant(orderdetail.getQuant());
			OrderDetailDAO.updateOrderDetail(orderdetailObj);
			model.put("orderdetailForm", orderdetail);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/orderdetails/edit", "command", orderdetail);
	}

	@RequestMapping(value = "/orderdetails/delete/{orderdetailId}")
	public ModelAndView deleteOrderDetail(@PathVariable String orderdetailId, Model model)
			throws NumberFormatException, SQLException {

		OrderDetailDAO.deleteOrderDetail(OrderDetailDAO.getOrderDetailById(Integer.parseInt(orderdetailId)));
		ArrayList<OrderDetail> orderdetails= OrderDetailDAO.getOrderDetails();
		model.addAttribute("orderdetailsList", orderdetails);

		return new ModelAndView("/orderdetails/list", "model", model);
	}

	@RequestMapping(value = "/orderdetails/adauga")
	public ModelAndView adaugaOrderDetail(Model model) throws NumberFormatException, SQLException {

		OrderDetail od = new OrderDetail();
		model.addAttribute("orderdetailForm", od);

		return new ModelAndView("/orderdetails/add", "model", model);
	}

	@RequestMapping(value = "/orderdetails/addOrderDetail", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") OrderDetail orderdetail, ModelMap model, BindingResult result) {

		try {
			OrderDetailDAO.createOrderDetail(orderdetail);
			model.put("orderdetailForm", orderdetail);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return new ModelAndView("/orderdetails/edit", "command", user);
		return new ModelAndView("redirect:/orderdetails.htm");
	}

	
}

