package cl.desafiolatam.booksselection.data


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "booksSelection")
data class Books (
    @PrimaryKey val id: Int,
    val title: String,
    val author: String,
    val image: String,
    val category: String,
    val synopsis: String,
    val pages: Int
)
