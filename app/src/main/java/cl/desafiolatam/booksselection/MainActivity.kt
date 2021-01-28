package cl.desafiolatam.booksselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.desafiolatam.booksselection.data.BooksAdapter
import cl.desafiolatam.booksselection.view.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.main_container,ListFragment()).commit()
    }
}