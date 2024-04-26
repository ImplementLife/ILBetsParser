package il.bets.server.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/tst")
    public String tst() {
        return "test";
    }
}
