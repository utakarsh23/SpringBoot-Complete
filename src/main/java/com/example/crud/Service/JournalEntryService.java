package com.example.crud.Service;

import com.example.crud.Entity.JournalEntry;
import com.example.crud.Entity.User;
import com.example.crud.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository; //to take data from the repo(DB) //dependency injection
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
            try {
                User user = userService.findByUserName(userName);
                journalEntry.setDate(LocalDateTime.now());
                JournalEntry saved = journalEntryRepository.save(journalEntry);
                user.getJournalEntries().add(saved);
//                user.setUserName(null);
                userService.saveUser(user);
            } catch (Exception e) {
                System.out.println(e);
                throw new RuntimeException("An error has been occurred while saving journal entry");
            }
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() { //to get all the list of posted/(DB content)
        return journalEntryRepository.findAll(); //all contents to be printed from DB
        //returning list, as the data is to be presented in JSON rn
    }

    public Optional<JournalEntry> findById(ObjectId id) { //<Opt> because it isn't sure if the searched id exists not
        return journalEntryRepository.findById(id); // returns the founded ID if found else returns null, so optional works here
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
                }
            }
            catch (Exception e) {
                System.out.println(e);
                throw new RuntimeException("An error has been occurred while deleting journal entry");
        }
        return removed;
    }
}
