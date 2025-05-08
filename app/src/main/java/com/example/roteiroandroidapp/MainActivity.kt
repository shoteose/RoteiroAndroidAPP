package com.example.roteiroandroidapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(IndexViagemFragment())
        bottomNav = findViewById(R.id.bottomNav)

        when (bottomNav) {
            is BottomNavigationView -> {
                (bottomNav as BottomNavigationView).setOnItemSelectedListener {
                    handleNavigation(it.itemId)
                }
            }
            is NavigationRailView -> {
                (bottomNav as NavigationRailView).setOnItemSelectedListener {
                    handleNavigation(it.itemId)
                }
            }
        }
    }

    private fun handleNavigation(itemId: Int): Boolean {
        return when (itemId) {
            R.id.perfil -> {
                loadFragment(IndexPerfilFragment())
                true
            }
            R.id.viagem -> {
                loadFragment(IndexViagemFragment())
                true
            }
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
