package org.casique.oop.composition;

import java.util.List;

class Book {

    public String title;
    public String author;


    Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }
}

public class Library {

    private final List<Book> books;

    Library(List<Book> books)
    {

        this.books = books;
    }

    public List<Book> getListOfBooksInLibrary()
    {
        return books;
    }
}
