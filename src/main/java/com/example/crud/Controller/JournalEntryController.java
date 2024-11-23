package com.example.crud.Controller;
import com.example.crud.Entity.JournalEntry;
import com.example.crud.Entity.User;
import com.example.crud.Service.JournalEntryService;
import com.example.crud.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUsername(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) {
        try {
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}") //to get the data by ID
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName){
        journalEntryService.deleteById(myId, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("id/{userName}/{id}") //to update the data
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id,
                                               @PathVariable String userName,
                                               @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
