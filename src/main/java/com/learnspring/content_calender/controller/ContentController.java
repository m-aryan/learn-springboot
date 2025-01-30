package com.learnspring.content_calender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.content_calender.model.Content;
import com.learnspring.content_calender.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {

   private final ContentCollectionRepository repository;

   @Autowired
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
       return repository.findAll();
    }
}
