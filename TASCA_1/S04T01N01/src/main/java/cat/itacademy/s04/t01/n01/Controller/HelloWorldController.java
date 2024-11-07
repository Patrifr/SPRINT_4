package cat.itacademy.s04.t01.n01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(value = { "/HelloWorld" })
    @ResponseBody
    public String greet(@RequestParam(value = "name", defaultValue = "UNKNOWN") String name){
        return String.format("Hello %s", name) + ", you are executing a Maven project";
    }

    @GetMapping(value = { "/HelloWorld2", "/HelloWorld2/{name}" })
    @ResponseBody
    public static String greet2(@PathVariable(value = "name", required = false) String name) {
        name = name!= null ? name : "UNKNOWN";
        return String.format("Hello %s", name) + ", you are executing a Maven project";
    }
}
