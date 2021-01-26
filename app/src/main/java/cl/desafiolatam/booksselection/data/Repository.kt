package cl.desafiolatam.booksselection.data

import cl.desafiolatam.booksselection.api.RetrofitClient

class Repository {

    val database = BooksApplication.booksDatabase!!
    val booksList = database.booksDao().getBooks()

    suspend fun getBooksFromApi() {

        val response = RetrofitClient.retrofitClient().getBooksApi()

        when (response.isSuccessful){
            true -> {
                response.body()?.let {
                    database.booksDao().insertBooks(it)

                }
            }
            false -> {

            }
        }
    }
}