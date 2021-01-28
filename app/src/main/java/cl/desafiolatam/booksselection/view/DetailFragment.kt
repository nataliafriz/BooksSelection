package cl.desafiolatam.booksselection.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.desafiolatam.booksselection.data.Books
import cl.desafiolatam.booksselection.data.BooksVM
import cl.desafiolatam.booksselection.databinding.FragmentDetailBinding
import cl.desafiolatam.booksselection.databinding.FragmentListBinding
import coil.api.load

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel : BooksVM by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        viewModel.selected().observe(viewLifecycleOwner, {
            binding.tvSinopsis.text = it.synopsis
            Log.d("TAG", "onCreateView: $it")
            binding.tvautor.text = it.author
            binding.tvcategoria.text = it.category
            binding.tvtitulo.text = it.title
            binding.tvpagina.text = it.id.toString()
            binding.tvpagina.text = it.pages.toString()
            binding.ivportada.load(it.image)
        })
        return binding.root
    }
}