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

import ro.emanuel.musicstore.dao.UserDAO;
import ro.emanuel.musicstore.pojo.User;

@Controller
public class UsersController {

	@RequestMapping(value = "users.htm")
	public ModelAndView showUsers() throws SQLException {
		ModelMap model = new ModelMap();

		ArrayList<User> users = UserDAO.getUsers();
		model.addAttribute("usersList", users);

		return new ModelAndView("/users/list", "model", model);

	}

	@RequestMapping(value = "/users/detalii/{userId}")
	public ModelAndView vizualizareDetalii(@PathVariable String userId, Model model)
			throws NumberFormatException, SQLException {

		User u = UserDAO.getUserById(Integer.parseInt(userId));
		model.addAttribute("user", u);

		return new ModelAndView("/users/detalii", "model", model);
	}

	@RequestMapping(value = "/users/editeaza/{userId}")
	public ModelAndView editDetalii(@PathVariable String userId, Model model)
			throws NumberFormatException, SQLException {

		User u = UserDAO.getUserById(Integer.parseInt(userId));
		model.addAttribute("userForm", u);

		return new ModelAndView("/users/edit", "model", model);
	}

	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("userForm") User user, ModelMap model, BindingResult result) {

		User userObj;
		try {
			userObj = UserDAO.getUserById(Integer.valueOf(user.getId()));
			userObj.setFname(user.getFname());
			userObj.setLname(user.getLname());
			userObj.setEmail(user.getEmail());
			UserDAO.updateUser(userObj);
			model.put("userForm", user);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/users/edit", "command", user);
	}

	@RequestMapping(value = "/users/delete/{userId}")
	public ModelAndView deleteUser(@PathVariable String userId, Model model)
			throws NumberFormatException, SQLException {

		UserDAO.deleteUser(UserDAO.getUserById(Integer.parseInt(userId)));
		ArrayList<User> users = UserDAO.getUsers();
		model.addAttribute("usersList", users);

		return new ModelAndView("/users/list", "model", model);
	}

	@RequestMapping(value = "/users/adauga")
	public ModelAndView adaugaUser(Model model) throws NumberFormatException, SQLException {

		User u = new User();
		model.addAttribute("userForm", u);

		return new ModelAndView("/users/add", "model", model);
	}

	@RequestMapping(value = "/users/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") User user, ModelMap model, BindingResult result) {

		try {
			UserDAO.createUser(user);
			model.put("userForm", user);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return new ModelAndView("/users/edit", "command", user);
		return new ModelAndView("redirect:/users.htm");
	}

}
