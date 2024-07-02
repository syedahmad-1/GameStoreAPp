package com.example.gamehokassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamehokassignment.databinding.FragmentTournamentsBinding


class TournamentsFragment : Fragment() {


    private var _binding: FragmentTournamentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTournamentsBinding.inflate(inflater, container, false)



        return binding.root
    }
}