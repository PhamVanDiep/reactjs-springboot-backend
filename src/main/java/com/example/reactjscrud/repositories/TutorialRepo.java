package com.example.reactjscrud.repositories;

import com.example.reactjscrud.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepo extends JpaRepository<Tutorial, Integer> {
    public List<Tutorial> findByPublished(Byte published);
    public List<Tutorial> findByNameIsContainingIgnoreCase(String name);
}
