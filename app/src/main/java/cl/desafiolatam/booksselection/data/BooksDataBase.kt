package cl.desafiolatam.booksselection.data

import android.app.Application
import androidx.room.*

@Dao
interface BooksDao{

    @Insert
    suspend fun insertBooks(booksList: List<Books>)

    @Query("SELECT * FROM booksSelection")
    fun getBooks(): List<Books>

}

@Database(entities = [Books::class],version=1)
abstract class BooksDatabase:RoomDatabase(){
    abstract fun booksDao():BooksDao
}

class BooksApplication: Application(){

    companion object{
        var booksDatabase:BooksDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()
        booksDatabase=Room.databaseBuilder(this, BooksDatabase::class.java,"books_db").build()
    }
}





