package edu.cmu.odw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cmu.odw.model.Author;
import edu.cmu.odw.service.AuthorService;


@Configuration
public class SeedData {

    @Autowired
    private AuthorService authorService;
    
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    public SeedData getBean() {
        
        Author a1 = new Author("Douglas Adams");
        Author a2 = new Author("Gautama Buddha");
        Author a3 = new Author("Albert Einstein");
        
        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);
        
        log.info("Quoates found with findAll():");
        log.info("-------------------------------");
        for (Author a : authorService.findAll()) {
            log.info(a.toString());
        }
        return new SeedData();
    }
}
