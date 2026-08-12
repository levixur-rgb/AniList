package kg.levixur.anilist.controller;

import kg.levixur.anilist.dto.hello.request.GreetingCreateRequest;
import kg.levixur.anilist.entity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping (value = "/hello")
public class HelloController {
    private final List<Greeting> greetings = new ArrayList<>();
    private final Random random = new Random();

    @GetMapping
    public String Hello() {
        return "Hello";
    }

    @PostMapping
    public String addGreeting(@RequestBody GreetingCreateRequest request) {
        Greeting greeting = new Greeting();
        greeting.setId(random.nextLong());
        greeting.setGreeting(request.greeting());

        greetings.add(greeting);

        return "Приветствие успешно добавлено!"; // Добавь эту строку
    }

}