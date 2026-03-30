package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    // injektoidaan repository testiä vartem
    @Autowired
    private UserRepository userRepository;

    // testi: uuden userin luonti
    @Test
    public void createNewUser() {
        User user = new User("uusikayttaja", "123password", "uusikayttaja@email.com", "user");

        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    // testi: userin haku
    @Test
    public void findByUsername() {

        User user = new User("uusikayttaja", "123password", "uusikayttaja@email.com", "user");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("uusikayttaja");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("uusikayttaja@email.com");
    }

    // testi: userin poistaminen
    @Test
    public void deleteUser() {
        User user = new User("uusikayttaja", "123password", "uusikayttaja@email.com", "user");
        userRepository.save(user);

        // poistetaan lisätty user
        userRepository.delete(user);

        User foundUser = userRepository.findByUsername(user.getUsername());

        assertThat(foundUser).isNull();
    }

}
