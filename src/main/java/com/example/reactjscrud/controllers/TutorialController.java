package com.example.reactjscrud.controllers;

import com.example.reactjscrud.entities.Tutorial;
import com.example.reactjscrud.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService service;

    @GetMapping("")
    public List<Tutorial> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getById(@PathVariable Integer id) {
        try {
            Tutorial tutorial = service.getById(id);
            return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Tutorial>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Tutorial> insert(@RequestBody Tutorial tutorial) {
        Tutorial tutorial1 = service.save(tutorial);
        return new ResponseEntity<>(tutorial1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tutorial tutorial, @PathVariable Integer id) {
        try {
            service.getById(id);
            service.save(tutorial);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getByPublished() {
        try {
            List<Tutorial> tutorials = service.getTutorialsByPublished(Byte.parseByte("1"));
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Tutorial>> getByNameContains(@PathVariable String name) {
        try {
            List<Tutorial> tutorials = service.findByNameContaining(name);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
