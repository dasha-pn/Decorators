package lab7.lab7.controller;

import lab7.lab7.repository.flower.Flower;
import lab7.lab7.service.FlowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping
    public List<Flower> getAll() {
        return flowerService.getFlowers();
    }

    @PostMapping
    public Flower add(@RequestBody Flower flower) {
        return flowerService.addFlower(flower);
    }
}
