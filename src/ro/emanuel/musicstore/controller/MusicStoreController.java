package ro.emanuel.musicstore.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MusicStoreController {

	@RequestMapping (value="music.htm")
	public ModelAndView getIndex(){
		ModelMap model=new ModelMap("model");
		model.put("time", new Date().toString());
		
		return new ModelAndView("music","model",model);
	
	}
}
