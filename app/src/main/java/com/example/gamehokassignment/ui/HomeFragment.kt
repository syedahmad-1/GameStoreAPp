package com.example.gamehokassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.gamehokassignment.R
import com.example.gamehokassignment.adapters.GamersAdapter
import com.example.gamehokassignment.adapters.ImageBannerAdapter
import com.example.gamehokassignment.adapters.TournamentsAdapter
import com.example.gamehokassignment.adapters.TournamentsBattleAdapter
import com.example.gamehokassignment.databinding.FragmentHomeBinding
import com.example.gamehokassignment.models.ImageItem
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    private val imageBannerAdapter by lazy { ImageBannerAdapter() }
    private val tournamentAdapter by lazy { TournamentsAdapter() }
    private val tournamentsBattleAdapter by lazy {
        TournamentsBattleAdapter {
            findNavController().navigate(R.id.action_homeFragment_to_tournamentDetailsFragment)
        }
    }
    private val gamersAdapter by lazy { GamersAdapter() }

    private lateinit var viewPager2: ViewPager2
    private lateinit var pageChangeCallback: ViewPager2.OnPageChangeCallback

    private val params by lazy {
        LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { setMargins(16, 0, 16, 0) }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<View>(R.id.bottomAppBar).visibility = View.VISIBLE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupViewPager()
        setupRecyclerViews()
        setUpViewModels()

        binding.battlesViewAll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tournamentDetailsFragment)
        }

        return binding.root
    }

    private fun setupViewPager() {
        val images = ImageItem.mockImageItems()
        viewPager2 = binding.viewpager2
        viewPager2.adapter = imageBannerAdapter
        setupIndicators(images.size)
    }

    private fun setupIndicators(size: Int) {
        val indicator = Array(size) { ImageView(requireContext()) }
        indicator.forEach { dots ->
            dots.setImageResource(R.drawable.unactive_indicator)
            binding.viewpagerDotsLl.addView(dots, params)
        }
        indicator[0].setImageResource(R.drawable.active_indicator)

        pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.forEach { it.setImageResource(R.drawable.unactive_indicator) }
                indicator[position].setImageResource(R.drawable.active_indicator)
            }
        }
        viewPager2.registerOnPageChangeCallback(pageChangeCallback)
    }

    private fun setUpViewModels() {

        homeViewModel.loadMockData(requireContext())

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {


                homeViewModel.tournamentImages.observe(viewLifecycleOwner) { tournamentImages ->
                    tournamentAdapter.submitList(tournamentImages)
                }

                homeViewModel.battleTournament.observe(viewLifecycleOwner) { battleTournament ->
                    tournamentsBattleAdapter.submitList(battleTournament)
                }

                homeViewModel.userList.observe(viewLifecycleOwner) { userList ->
                    gamersAdapter.submitList(userList)
                }

                homeViewModel.images.observe(viewLifecycleOwner){images->
                    imageBannerAdapter.submitList(images)
                }
            }
        }

    }

    private fun setupRecyclerViews() {

        binding.tournamentsRv.apply {
            adapter = tournamentAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
            setHasFixedSize(true)
        }



        binding.battlesRv.apply {
            adapter = tournamentsBattleAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }



        binding.peopleToFollowRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = gamersAdapter
            setHasFixedSize(true)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewPager2.unregisterOnPageChangeCallback(pageChangeCallback)
    }
}
