package com.maxlord.navigationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.airbnb.mvrx.BaseMvRxActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.mainNavFragment)

        // Set up ActionBar
        setSupportActionBar(toolbar)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController)

        // Set up navigation menu
//        navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(drawerLayout,
//                Navigation.findNavController(this, R.id.mainNavFragment))
        return findNavController(R.id.mainNavFragment).navigateUp()
    }
}
