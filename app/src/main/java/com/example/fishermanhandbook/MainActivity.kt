package com.example.fishermanhandbook

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fishermanhandbook.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    private var adapter: MyAdapter? = null

    private var list = ArrayList<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nav_view = binding.navView
        val rc_view = binding.test.rcView

        nav_view.setNavigationItemSelectedListener(this)

        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_desc),
                getImageId(R.array.fish_image)
            )
        )

        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list, this)

        rc_view.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_fish -> {
                showCategoryToast(item)
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_desc),
                        getImageId(R.array.fish_image)
                    )
                )
            }

            R.id.id_udochka -> showCategoryToast(item)
            R.id.id_najivki -> {
                showCategoryToast(item)
                adapter?.updateAdapter(fillArrays(
                    resources.getStringArray(R.array.najivki),
                    resources.getStringArray(R.array.najivki_desc),
                    getImageId(R.array.najivki_image)
                ))
            }
            R.id.id_snasti -> showCategoryToast(item)
        }

        return true
    }

    private fun fillArrays(
        titleArray: Array<String>, descArray: Array<String>, imageArray: IntArray
    ): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()

        for (i in 0..titleArray.size - 1) {
            val listItem = ListItem(imageArray[i], titleArray[i], descArray[i])
            listItemArray.add(listItem)
        }

        return listItemArray
    }

    private fun getImageId(imageArrayId: Int): IntArray {
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }

        tArray.recycle()
        return ids
    }

    private fun showCategoryToast(item: MenuItem) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
    }
}