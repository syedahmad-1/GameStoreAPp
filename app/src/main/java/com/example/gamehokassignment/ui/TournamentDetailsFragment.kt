package com.example.gamehokassignment.ui

import TournamentDetailsPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.gamehokassignment.R
import com.example.gamehokassignment.databinding.FragmentTournamentDetailsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TournamentDetailsFragment : Fragment() {

    private var _binding: FragmentTournamentDetailsBinding? = null
    private val binding get() = _binding!!



    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<View>(R.id.bottomAppBar).visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTournamentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        binding.viewpager2.adapter = TournamentDetailsPagerAdapter(requireActivity())
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
            tab.text = when (position) {
                0 -> "Overview"
                1 -> "Standings"
                2 -> "Rules"
                3 -> "Players"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.viewpager2?.adapter = null
        _binding = null
    }
}
