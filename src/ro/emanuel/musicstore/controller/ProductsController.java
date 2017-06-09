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

import ro.emanuel.musicstore.dao.ProductDAO;
import ro.emanuel.musicstore.pojo.Product;

@Controller
public class ProductsController {

	@RequestMapping (value="products.htm")
	public ModelAndView showProduct() throws SQLException{
		ModelMap model = new ModelMap();
				
		ArrayList<Product> products=ProductDAO.getProducts();
		model.addAttribute("productsList", products);
		
		return new ModelAndView("/products/list", "model", model);
	}
	

	@RequestMapping(value = "/products/detalii/{productId}")
	public ModelAndView vizualizareDetalii(@PathVariable String productId, Model model)
			throws NumberFormatException, SQLException {

		Product p = ProductDAO.getProductById(Integer.parseInt(productId));
		model.addAttribute("product", p);

		return new ModelAndView("/products/detalii", "model", model);
	}

	@RequestMapping(value = "/products/editeaza/{productId}")
	public ModelAndView editDetalii(@PathVariable String productId, Model model)
			throws NumberFormatException, SQLException {

		Product p = ProductDAO.getProductById(Integer.parseInt(productId));
		model.addAttribute("productForm", p);

		return new ModelAndView("/products/edit", "model", model);
	}

	@RequestMapping(value = "/products/save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {

		Product productObj;
		try {
			productObj = ProductDAO.getProductById(Integer.valueOf(product.getId()));
			productObj.setName(product.getName());
			productObj.setPrice(product.getPrice());
			productObj.setStoc(product.getStoc());
			productObj.setProducator(product.getProducator());
			ProductDAO.updateProduct(productObj);
			model.put("productForm", product);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/products/edit", "command", product);
	}

	@RequestMapping(value = "/products/delete/{productId}")
	public ModelAndView deleteProduct(@PathVariable String productId, Model model)
			throws NumberFormatException, SQLException {

		ProductDAO.deleteProduct(ProductDAO.getProductById(Integer.parseInt(productId)));
		ArrayList<Product> products= ProductDAO.getProducts();
		model.addAttribute("productsList", products);

		return new ModelAndView("/products/list", "model", model);
	}

	@RequestMapping(value = "/products/adauga")
	public ModelAndView adaugaProduct(Model model) throws NumberFormatException, SQLException {

		Product p = new Product();
		model.addAttribute("productForm", p);

		return new ModelAndView("/products/add", "model", model);
	}

	@RequestMapping(value = "/products/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {

		try {
			ProductDAO.createProduct(product);
			model.put("productForm", product);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return new ModelAndView("/products/edit", "command", product);
		return new ModelAndView("redirect:/products.htm");
	}

	
	
}
