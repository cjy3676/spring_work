package kr.co.work;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.work.dto.Dto;

@Controller
public class MyController { // 나의 컨트롤러 클래스 
	@RequestMapping("/test")
	public String test() {
		return "/test";
	}
	
	@RequestMapping("/input_home")
	public String input_home() {
		return "/input_home";
	}
	
	@RequestMapping("/input_view") // 사용자의 요구(페이지)
	public String input_view(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		// 메소드 내에서 할일을 처리
		// request로 읽어오기
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		// model로 값 추가
		model.addAttribute("name",name); // 변수명, 값
		model.addAttribute("age",age);
		model.addAttribute("addr",addr);
		
		// return
		return "/input_view";
	}
	
	@RequestMapping("/input_home2")
	public String input_home2() {
		return "/input_home2";
	}
	
	@RequestMapping("/input_view2")
	public String input_view2(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("addr") String addr, Model model) {
		// @RequestParam("읽어온값") String 사용할 변수
		model.addAttribute("name",name); // 변수명, 값
		model.addAttribute("age",age);
		model.addAttribute("addr",addr);
		
		return "/input_view2";
	}
	
	@RequestMapping("/input_home3")
	public String input_home3() { 
		return "/input_home3";
	}
	
	@RequestMapping("/input_view3")
	public String input_view3(HttpServletRequest request, Model model) {
		// Dto에서 get,set으로 하는 방식
		Dto dto = new Dto();
		dto.setName(request.getParameter("name"));
		dto.setAge(request.getParameter("age"));
		dto.setAddr(request.getParameter("addr"));
		
		model.addAttribute("dto",dto);
		return "/input_view3";
	}
	
	@RequestMapping("/input_home4")
	public String input_home4() {
		return "/input_home4";
	}
	
	@RequestMapping("/input_view4")
	public String input_view4(Dto dto) {   
		// Dto로 하는 방식
		return "/input_view4";
	}
	
	@RequestMapping("/path_var/{id}")
	public String path_var(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return "/path_var";
	}
}
