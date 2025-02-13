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
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    public void init() {
        Content content = new Content(
                1,
                "First Post",
                "This is a Test Piece of Content",
                Status.IDEA,
                Type.CONFERENCE_TALK,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}