package com.example.crud.Controller;
import com.example.crud.Entity.JournalEntry;
import com.example.crud.Service.JournalEntryService;
import com.sun.net.httpserver.HttpsServer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal") //for
public class JournalEntryControllerV2 { //Tasks are preformed by this page

    @Autowired
    private JournalEntryService journalEntryService; //injecting depenedency -->> it's same as
    // /*JournalEntryServices journalEntryService = new JournalEntryServices*/


    @GetMapping
    public ResponseEntity<?> getAll() { //to get all the data in DB
        ; //getAll()(controller) gets into JournalEntryService(Services) to run the method and get all the data from the
        //database by going into repository(repository) to call data from the DB...
        List<JournalEntry> all = journalEntryService.getAll();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) { //to post the data into the DB
//        myEntry.setDate(LocalDateTime.now()); //time to at what time the data was posted
//        journalEntryService.saveEntry(myEntry); //saveEntry()(controller) gets into JournalEntryService(Services) to run the method and save the data to the
//        //database by going into repository(repository) to save data into the DB...
//        return myEntry; //after saving it is returns the posted data
//    }
    @PostMapping //check above comments
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(HttpStatus.CREATED); //201 CREATED
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400 BAD REQUEST
        }
    }

    @GetMapping("id/{myId}") //to get the data by ID
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){ //@PathVariable helps us search by the path
        //localhost:8082/journal/{myId} --> here myId is variable and it varies and also it is due to Pathvariable that myId is a part of Path.
//
//        return journalEntryService.findById(myId).orElse(null); //it returns the ID Details if it exists and then returns it
        //to the user but if not found then it returns null --->>> removed to have HTTP Responses correctly


        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId); //optional cause there Id may be present or maybe not
        if(journalEntry.isPresent()) { //if it exists then it checks whether the id is present or not and if it is then
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK); //200-OK //ResponseEntity is feature of SpringBoot which takes journalEntry
        } //and gets the HTTP Response defined by the user(Correctly)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //if not found then response will be 404-BAD REQUEST
    }

    @DeleteMapping("id/{myId}") //to delete the data by ID
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){ //same as above
        journalEntryService.deleteById(myId); //deleteById(myId) it goes into Services and then Repo and searches ID t Delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //returns true after deletion
    }

    @PutMapping("id/{id}") //to update the data
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) { //PathVariable to check & update data of the specific Id
        //RequestBody is to update the contents of the body
        JournalEntry old = journalEntryService.findById(id).orElse(null); //to find the Id to be updated//same as PostMapping, if not found returns null
        if(old != null) { //condition if teh entered data isn't null
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            //here the oldTitle is being set equal to the newEntry(Title) if newly updated title does not equal to null or any space/blank/indent("").
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            //here the oldContent is being set equal to the newEntry(Content) if newly updated content does not equal to null or any space/blank/indent("").
            journalEntryService.saveEntry(old); //here after the operation the updated(if) is being saved to the DB
            return new ResponseEntity<>(old, HttpStatus.OK) ; //returning the updated(if)
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
