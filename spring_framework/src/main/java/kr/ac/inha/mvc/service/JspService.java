package kr.ac.inha.mvc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public class JspService {
	int count = 0;

	public String count() {
		return count++ + " ";
	}
}