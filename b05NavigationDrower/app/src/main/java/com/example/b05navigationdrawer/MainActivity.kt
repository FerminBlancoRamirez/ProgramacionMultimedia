package com.example.b05navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.DrawerLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawerLayout : DrawerLayout = findViewById(R.id.DrawerLayout)
        val navView: NavigationView = findViewById(R.id.nNNavegacion)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> Toast.makeText(applicationContext, "Clicar en Home", Toast.LENGTH_SHORT).show()
                R.id.nav_basura -> Toast.makeText(applicationContext, "Clicar en Basura", Toast.LENGTH_SHORT).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Clicar en Mensaje", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(applicationContext, "Clicar en Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_rate -> Toast.makeText(applicationContext, "Clicar en Rate", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext, "Clicar en Login", Toast.LENGTH_SHORT).show()
            }

            true

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}