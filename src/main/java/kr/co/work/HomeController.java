package kr.co.work;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.db_input.command.WriteCommand;
import kr.co.db_input.dto.Dto_input;

/**
 * Handles requests for the application home page.
 */
@Controller 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "/input";
	}
	
	@RequestMapping("/input2")
	public String input2() {
		return "/input2";
	}
	
	/*
	 * @RequestMapping(value = "/view", method = RequestMethod.GET) // view?id=123
	 * public String view(HttpServletRequest request) { String id =
	 * request.getParameter("id"); System.out.println(id); return "/view"; }
	 */
	
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String view(HttpServletRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		return "/view";
	}
	
	/*
	 * @RequestMapping("/output") public String output(Model model) {
	 * model.addAttribute("name","ironman"); return "/output"; }
	 */
	
	@RequestMapping("/output")
	public ModelAndView output() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","spiderman");
		mav.setViewName("/output");
		return mav;
	}
	
	@RequestMapping("/write")
	public String write() {
		return "/write";
	}
	
	@RequestMapping("/write_ok") 
	public String write_ok(Dto_input dto_input) throws SQLException {
		// Dto_input에 있는 내용을 DB에 넣기
		// 실행할 Command 호출
		WriteCommand wc = new WriteCommand();
		wc.execute(dto_input);
		return "redirect:list";
	}
}
