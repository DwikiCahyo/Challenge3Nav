package com.dwiki.wordappnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwiki.wordappnav.adapter.AlphabetAdapter
import com.dwiki.wordappnav.databinding.FragmentListAlphabetBinding
import com.dwiki.wordappnav.model.Alphabet


class ListAlphabetFragment : Fragment() {

    private var _binding:FragmentListAlphabetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListAlphabetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        setupListView()
        setupGridView()
    }

    private fun setupListView() {
        binding.ibList.setOnClickListener {
            setupRecycleView()
        }

    }

    private fun setupGridView() {

        binding.ibGrid.setOnClickListener {
            binding.rvAlphabet.layoutManager = GridLayoutManager(requireContext(), 5)
            binding.rvAlphabet.adapter = AlphabetAdapter(listAlphabet)

        }
    }

    private fun setupRecycleView() {
        val listAlphabetAdapter = AlphabetAdapter(listAlphabet)

        binding.rvAlphabet.apply {
            binding.rvAlphabet.layoutManager = LinearLayoutManager(requireContext())
            adapter = listAlphabetAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val listAlphabet:ArrayList<Alphabet>
        get() {
            val alphabetName = resources.getStringArray(R.array.alphabet_name)
            val firstItem = resources.getStringArray(R.array.first_item)
            val secondItem = resources.getStringArray(R.array.second_item)
            val thirdItem = resources.getStringArray(R.array.third_item)
            val imageAlphabet = resources.obtainTypedArray(R.array.alphabet_image)

            val list = ArrayList<Alphabet>()
            for (i in alphabetName.indices) {
                val alphabet = Alphabet(
                    alphabetName[i],
                    firstItem[i],
                    secondItem[i],
                    thirdItem[i],
                    imageAlphabet.getResourceId(i, 0)
                )
                list.add(alphabet)
            }
            return list
        }

}