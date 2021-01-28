package cl.desafiolatam.booksselection.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BooksDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(booksList: List<Books>)

    @Query("SELECT * FROM booksSelection")
    fun getAllBooks(): LiveData<List<Books>>

    @Query ("SELECT * FROM booksSelection WHERE id=:codeID" )
    fun getBooksDetail(codeID :Int) : LiveData<Books>
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





