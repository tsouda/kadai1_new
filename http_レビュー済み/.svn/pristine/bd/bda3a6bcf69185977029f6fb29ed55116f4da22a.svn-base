package example.controller.welcome;

	import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


//	import org.slf4j.Logger;
	import org.apache.log4j.Logger;
//	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

	/**
	 * Handles requests for the application home page.
	 */
	@Controller
	public class HomeController {

	    /**
	     * Simply selects the home view to render by returning its name.
	     */
	    @RequestMapping(value = "/home.htm", method = {RequestMethod.GET, RequestMethod.POST})
	    public ModelAndView index(Locale locale, Model model) {
	    	System.out.println("Home Controller : Passing through...");

	        return new ModelAndView("home");
	    }


}