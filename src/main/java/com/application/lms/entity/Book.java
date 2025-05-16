package com.application.lms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn" , length = 50 , nullable = false , unique = true)
    private String isbn;

    @Column(name = "name" , length = 50 , nullable = false )
    private String name;
    @Column(name = "description", length = 50 , nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_authors" ,
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="author_id")})
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_categories" ,
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_publishers" ,
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")})
    private Set<Publisher> publishers = new HashSet<Publisher>();


    // Constructor to initialize a new book with basic details
    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    // Methods to manage the bidirectional relationship

    public void addPublisher(Publisher publisher){
        this.publishers.add(publisher);                               // Add publisher to this book
        publisher.getBooks().add(this);                              // Add this book to the publisher
    }

    public void removePublisher(Publisher publisher){
        this.publishers.remove(publisher);                          // Remove author from this book
        publisher.getBooks().remove(publisher);                    // Remove author from this book
    }



    public void addAuthor(Author author){
        this.authors.add(author);                                 // Add author to this book
        author.getBooks().add(this);                             // Add this book to the author
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);                              // Remove author from this book
        author.getBooks().remove(author);                        // Remove this book from the author
    }


    public void addCategory(Category category){
        this.categories.add(category);                        // Add category to this book
        category.getBooks().add(this);                       // Add this book to the category
    }

    public void removeCategory(Category category){
        this.categories.remove(category);                    // Remove category from this book
        category.getBooks().remove(category);               // Remove this book from the category
    }








}
