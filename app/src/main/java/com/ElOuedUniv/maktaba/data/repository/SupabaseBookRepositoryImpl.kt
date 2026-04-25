package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseBookRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : BookRepository {

    override fun getAllBooks(): Flow<List<Book>> = flow {
        val books = supabaseClient
            .postgrest["books"]
            .select()
            .decodeList<Book>()
        emit(books)
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return null
    }

    override suspend fun addBook(book: Book) {
        supabaseClient
            .postgrest["books"]
            .insert(book)
    }

    override suspend fun uploadBookCover(isbn: String, imageBytes: ByteArray): String {
        val bucket = supabaseClient.storage["book_covers"]
        val fileName = "$isbn.jpg"
        bucket.upload(fileName, imageBytes) {
            upsert = false
        }
        return bucket.publicUrl(fileName)
    }
}
