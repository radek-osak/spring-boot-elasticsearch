package com.ara.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "blog", type = "post")
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    private boolean isPublished;
    private Calendar publishingDate;
    private Calendar creationDate;
    private String author;
}
