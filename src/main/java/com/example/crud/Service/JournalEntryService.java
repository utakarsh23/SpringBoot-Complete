package com.example.crud.Service;

import com.example.crud.Entity.JournalEntry;
import com.example.crud.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService { //services such as search, find, delete and post

    @Autowired
    private JournalEntryRepository journalEntryRepository; //to take data from the repo(DB) //dependency injection

    //
    //-->> .save / .findAll / .findById / .deleteById ----> all are provided inside the mongodb repo
    //

    public void saveEntry(JournalEntry journalEntry) { //method to save(Post) the operation
                                                        //void because it does not return anything, it takes data
        journalEntryRepository.save(journalEntry); //making connection with DB using the repo and saving it
    }

    public List<JournalEntry> getAll() { //to get all the list of posted/(DB content)
        return journalEntryRepository.findAll(); //all contents to be printed from DB
        //returning list, as the data is to be presentend in JSON rn
    }

    public Optional<JournalEntry> findById(ObjectId id) { //<Opt> because it isn't sure if the searched id exists not
        return journalEntryRepository.findById(id); // returns the founded ID if found else returns null, so optional works here
    }

    public void deleteById(ObjectId id) { //to delete the Data by ID
        journalEntryRepository.deleteById(id); //to delete the items
        //returns nothing
    }
}
