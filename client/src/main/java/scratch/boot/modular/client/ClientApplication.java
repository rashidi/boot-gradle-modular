package scratch.boot.modular.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import scratch.boot.modular.service.ServiceApplicationConfiguration;

@SpringBootApplication
@Import(ServiceApplicationConfiguration.class)
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
