package edu.cmu.odw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.odw.model.Author;
import edu.cmu.odw.service.AuthorService;


@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/api/author/{id}")
	public Author author(@PathVariable("id") long id) {
		return authorService.findOne(id);
	}
    
	@RequestMapping(value = "/api/author/byname", method = RequestMethod.GET)
	@ResponseBody
	public Author author(@RequestParam("query") String name) {
		return authorService.findByName(name);
	}
	
	@RequestMapping(value = "/api/author", method = RequestMethod.POST)
	public Author saveAuthor(@RequestBody Author author) {
		System.out.println(author);

		Author a = authorService.findByName(author.getName());

		if (a == null) {
			System.out.println("Saving author");
			return authorService.save(author);
		} else {
			System.out.println("Author already saved.");
			return null;
		}

	}

}
