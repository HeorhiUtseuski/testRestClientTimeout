package by.gvu.client.controller;

import by.gvu.client.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleService simpleService;

    @GetMapping("/check")
    public String check() {
        return simpleService.sayHelloFromServer();
    }
}
