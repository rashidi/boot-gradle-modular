package scratch.boot.modular.client.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import scratch.boot.modular.service.book.Book;
import scratch.boot.modular.service.book.BookRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rashidi Zin
 */
@RestController
@AllArgsConstructor
public class BookResource {

    private BookRepository repository;

    @PostMapping("/books")
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        Book persisted = repository.save(book);

        URI uri = UriComponentsBuilder
                .fromPath("/books/{id}")
                .buildAndExpand(persisted.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam("author") String author) {
        return ResponseEntity.ok(
                repository.findByAuthor(author).collect(Collectors.toList())
        );
    }

}
