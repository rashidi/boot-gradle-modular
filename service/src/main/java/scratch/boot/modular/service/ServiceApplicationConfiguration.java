package scratch.boot.modular.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Rashidi Zin
 */
@Configuration
@EntityScan
@EnableJpaRepositories
public class ServiceApplicationConfiguration {
}
