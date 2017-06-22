package ro.emanuel.musicstore.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {

	@RequestMapping (value="welcome.htm")
	public ModelAndView getIndex(){
		ModelMap model=new ModelMap("model");
		
		
		return new ModelAndView("welcome","model",model);
	
	}
}
