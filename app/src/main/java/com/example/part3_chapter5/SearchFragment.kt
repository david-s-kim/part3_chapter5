package com.example.part3_chapter5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.part3_chapter5.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var binding : FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSearchBinding.inflate(inflater, container, false).apply {
           binding = this
        }.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}