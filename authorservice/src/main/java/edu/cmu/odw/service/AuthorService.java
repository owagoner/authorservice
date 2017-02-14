package edu.cmu.odw.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.cmu.odw.model.Author;


@Service
public interface AuthorService extends CrudRepository<Author, Long> {

    Author findByName(String name);

}
