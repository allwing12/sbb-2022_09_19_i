package com.mysite.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MainController {
    public static int i = 1;


    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
        System.out.println("sbb");
        return "sbb";
    }
    @RequestMapping("/saveSessionAge")
    @ResponseBody
    public String saveSession (@RequestParam("age")int age, HttpSession session) {
        session.setAttribute("age", age);
        return "나이 %d이 세션에 저장 되었습니다.".formatted(age);
    }
    @RequestMapping("/getSessionAge")
    @ResponseBody
    public String getSession (HttpSession session, HttpServletResponse res) {
        int age = (int) session.getAttribute("age");
        Cookie cookie = new Cookie("age",String.valueOf(age));
        res.addCookie(cookie);
        return "세션에 저장된 나이는 %d입니다.".formatted(age);
    }

    @GetMapping("/addPerson/{id}")
    @ResponseBody
    public Person addPerson(Person person) {
        return person;
    }
}

@Getter
@AllArgsConstructor
class Person {
    private int id;
    private int age;
    private String name;
}