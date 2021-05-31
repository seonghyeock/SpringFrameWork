package kr.ac.inha.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.mvc.service.JspService;

@Controller
public class JspController {
	// @Autowired는 객체를 하나로 관리하게 해 줌
	//@Autowired
	//JspService jspService;
	JspService jspService = new JspService();

	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}

	@RequestMapping("/helloJsp.do")
	public String helloJsp() {
		return "hello";
	}

	@RequestMapping("/gugudan")
	// int 대신 Integer: Integer는 null을 입력받을 수 있어서 예외 처리(파라미터 없을 때) 가능
	public ModelAndView gugudan(Integer n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gugudan");

		if (n != null) {
			String result = "구구단: ";
			for (int i = 1; i <= 9; i++) {
				result = result + n + "*" + i + "=" + (n * i) + " ";
			}
			mv.addObject("guguJsp", result);
		}
		mv.addObject("title", "구구단");
		return mv;
	}

	@RequestMapping("/sum")
	public ModelAndView sum() {
		ModelAndView mv = new ModelAndView();
		// gugudan jsp 재활용 가능
		mv.setViewName("gugudan");
		int sum = 5050;
		mv.addObject("guguJsp", sum);
		mv.addObject("title", "1부터 100까지의 합");
		return mv;
	}

	@RequestMapping("/board.do")
	public ModelAndView board(@RequestParam(value = "title", required = false, defaultValue = "과목정보") String subName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", subName);
		mv.setViewName("board");

		mv.addObject("count", jspService.count());
		return mv;
	}
}
