package com.example.crud.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users") /* Document(Row) named users */
@Data //Lombok library, it reduces boilerplate code such as getter, setters, constructors and more

public class User {
//
    @Id //to map as primary key
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull //lombok-> ensures that it's not null
    private String userName;
    @NonNull
    private String password;
    @DBRef //database reference
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;
}
