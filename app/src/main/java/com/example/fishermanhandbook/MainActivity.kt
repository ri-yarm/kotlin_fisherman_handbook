package com.example.fishermanhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fishermanhandbook.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    var list = ArrayList<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nav_view = binding.navView
        val rc_view = binding.test.rcView

        nav_view.setNavigationItemSelectedListener(this)

        list.add(ListItem(R.drawable.ic_fish, "Android", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Aplle", "TEST"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "Nokia", "Description"))
        list.add(ListItem(R.drawable.ic_fish, "React", "Description"))

        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        rc_view.adapter = MyAdapter(list, this )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.id_fish -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.id_udochka -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.id_najivki -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.id_snasti -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

        return true
    }
}