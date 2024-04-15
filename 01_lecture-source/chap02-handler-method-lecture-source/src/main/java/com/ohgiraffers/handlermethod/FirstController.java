package com.ohgiraffers.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
public class FirstController {

    /* 필기
        컨트롤러의 핸들러 메소드의 반환값을 void 형으로 설정하게 되면
        요청 주소가 view의 이름이 된다.
        => first/regist 요청이 들어오면 /first/regist 뷰를 응답한다.
     */
    @GetMapping("/regist")
    public void regist() {}

    /* 필기.
    *   WebRequest 로 요청 파라미터 전달 받기
    *   WebRequest 라는 녀석은 HttpServletRequest 의 정보를 대부분 가지고 있는 API로
    *   Servlet 에 관여받지 않는다.
    *   WebRequest는 Spring 의 일부이기 때문에 Servlet을 사용하는 것처럼 동일하게 사용할 수 있다.
    * */

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에" +
                price + "원으로 등록했습니다.!!";

        model.addAttribute("message", message);

        return "first/messagePrinter";

    }

    @GetMapping("/modify")
    public void modify() {}

    /* 필기.
    *   아무값도 넘기지 않았을 때
    *   required 속성의 디폴트 값은 true
    *   이 required 속성을 false 로 하게 되면 해당 name 값이 존재하지 않아도 null 로 처리하며 에러가 발생하지 않는다.
    *   또한, defaultValue 를 사용하게 되면 기본값으로 사용할 수 있다. */

    @PostMapping("modify")
    public String modifyMenuPrice(Model model,
                                  @RequestParam(required = false) String modifyName,
                                  @RequestParam(defaultValue = "0") int modifyPrice) {

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다!!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {

        String modifyMenu = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = modifyMenu + "메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다!!";

        model.addAttribute("message", message);

        return "first/messagePrinter";

    }

    @GetMapping("/search")
    public void search() {}
    
    /* 필기. 
    *   3. @ModelAttribute 를 이용하는 방법
    *   DTO 같은 모델을 커맨드 객체로 전달받는다. 
    *   @ModelAttribute("모델에 담을 key 값")
    *   만약 이름을 정하지 않았다면? -> 타입의 앞글자를 소문자로 변경 (네이밍 규칙)
    *   @ModelAttribute 어노테이션은 생략이 가능하지만 명시적으로 작성하는 것이 좋다.
    *
    * */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute MenuDTO menu) {

        System.out.println("menu = " + menu);

        return "first/searchResult";
    }

}
