package com.example.crud.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Document(collection = "journal_entries") /* Document(Row) named journal_entries  --> it says that the following class is mapped with the mongoDB */
public class JournalEntry {

    @Id //to map as primary key
    private ObjectId id; //id as an object
    private String title; //title of the Description
    private String content; //Description / Items to be written to post
    private LocalDateTime date; //Time so that we can check the posted time of the item


    //getters and setters
    public LocalDateTime getDate() { //LocalDateTime -> func with time n things to work
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
