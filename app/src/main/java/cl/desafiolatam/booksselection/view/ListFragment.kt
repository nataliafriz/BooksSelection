package cl.desafiolatam.booksselection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.booksselection.R
import cl.desafiolatam.booksselection.data.BooksAdapter
import cl.desafiolatam.booksselection.data.BooksVM
import cl.desafiolatam.booksselection.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel : BooksVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        binding.rvListbooks.layoutManager = LinearLayoutManager(context)
        val adapter = BooksAdapter ()
        binding.rvListbooks.adapter = adapter
        adapter.selectedItem().observe(viewLifecycleOwner,{
            viewModel.selected(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container,DetailFragment())?.addToBackStack("fragment Detail")?.commit()
        })
        viewModel.getBooksVm().observe(viewLifecycleOwner, {
            adapter.updateList(it)
        })
        return binding.root
    }
}