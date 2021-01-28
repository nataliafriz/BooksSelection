package cl.desafiolatam.booksselection.data

import androidx.lifecycle.LiveData
import cl.desafiolatam.booksselection.api.RetrofitClient

class Repository {

    val booksDatabase = BooksApplication.booksDatabase!!
    val booksList = booksDatabase.booksDao().getAllBooks()

    suspend fun getBooksFromApi() {

        val response = RetrofitClient.retrofitClient().getBooksApi()

        when (response.isSuccessful){
            true -> {
                response.body()?.let {
                    booksDatabase.booksDao().insertBooks(it)

                }
            }
            false -> { }
        }
    }
    fun getBooks(codeID: Int) : LiveData<Books> {
        return booksDatabase.booksDao().getBooksDetail(codeID)
    }
    fun loadBooks(): LiveData<List<Books>> {
        return booksDatabase.booksDao().getAllBooks()
    }
}