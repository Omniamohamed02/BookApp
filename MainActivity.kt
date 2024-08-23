package com.example.books

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.books.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val books = mutableListOf(
            Books(R.drawable.angels, "Angles & Demons", "By Dan Brown"),
            Books(R.drawable.blood, "Blood Line", "By James Rollins"),
            Books(R.drawable.humming, "Humming Bird", "By Luis Alberto"),
            Books(R.drawable.nostra, "Terra Nostra", "By Carlos Fuentes"),
            Books(R.drawable.solitude, "One Hundred Years of Solitude", "By Gabriel Garcia"),
            Books(R.drawable.spirits, "The House of the Spirits", "By Isabel Allende"),
            Books(R.drawable.sword, "The Sword Thief", "By Peter Lerangis")
        )

        val bookAdapter = BookAdapter(books)

        binding.recyclerView.adapter = bookAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

       binding.toolbar.materialToolbar.setNavigationOnClickListener{
           binding.drawerLayout.openDrawer(GravityCompat.START)
       }
        binding.designNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    Toast.makeText(this,R.string.profile_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this,R.string.settings_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.reviews -> {
                    Toast.makeText(this,R.string.reviews_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this,R.string.search_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.favorite -> {
                    Toast.makeText(this,R.string.favorite_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false

            }
        }

        binding.toolbar.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId){

                R.id.notification-> {
                    Toast.makeText(this,R.string.notification_clicked,Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

    }
}
