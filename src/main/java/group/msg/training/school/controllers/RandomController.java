package group.msg.training.school.controllers;

import group.msg.training.school.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/random")
public class RandomController {
    private final RandomNumberGenerator generator;

    @Autowired
    public RandomController(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    @GetMapping(value = "/integers", produces = "application/json")
    public Set<Integer> integers(@RequestParam int count, @RequestParam int min, @RequestParam int max) {
        return generator.generateIntegers(count, min, max);
    }
}
