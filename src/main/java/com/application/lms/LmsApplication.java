package com.application.lms;

import com.application.lms.entity.Author;
import com.application.lms.entity.Book;
import com.application.lms.entity.Category;
import com.application.lms.entity.Publisher;
import com.application.lms.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	/*
	Note-The CommandLineRunner interface is used when you want to run specific logic right after the Spring Boot
	application has started—before the application is ready to accept requests.
	 */

	@Bean  // Creates a bean to run initialization logic at application startup
	public CommandLineRunner intialCreate(BookService bookService){
		return(args)->{

			Book book1 = new Book("ABC","Book Name" , "My First Book");
			Author author1 = new Author("Test name1" , "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC2","Book Name2" , "My First Book2");
			Author author2 = new Author("Test name2" , "Test description2");
			Category category2 = new Category("Business books2");
			Publisher publisher2 = new Publisher("First Publisher2");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC3","Book Name3" , "My First Book3");
			Author author3 = new Author("Test name13" , "Test description3");
			Category category3 = new Category("Business books3");
			Publisher publisher3 = new Publisher("First Publisher3");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}

}
