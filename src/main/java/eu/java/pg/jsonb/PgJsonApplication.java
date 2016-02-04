package eu.java.pg.jsonb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class PgJsonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PgJsonApplication.class, args);
    }
}
