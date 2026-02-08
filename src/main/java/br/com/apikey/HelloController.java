package br.com.apikey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    String hello(){
        return "Você acabou de acessar com API_KEY";
    }
}
