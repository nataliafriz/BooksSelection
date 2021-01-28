package cl.desafiolatam.booksselection.data


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.booksselection.databinding.ItemListBinding
import coil.api.load

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksVH>() {

    private val selectedItem = MutableLiveData<Books>()
    fun selectedItem ():LiveData<Books> = selectedItem
    var booksList = listOf<Books>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
         val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return BooksVH(binding)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val books = booksList[position]
        holder.bind(books)
        holder.itemView.setOnClickListener{
            selectedItem.value = books
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
    fun updateList(listBooks: List<Books>) {
        booksList=listBooks
        notifyDataSetChanged()
    }
    class BooksVH (val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(books: Books) {
            binding.tvTitle.text = books.title
            binding.tvAuthor.text = books.author
            binding.tvId.text = books.id.toString()
            binding.ivBooks.load(books.image)
            Log.d("bind","$books")

        }

    }
}