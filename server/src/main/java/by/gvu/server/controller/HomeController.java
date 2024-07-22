package by.gvu.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @GetMapping("/exception")
    public String exception() throws InterruptedException {
        log.info("let's wait a little");
        Thread.sleep(5000);
        log.info("We waited. Now let's return the result");

        return "Hello World";
    }
}
