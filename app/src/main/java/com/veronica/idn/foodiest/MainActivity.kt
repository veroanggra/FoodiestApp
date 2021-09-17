package com.veronica.idn.foodiest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.veronica.idn.foodiest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    modifier : private, protected, inner
    val  -> value : immutable
    var -> bisa diubah2 : muttable*/

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        setCurrentFragment(BreakfastFragment())
        mainBinding.navBottomMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_breakfast -> setCurrentFragment(BreakfastFragment())
                R.id.ic_vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_dessert -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, fragment)
            commit()
        }

}