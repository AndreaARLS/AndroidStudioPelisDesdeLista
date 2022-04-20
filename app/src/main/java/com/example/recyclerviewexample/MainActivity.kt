package com.example.recyclerviewexample

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var titulin: String = "Detective de Cine"
    val modelo : VM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun popupDelete(bundle: Bundle){
        val name: String = bundle.getString("name") ?:""
        val id: Int = bundle.getInt("id") ?:-1
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.deletepopup, null)

        builder.setView(view)
        val dialog = builder.create()
        dialog.show()

        val titulo = view.findViewById<TextView>(R.id.peliname)
        titulo.text = name
        val delbutton = view.findViewById<TextView>(R.id.deletebutton)
        val cancelbutton = view.findViewById<TextView>(R.id.cancelbutton)

        cancelbutton.setOnClickListener{
            dialog.hide()
        }

        delbutton.setOnClickListener {
            modelo.deletePeli(id)
            dialog.hide()
        }
    }



}