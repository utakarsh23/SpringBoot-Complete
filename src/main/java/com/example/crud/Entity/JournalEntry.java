package com.example.crud.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "journal_entries") /* Document(Row) named journal_entries  --> it says that the following class is mapped with the mongoDB */
@Data //Lombok library, it reduces boilerplate code such as getter, setters, constructors and more

public class JournalEntry {

    @Id //to map as primary key
    private ObjectId id; //id as an object

    private String title; //title of the Description
    private String content; //Description / Items to be written to post
    private LocalDateTime date; //Time so that we can check the posted time of the item

}
