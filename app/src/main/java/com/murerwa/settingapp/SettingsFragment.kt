package com.murerwa.settingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val accountSettingsPreference = findPreference<Preference>("key_account_settings")

        accountSettingsPreference?.setOnPreferenceClickListener {

            val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController

            val action = SettingsFragmentDirections.actionSettingsToAccountSettings()
            navController.navigate(action)

            true
        }

        // Read preferences
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)

        val autoReplyTime = sharedPreference.getString("key_auto_reply_time", "")
    }
}