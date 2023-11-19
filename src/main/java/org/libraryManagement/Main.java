package org.libraryManagement;

import org.libraryManagement.models.Author;
import org.libraryManagement.repository.AuthorCrudOperations;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AuthorCrudOperations find = new AuthorCrudOperations();

        List<Author> author = find.findAll();

        for (Author authors : author) {
            System.out.println(authors);
        }
    }

    }




