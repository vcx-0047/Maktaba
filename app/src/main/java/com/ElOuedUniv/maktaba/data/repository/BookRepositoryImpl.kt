package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

class BookRepositoryImpl : BookRepository {

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
    
    override fun getAllBooks(): List<Book> {
        return booksList
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}

