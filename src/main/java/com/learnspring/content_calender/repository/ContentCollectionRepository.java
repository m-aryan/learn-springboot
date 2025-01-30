package com.learnspring.content_calender.repository;

import com.learnspring.content_calender.model.Content;
import com.learnspring.content_calender.model.Status;
import com.learnspring.content_calender.model.Type;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.Id().equals(id)).findFirst();
    }
    
    @PostConstruct
    public void init() {
        Content c = new Content(
            1,
            "My First Blog Post", 
            "This is a Test Piece of Content", 
            Status.IDEA, 
            Type.ARTICLE, 
            LocalDateTime.now(), 
            null, 
            "");

        content.add(c);
    }
}
