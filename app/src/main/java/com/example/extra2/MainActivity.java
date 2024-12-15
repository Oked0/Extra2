package com.example.extra2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MainActivity extends AppCompatActivity {
    private Library library;
    private EditText editTextTitle, editTextAuthor, editTextGenre;
    private TextView textViewBooks, textViewAuthors, textViewGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        library = new Library();

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextGenre = findViewById(R.id.editTextGenre);
        textViewBooks = findViewById(R.id.textViewBooks);
        textViewAuthors = findViewById(R.id.textViewAuthors);
        textViewGenres = findViewById(R.id.textViewGenres);

        Button buttonAddBook = findViewById(R.id.buttonAddBook);
        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String authorName = editTextAuthor.getText().toString();
                String genre = editTextGenre.getText().toString();

                if (!title.isEmpty() && !authorName.isEmpty() && !genre.isEmpty()) {
                    Author author = new Author(authorName);
                    Book book = new Book(title, author, genre);
                    library.addBook(book);

                    updateUI();

                    editTextTitle.setText("");
                    editTextAuthor.setText("");
                    editTextGenre.setText("");
                }
            }
        });
    }

    private void updateUI() {
        StringBuilder booksText = new StringBuilder("Books:\n");
        for (Book book : library.getBooks()) {
            booksText.append(book.toString()).append("\n");
        }
        textViewBooks.setText(booksText.toString());

        StringBuilder authorsText = new StringBuilder("Authors:\n");
        for (Author author : library.getAuthors()) {
            authorsText.append(author.toString()).append("\n");
        }
        textViewAuthors.setText(authorsText.toString());

        StringBuilder genresText = new StringBuilder("Genres:\n");
        for (Map.Entry<String, List<Book>> entry : library.getGenreMap().entrySet()) {
            genresText.append(entry.getKey()).append(": ");
            for (Book book : entry.getValue()) {
                genresText.append(book.getTitle()).append(", ");
            }
            genresText.append("\n");
        }
        textViewGenres.setText(genresText.toString());
    }
}