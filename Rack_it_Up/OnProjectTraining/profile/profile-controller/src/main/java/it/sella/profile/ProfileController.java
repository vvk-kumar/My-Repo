package it.sella.profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProfileController{
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public ModelAndView student() {
    return new ModelAndView("hello", "command", new Profile());
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String display(@ModelAttribute("profile")Profile profile, 
			   ModelMap model) {
		
		model.addAttribute("name", profile.getName());
	      model.addAttribute("address", profile.getAddress());
	      model.addAttribute("phone", profile.getPhone());
		
	      return "result";
	}


}
