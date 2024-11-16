package com.example.crud.repository;
import com.example.crud.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    //controller --> Srevices --> Repository
    //controllers calls Services --> Services Calls Repositories for the execution
    //working -->> what to work on -->> the DB to preform/update the task
}
