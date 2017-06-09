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

import ro.emanuel.musicstore.dao.OrderDAO;
import ro.emanuel.musicstore.pojo.Order;


@Controller
public class OrdersController {
	
	@RequestMapping (value="orders.htm")
	public ModelAndView showOrders() throws SQLException{
		ModelMap model = new ModelMap();
		
		ArrayList<Order> orders=OrderDAO.getOrders();
		model.addAttribute("ordersList", orders);
		
		return new ModelAndView("/orders/list","model",model);
		
	}
	
	@RequestMapping(value = "/orders/detalii/{orderId}")
	public ModelAndView vizualizareDetalii(@PathVariable String orderId, Model model)
			throws NumberFormatException, SQLException {

		Order o = OrderDAO.getOrderById(Integer.parseInt(orderId));
		model.addAttribute("order", o);

		return new ModelAndView("/orders/detalii", "model", model);
	}

	@RequestMapping(value = "/orders/editeaza/{orderId}")
	public ModelAndView editDetalii(@PathVariable String orderId, Model model)
			throws NumberFormatException, SQLException {

		Order o = OrderDAO.getOrderById(Integer.parseInt(orderId));
		model.addAttribute("orderForm", o);

		return new ModelAndView("/orders/edit", "model", model);
	}

	@RequestMapping(value = "/orders/save", method = RequestMethod.POST)
	public ModelAndView saveOrder(@ModelAttribute("orderForm") Order order, ModelMap model, BindingResult result) {

		Order orderObj;
		try {
			orderObj = OrderDAO.getOrderById(Integer.valueOf(order.getId()));
			orderObj.setUserId(order.getUserId());
			orderObj.setOrderDate(order.getOrderDate());
			OrderDAO.updateOrder(orderObj);
			model.put("orderForm", order);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/orders/edit", "command", order);
	}

	@RequestMapping(value = "/orders/delete/{orderId}")
	public ModelAndView deleteOrder(@PathVariable String orderId, Model model)
			throws NumberFormatException, SQLException {

		OrderDAO.deleteOrder(OrderDAO.getOrderById(Integer.parseInt(orderId)));
		ArrayList<Order> orders = OrderDAO.getOrders();
		model.addAttribute("ordersList", orders);

		return new ModelAndView("/orders/list", "model", model);
	}

	@RequestMapping(value = "/orders/adauga")
	public ModelAndView adaugaOrder(Model model) throws NumberFormatException, SQLException {

		Order o = new Order();
		model.addAttribute("orderForm", o);

		return new ModelAndView("/orders/add", "model", model);
	}

	@RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
	public ModelAndView addOrder(@ModelAttribute("orderForm") Order order , ModelMap model, BindingResult result) {

		try {
			OrderDAO.createOrder(order);
			model.put("orderForm", order);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return new ModelAndView("/orders/edit", "command", order);
		return new ModelAndView("redirect:/orders.htm");
	}

}

	

