package com.springboot.jpahibernate.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.springboot.jpahibernate.controller.UserController;
import com.springboot.jpahibernate.entity.User;
import com.springboot.jpahibernate.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    //@Autowired
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    User userJohn = new User(1L, "john", "12345678", "john", "doe", "john@email.com",21, true);
    User userTom = new User(1L, "tom", "12345678", "tom", "doe", "tom@email.com",21, true);

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getAllUsers_test() throws Exception{
        List<User> records = new ArrayList<>(Arrays.asList(userJohn, userTom));
        Mockito.when(userRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstname").value("john"))
                .andExpect(jsonPath("$[1].firstname").value("tom"));
    }
/*
    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        final MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder().with("lastname", ":", "doe");

        final Iterable<MyUser> results = userRepository.findAll();
        assertThat(results, containsInAnyOrder(userJohn, userTom));
    }

    @Test
    public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
        final MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder().with("firstname", ":", "john").with("lastname", ":", "doe");
        //final Iterable<MyUser> results = userController.findAllByWebQuerydsl(builder.build());
        final Iterable<MyUser> results = userRepository.findAll(builder.build());

        assertThat(results, contains(userJohn));
        assertThat(results, not(contains(userTom)));
    }

    @Test
    public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
        final MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder().with("lastname", ":", "doe").with("age", ">", "25");

        final Iterable<MyUser> results = userRepository.findAll(builder.build());

        assertThat(results, contains(userTom));
        assertThat(results, not(contains(userJohn)));
    }

    @Test
    public void givenWrongFirstAndLast_whenGettingListOfUsers_thenCorrect() {
        final MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder().with("firstname", ":", "adam").with("lastname", ":", "fox");

        final Iterable<MyUser> results = userRepository.findAll(builder.build());
        assertThat(results, emptyIterable());
    }

    @Test
    public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
        final MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder().with("firstname", ":", "jo");

        final Iterable<MyUser> results = userRepository.findAll(builder.build());

        assertThat(results, contains(userJohn));
        assertThat(results, not(contains(userTom)));
    }

 */
}