package com.woolie.CarehomeApi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {

    @GetMapping
    public ResponseEntity<String> getAllApplications() {
        return ResponseEntity.ok("Hello from backend");
    }

//    @PostMapping
//    public String createApplication() {
//
//    }
//
//    @PutMapping
//    public String updateApplication() {
//
//    }
//
//    @GetMapping(path = "/{id}")
//    public String getApplication() {
//
//    }
//
//    @DeleteMapping
//    public String deleteApplication() {
//
//    }
}
