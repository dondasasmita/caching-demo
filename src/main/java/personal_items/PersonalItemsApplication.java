package personal_items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PersonalItemsApplication {

    public static void main(String[] args) {

        SpringApplication.run(PersonalItemsApplication.class,args);

    }
}
