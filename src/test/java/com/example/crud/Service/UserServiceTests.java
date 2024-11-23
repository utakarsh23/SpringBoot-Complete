package com.example.crud.Service;

import com.example.crud.Entity.User;
import com.example.crud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalEntryService journalEntryService;

    @Test
    public void testFindByUserName() {
        User user = userRepository.findByUserName("Shresth");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Shresth",
            "Yashika",
            "Shaurya"

    })
    public void testFindByUserNames(String username) {
        User user = userRepository.findByUserName(username);
        assertTrue(!user.getJournalEntries().isEmpty(), "failed for username " + username);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "4,5,10",
            "3,9,12"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b, "failed for " + a + " and " + b);
    }
}
