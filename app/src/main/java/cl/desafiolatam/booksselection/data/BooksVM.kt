package cl.desafiolatam.booksselection.data



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class BooksVM : ViewModel() {

   private val repository = Repository()
    val listBooks = repository.booksList

    init {
        viewModelScope.launch { repository.getBooksFromApi() }
    }
    fun getBooksVm(): LiveData<List<Books>> {
        return repository.loadBooks()
    }
    fun selected (): LiveData<Books> = selected
    private  val selected = MutableLiveData<Books> ()
    fun selected (book: Books) {
        selected.value = book
    }

}

