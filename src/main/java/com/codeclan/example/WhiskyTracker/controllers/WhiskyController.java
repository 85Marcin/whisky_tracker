package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;



    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskyByYear(
            @RequestParam(name="year", required = false)  Integer year,
            @RequestParam(name="distillery_id") Long id,
            @RequestParam(name="age") int age
    ){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if(id != null && age != 0 ) {
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryId(age, id), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value="/whiskies")
//    public ResponseEntity<Whisky> findByAgeFromDistillery(@RequestParam Long id, @RequestParam int age){
//
//    }
}



