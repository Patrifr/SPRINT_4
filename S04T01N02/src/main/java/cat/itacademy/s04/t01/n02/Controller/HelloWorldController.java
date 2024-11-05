package cat.itacademy.s04.t01.n02.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class HelloWorldController {

    @GetMapping(value = { "/HelloWorld" })
    @ResponseBody
    public String greet(@RequestParam(value = "name", defaultValue = "UNKNOWN") String name){
    return String.format("Hello %s", name) + ", you are executing a Gradle project";
    }

    @GetMapping(value = { "/HelloWorld2", "/HelloWorld2/{name}" })
    @ResponseBody
    public static String greet2(@PathVariable(value = "name", required = false) String name) {
    name = name!= null ? name : "UNKNOWN";
    return String.format("Hello %s", name) + ", you are executing a Gradle project";
    }
}
