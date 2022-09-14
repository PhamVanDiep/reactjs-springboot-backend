package com.example.reactjscrud.services;

import com.example.reactjscrud.entities.Tutorial;
import com.example.reactjscrud.repositories.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepo repo;

    public List<Tutorial> getAll() {
        return repo.findAll();
    }

    public Tutorial getById(Integer id) {
        return repo.findById(id).get();
    }

    public Tutorial save(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Tutorial> getTutorialsByPublished(Byte published) {
        return repo.findByPublished(published);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public List<Tutorial> findByNameContaining(String name) {
        return repo.findByNameIsContainingIgnoreCase(name);
    }
}
