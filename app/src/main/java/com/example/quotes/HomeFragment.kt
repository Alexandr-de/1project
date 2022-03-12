package com.example.quotes

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.quotes.databinding.FragmentHomeBinding
import java.lang.RuntimeException

class HomeFragment: Fragment() {

    private lateinit var Quotes: TextView
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        addListeners(view)

    }

    private fun initViews(view: View){
        Quotes = view.findViewById(R.id.textViewQuotes)
    }

    private fun addListeners(view: View){
        view.setOnClickListener {
//            Log.d("TEST", binding.textViewQuotes.id.toString())
//            Log.d("ALEX", R.id.textViewQuotes.toString())
            if (binding.textViewQuotes.id.toString() == R.id.textViewQuotes.toString()){

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.homeFragment, ContentFragment.newInstance())
                    .commit()



            }
        }
    }
}