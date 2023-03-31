package com.dwiki.wordappnav.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.dwiki.wordappnav.ContentFragment
import com.dwiki.wordappnav.ContentFragment.Companion.DATA
import com.dwiki.wordappnav.R
import com.dwiki.wordappnav.databinding.ListAlphabetItemBinding
import com.dwiki.wordappnav.model.Alphabet

class AlphabetAdapter(private val listAlphabet:ArrayList<Alphabet>):RecyclerView.Adapter<AlphabetAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ListAlphabetItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListAlphabetItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val alphabet = listAlphabet[position]
        holder.binding.apply {
            tvAlphabetName.text = alphabet.alphabetName
            ivAlphabet.setImageResource(alphabet.imgAlphabet)
            cvAlphabetItem.setOnClickListener {

                val bundle = Bundle()
                bundle.putParcelable(DATA,alphabet)
                Navigation.findNavController(it).navigate(R.id.action_listAlphabetFragment_to_contentFragment,bundle)

            }
        }
    }

    override fun getItemCount(): Int = listAlphabet.size
}