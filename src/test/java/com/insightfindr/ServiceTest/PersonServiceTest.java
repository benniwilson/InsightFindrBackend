package com.insightfindr.ServiceTest;

import com.insightfindr.exception.PersonNotFoundException;
import com.insightfindr.model.Person;
import com.insightfindr.repository.PersonRepository;
import com.insightfindr.service.PersonServiceImpl;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonServiceTest {

    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonServiceImpl service;

    @Test
    @DisplayName("getPersonById throws exception if id isn't recognised")
    public void test_getPersonById_wrongId(){
        String id = "LMEE12";
        Throwable exception = assertThrows(PersonNotFoundException.class, () -> service.getPersonById(id));
        assertEquals("No user with id: LMEE12, was found in the system", exception.getMessage());
    }

    @Test
    @DisplayName("getPersonById returns correct Person")
    public void test_getPersonById_correctId() throws Exception {
        String id = "QWERTY123";
        Optional<Person> person = Optional.of(Person.builder()
                .user_id(id)
                .email("user@gmail.com")
                .password("password123")
                .build()
        );
        when(repository.findById(id)).thenReturn(person);
        Person result = service.getPersonById(id);
        assertThat(person.get()).isEqualTo(result);
    }
}
