package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class JsonViewController {
	
	@ModelAttribute
	public void modelAttribute(Model model) {
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("rangers", rangers);	
	}
	
	//레인져스 정보를 json으로 응답을 생성하는 url요청
	@RequestMapping("/rangersJsonView")
	public String rangersJsonView() {
		
		//JSON 타입으로 json 을 생성하려면 json 을 직접 생성해야 한다 
		//{"rangers":["brown","cony","sally"]}
		//spring에서 object 정보를 json 문자열로 생성해줌
		
		//json을 생성하는 view 리턴
		//viewName이 아닌 beanName을 리턴하고있음
		return "jsonView";
		//<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
		
		//controller에서 리턴하는 viewName(jsonView)를 처리하기위해
		//처리해줄 viewResolver를 우선순위에 따라서
		//1. beanNameViewResolver를 통해 view를 생성하려고 시도하게됨
		//2. jsonView라고 하는 이름의 빈이 있는 지를 확인 > 존재함
		//3. beanNameViewResolver 해당 viewName과 동일한 이름의 빈이 있으므로
		// internalViewResolver까지 가지 않고 beanNameViewResolver에서 처리하게 됨
		
		//만약 viewName이 "hello"인 경우라면
		//처리해줄 viewResolver를 우선순위에 따라서
		//1. beanNameViewResolver를 통해 view를 생성하려고 시도하게됨
		//2. hello라고 하는 이름의 빈이 있는 지를 확인 > 없음
		//3. 다음 우선순위인 internalREsourceViewResolver가 처리하게됨
		//4. internalViewResolver는 해당 리소스(hello.jsp)가 있는지 여부를
		//	확인 하지 않고 prefix, suffix를 반영하여 forward함
		// 	따라서 오타, 존재하지 않는 파일(jsp)를 리턴한다.
		// 	그래서 에러가 발생함
		// 	그런 이유로 InternalResourceViewResolver는 최 하위 우선순위로 둠
	}
	
	@RequestMapping("/rangersJsonViewObj")
	public View rangersJsonViewObj() {	
		//json 생성을 담당하는 View
		return new MappingJackson2JsonView();
	}
	
	
}
