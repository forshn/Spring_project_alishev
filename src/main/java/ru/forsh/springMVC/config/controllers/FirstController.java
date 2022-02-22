package ru.forsh.springMVC.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


// хорошая практика класть все представления, которые есть в контроллере
// в папку названную по имени контроллера (first/...)

@Controller
@RequestMapping("/first")
public class FirstController {


    // required - если мы не пишем запрос в URL - то будет лежать NULL, не 404 ошибка
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);
        // System.out.println("name: " + name + ", surname: " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calc(@RequestParam("action") String action,
                        @RequestParam("1") int firstNumber,
                        @RequestParam("2") int secondNumber,
                        Model model) {

        Integer result = switch (action) {
            case "mult" -> firstNumber * secondNumber;
            case "add" -> firstNumber + secondNumber;
            case "sub" -> firstNumber - secondNumber;
            case "div" -> firstNumber / secondNumber;
            default -> null;
        };

        model.addAttribute("result", result);

        return "first/calculator";

    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
