package kg.levixur.anilist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/random")
public class RandomController {

    private final List<String> names = List.of(
            "Эрен", "Леви", "Микаса", "Армин", "Саша",
            "Эрвин", "Конни", "Хистория", "Кенни", "Энни"
    );

    private final Random random = new Random();

    @GetMapping
    public String getRandomName() {
        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }
}