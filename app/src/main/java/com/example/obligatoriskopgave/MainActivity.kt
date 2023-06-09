package com.example.obligatoriskopgave

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import com.example.obligatoriskopgave.databinding.ActivityMainBinding
import com.example.obligatoriskopgave.home.ItemsAdapter
import com.example.obligatoriskopgave.salesItems.AddItemDialogFragment
import com.example.obligatoriskopgave.salesItems.Items
import com.example.obligatoriskopgave.salesItems.ItemsRepository
import com.example.obligatoriskopgave.salesItems.ItemsService
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var addFAB: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        addFAB = binding.idFABAdd // initialize addFAB variable by finding the view in the layout
        addFAB.setOnClickListener{
            val addItemDialogFragment = AddItemDialogFragment()
            addItemDialogFragment.show(supportFragmentManager, "addItemDialog")
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}