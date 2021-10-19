package com.murerwa.settingapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.MenuItem
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                val action = HomeFragmentDirections.actionHomeToSettings()

                findNavController().navigate(action)
                return false
            }
            R.id.dark_mode ->
                // Do Fragment menu item stuff here
                return true
            else -> {
            }
        }
        return false
    }
}