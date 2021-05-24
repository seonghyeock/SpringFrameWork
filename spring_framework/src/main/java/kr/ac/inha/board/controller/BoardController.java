package kr.ac.inha.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}

	@RequestMapping("/inha")
	// /inha?param=www.
	public String inha(String param) {
		return param + "inha.ac.kr";
	}

	@RequestMapping("/name")
	public String name(String id) {
		return "당신의 학번은 : " + id;
	}

	@RequestMapping("/num")
	public String table(String num) {
		String str = "";
		int n = Integer.parseInt(num);
		for (int i = 1; i < 10; i++) {
			str = str + num + " * " + Integer.toString(i) + " = " + Integer.toString(n * i) + " ";
		}
		return str;
	}
	
	@RequestMapping("/hello.do")
	public String hellodo() {
		return "hello";
	}
}
