package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

/**
 * Repository for managing book data
 * This follows the Repository pattern to abstract data sources
 */
class BookRepository {

    /**
     * TODO for Students (TP1 - Exercise 1):
     * Complete the book information for each book in the list below.
     * Add the following information for each book:
     * - isbn: Use a valid ISBN-13 format (e.g., "978-3-16-148410-0")
     * - nbPages: Add the actual number of pages
     *
     * Example:
     * Book(
     *     isbn = "978-0-13-468599-1",
     *     title = "Clean Code",
     *     nbPages = 464
     * )
     */
    private val booksList = listOf(
        Book(isbn = "9780135398548", title = "Clean Code", nbPages =672),
        Book(isbn = "9780132119177", title = "The Pragmatic Programmer", nbPages = 352),
        Book(isbn = "9780201715941", title = "Design Patterns", nbPages = 334),
        Book(isbn = "9780201485677", title = "Refactoring", nbPages = 431),
        Book(isbn = "9780596007126", title = "Head First Design Patterns", nbPages = 638),
        Book(isbn = "9781093123654", title = "Laravel Doc", nbPages = 771) ,
        Book(isbn = "9780131103627", title = "The C programming language", nbPages =272 ),
        Book(isbn = "9780470087251", title = "Professional Web APIs with PHP", nbPages = 356),
        Book(isbn = "9780071605502", title = "MySQL Database Usage & Administration", nbPages =500 ),
        Book(isbn = "9780596555139", title = "Linux System Programming", nbPages =392 )
    )

    /**
     * TODO for Students (TP1 - Exercise 2):
     * Add 5 more books to the list above.
     * Choose books related to Computer Science, Programming, or any topic you like.
     * Remember to include complete information (ISBN, title, nbPages).
     *
     * Tip: You can find ISBN numbers for books on:
     * - Google Books
     * - Amazon
     * - GoodReads
     */

    /**
     * Get all books from the repository
     * @return List of all books
     */
    fun getAllBooks(): List<Book> {
        return booksList
    }

    /**
     * Get a book by ISBN
     * @param isbn The ISBN of the book to find
     * @return The book if found, null otherwise
     */
    fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}
