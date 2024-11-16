package com.example.crud.Service;

import com.example.crud.Entity.JournalEntry;
import com.example.crud.Entity.User;
import com.example.crud.repository.JournalEntryRepository;
import com.example.crud.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id); //
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
        //returns nothing
    }
    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}