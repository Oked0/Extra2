package com.example.extra2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private List<Book> books;
    private Set<Author> authors;
    private Map<String, List<Book>> genreMap;

    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        genreMap = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        genreMap.computeIfAbsent(book.getGenre(), k -> new ArrayList<>()).add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Map<String, List<Book>> getGenreMap() {
        return genreMap;
    }
}