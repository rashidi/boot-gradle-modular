package scratch.boot.modular.service.book;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.test.context.junit4.SpringRunner;
import scratch.boot.modular.service.ServiceApplicationConfiguration;
import scratch.boot.modular.service.audit.AuditConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

/**
 * @author Rashidi Zin
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @Filter(
        type = ASSIGNABLE_TYPE,
        classes = {ServiceApplicationConfiguration.class, AuditConfiguration.class})
)
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private BookRepository repository;

    @Before
    public void create() {
        em.persistAndFlush(new Book("Rudyard Kipling", "Jungle Book"));
    }

    @Test
    public void findByAuthor() {
        assertThat(repository.findByAuthor("Rudyard Kipling")).hasSize(1);
    }

}