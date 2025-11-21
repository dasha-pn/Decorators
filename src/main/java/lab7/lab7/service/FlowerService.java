package lab7.lab7.service;

import lab7.lab7.repository.flower.Flower;
import lab7.lab7.repository.flower.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    private final FlowerRepository repo;

    public FlowerService(FlowerRepository repo) {
        this.repo = repo;
    }

    public List<Flower> getFlowers() {
        return repo.findAll();
    }

    public Flower addFlower(Flower f) {
        return repo.save(f);
    }
}
