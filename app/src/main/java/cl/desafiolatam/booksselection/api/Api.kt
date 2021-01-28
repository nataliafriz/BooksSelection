package cl.desafiolatam.booksselection.api

import cl.desafiolatam.booksselection.data.Books
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("Products")
    suspend fun getBooksApi(): Response<List<Books>>
}