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

import kr.co.db_input.command.ContentCommand;
import kr.co.db_input.command.DeleteCommand;
import kr.co.db_input.command.ListCommand;
import kr.co.db_input.command.UpdateCommand;
import kr.co.db_input.command.UpdateOkCommand;
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
		
		return "redirect:list"; // response.sendRedirect("list.jsp")
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws SQLException { // DB에 있는 내용을 출력
		// 해당 Command파일 생성, Dao_input에 list와 관계된 메소드
		ListCommand lc = new ListCommand();
		lc.execute(model);
		
		return "/list";
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) throws SQLException { // 1명의 레코드를 보여주기
		// Command 호출
		String id = request.getParameter("id"); 
		ContentCommand cc = new ContentCommand();
		Dto_input dto_input = cc.execute(id, model);
		model.addAttribute("dto_input",dto_input);
		
		return "/content";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws SQLException {
		// 삭제 Command 호출
		DeleteCommand dc = new DeleteCommand();
		dc.execute(request.getParameter("id"));
		return "redirect:/list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) throws SQLException {
		// 수정 Command 호출
		UpdateCommand uc = new UpdateCommand();
		String id = request.getParameter("id");
		uc.execute(id, model);
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Dto_input dto_input) throws SQLException {
		 // update_ok Command 실행
		UpdateOkCommand uoc = new UpdateOkCommand();
		uoc.execute(dto_input);
		return "redirect:/content?id="+dto_input.getId();
	}
}
