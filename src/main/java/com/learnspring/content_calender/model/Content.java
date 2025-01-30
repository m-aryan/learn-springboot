package com.learnspring.content_calender.model;

import java.time.LocalDateTime;

public record Content(
        Integer Id,
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

}
