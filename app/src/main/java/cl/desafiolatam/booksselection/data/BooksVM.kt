package cl.desafiolatam.booksselection.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksVM : ViewModel() {

    val repository = Repository()
    val booksList = repository.booksList

    init {

        viewModelScope.launch {
            repository.getBooksFromApi()
        }
    }

}