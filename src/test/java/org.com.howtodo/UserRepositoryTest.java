package org.com.howtodo;

import org.com.howtodo.beans.User;
import org.com.howtodo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
        User user1= new User(1, "Alice");
        User user2= new User(2, "Bob");
        //save user, verify has ID value after save
        //assertNull(user1.getId());
        //assertNull(user2.getId());//null before save

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());

    }

    @Test
    public void testFetchData(){
        User userA = userRepository.findAll().get(0);
        assertNotNull(userA);
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }
        assertEquals(count, 2);

    }
}
