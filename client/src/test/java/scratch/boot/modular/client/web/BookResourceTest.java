package scratch.boot.modular.client.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import scratch.boot.modular.service.book.Book;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Maps.newHashMap;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author Rashidi Zin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BookResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void create() {
        ResponseEntity<Book> response = restTemplate.postForEntity(
                URI.create("/books/"),
                new Book("Rudyard Kipling", "Jungle Book"),
                Book.class
        );

        assertThat(response)
                .extracting("statusCode", "headers.location")
                .containsExactly(CREATED, URI.create("/books/1"));
    }

    @Test
    public void findByAuthor() {
        restTemplate.postForEntity(
                URI.create("/books/"),
                new Book("Rudyard Kipling", "Jungle Book"),
                Book.class
        );

        assertThat(
                restTemplate.getForEntity(
                        "/books/author={author}",
                        List.class,
                        newHashMap("author", "Rudyard Kipling")
                ).getBody()
        )
                .hasSize(1);
    }

}