package org.libraryManagement;

import org.libraryManagement.models.Author;
import org.libraryManagement.models.Book;
import org.libraryManagement.models.Subscriber;
import org.libraryManagement.repository.AuthorCrudOperations;
import org.libraryManagement.repository.BookCrudOperations;
import org.libraryManagement.repository.SubscribersCrudOperations;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorCrudOperations find = new AuthorCrudOperations();
        BookCrudOperations find1 = new BookCrudOperations();
        SubscribersCrudOperations find2 = new SubscribersCrudOperations();
        //find all
        List<Author> author = find.findAll();

        for (Author authors : author) {
            System.out.println(authors);
        }

        List<Book> book = find1.findAll();

        for (Book books : book) {
            System.out.println(books);
        }

        List<Subscriber> subscriber = find2.findAll();

        for (Subscriber subscribers : subscriber) {
            System.out.println(subscribers);
        }

        //Save
        Author authors = new Author();
        authors.setName("John Doe");
        authors.setGender("M");


        Author savedAuthor = find.save(authors);


        if (savedAuthor != null) {
            System.out.println("Author saved successfully:");
            System.out.println("ID: " + savedAuthor.getId());
            System.out.println("Name: " + savedAuthor.getName());
            System.out.println("Gender: " + savedAuthor.getGender());
        } else {
            System.out.println("Failed to save author.");
        }






    }

    }




