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

    public void removePublisher(Publisher publisher){
        this.publishers.remove(publisher);      // remove all the publisher from the hash set
        publisher.getBooks().remove(publisher); // get all the books and remove from there
    }

    public void addPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);      // remove all the author from the hash set
        author.getBooks().remove(author); // get all the books and remove from there
    }

    public void addAuthor(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);      // remove all the category from the hash set
        category.getBooks().remove(category); // get all the books and remove from there
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }







}
