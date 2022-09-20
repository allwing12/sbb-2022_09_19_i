package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    public static int i = 1;

//    @RequestMapping("/sbb")
//    @ResponseBody
//    public String index() {
//        System.out.println("sbb");
//        return "sbb";
//    }

    @GetMapping("/plus")
    @ResponseBody
    public int plus(int a, int b) {
        return a+b;
    }


    @GetMapping("/minus")
    @ResponseBody
    public int minus(int a, int b) {
        return a-b;
    }

    @GetMapping("/increase")
    @ResponseBody
    public int increase () {
        if (i < 3){
            ++i;
        } else if (i <= 3) {
            i = 1;
        }
        return i;
    }

    @GetMapping("gugudan")
    @ResponseBody
    public String gugudan (int dan, int limit) {
        String result = "";
        for(int i = 1; i <= limit; i++) {
            result += dan + " * " + i + " = " + (dan * i) + "<br/>\n";
        }
        return result;
    }
}