package com.dwiki.wordappnav

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dwiki.wordappnav.databinding.FragmentContentBinding
import com.dwiki.wordappnav.model.Alphabet


class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments

        val item = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            args?.getParcelable(DATA, Alphabet::class.java)
        } else {
            args?.getParcelable(DATA)
        }

        binding.ivCircleAlphabet.setImageResource(item?.imgAlphabet ?: R.drawable.a)

        binding.cvFirstItem.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=${item?.firstItem}")
            startActivity(intent)
        }

        binding.cvSecondItem.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=${item?.secondItem}")
            startActivity(intent)
        }

        binding.cvThirdItem.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=${item?.thirdItem}")
            startActivity(intent)
        }


        binding.tvFirstItem.text = item?.firstItem ?: getString(R.string.str_kosong)
        binding.tvSecondItem.text = item?.secondItem ?: getString(R.string.str_kosong)
        binding.tvThirdItem.text = item?.thirdItem ?: getString(R.string.str_kosong)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        const val DATA = "alphabet"
    }



}