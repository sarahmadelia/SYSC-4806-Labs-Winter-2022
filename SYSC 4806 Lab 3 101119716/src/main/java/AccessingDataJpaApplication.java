import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * Updated for Lab 4
 *
 * @author Sarah Abdallah
 * @version 2022-01-26
 */
@SpringBootApplication
public class AccessingDataJpaApplication {
    private static final Logger log=LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository){
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("Litza", "123"));
            repository.save(new BuddyInfo("Celine", "456"));
            repository.save(new BuddyInfo("Lyl", "789"));
            repository.save(new BuddyInfo("Mohini", "1234"));
            repository.save(new BuddyInfo("Ruth", "45678"));
            repository.save(new BuddyInfo("Melissa", "6789"));
            repository.save(new BuddyInfo("Jess", "87654"));
            repository.save(new BuddyInfo("Martha", "90742"));

            // fetch all customers
            log.info("--------------------------------------------");
            log.info("Buddies found with findAll():");
            repository.findAll().forEach(buddyInfo -> log.info(buddyInfo.toString()));
            log.info("");

            // fetch an individual customer by ID
            log.info("--------------------------------------------");
            log.info("Buddy found with findById(1L):");
            BuddyInfo buddyInfo=repository.findById(1L);
            log.info(buddyInfo.toString());
            log.info("");

            // fetch customers by last name
            log.info("--------------------------------------------");
            log.info("Buddy found with findByName('Litza'):");
            repository.findByName("Litza").forEach(litza -> log.info(litza.toString()));
            log.info("");

            log.info("Buddy found with findByPhoneNumber('456'):");
            buddyInfo=repository.findByPhoneNumber("456");
            log.info(buddyInfo.toString());
            log.info("");
        };
    }

    public static void main(String[] args){
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

}
