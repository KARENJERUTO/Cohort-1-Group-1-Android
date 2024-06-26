package com.example.starstream.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.starstream.presentation.ui.home.HomeFragment

class FragmentAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment.childFragmentManager, fragment.viewLifecycleOwner.lifecycle) {
    private val homeFragments = listOf(MovieListsFragment(), TvListsFragment())
    private val favoritesFragments = listOf(FavoriteMoviesFragment(), FavoriteTvsFragment())

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (fragment) {
            is HomeFragment -> homeFragments[position]
            is FavoritesFragment -> favoritesFragments[position]
            else -> throw IllegalArgumentException(Constants.ILLEGAL_ARGUMENT_FRAGMENT_TYPE)
        }
    }
}