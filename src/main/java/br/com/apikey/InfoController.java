package br.com.apikey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    String info(){
        return "Somente informação do projeto, não precisa de API_KEY";
    }
}
