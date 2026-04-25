package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.data.repository.BookRepository
import javax.inject.Inject

class AddBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(book: Book, imageBytes: ByteArray? = null) {
        val imageUrl = imageBytes?.let {
            bookRepository.uploadBookCover(book.isbn, it)
        }
        val finalBook = if (imageUrl != null) book.copy(imageUrl = imageUrl) else book
        bookRepository.addBook(finalBook)
    }
}
