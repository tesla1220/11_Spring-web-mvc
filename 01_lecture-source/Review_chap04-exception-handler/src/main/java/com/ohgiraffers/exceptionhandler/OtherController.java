package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("other-contoller-null")
    public String otherNullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    // 얘는 GlobalExceptionHandler 클래스 내
    //   @ExceptionHandler(Exception.class)
    //   public String nullPointerExceptionHandler(Exception exception){
    //
    //        return "error/default";
    //    }
    // 로 가서 default.html 이 보여지게 됨


    @GetMapping("other-controller-user")
    public String otherUserExceptionTest() throws MemberRegistException {

        boolean check = true;
        if(check) {
            throw new MemberRegistException("You again! ");
        }
        return "/";
    }

    @GetMapping("other-controller-array")
    public String otherArrayExceptionTest() {

        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }

}
