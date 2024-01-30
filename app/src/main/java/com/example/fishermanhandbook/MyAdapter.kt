package com.example.fishermanhandbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listArray: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var contextRecycler = context
    private var listArrayRecycler = listArray

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.tv_avatar)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            tvDesc.text = listItem.desc
            image.setImageResource(listItem.imageId)

            itemView.setOnClickListener() {
                Toast.makeText(context, "It's ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())
                    putExtra("content", tvDesc.text.toString())
                    putExtra("image", listItem.imageId)
                }

                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextRecycler)

        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayRecycler.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayRecycler.get(position)

        holder.bind(listItem, contextRecycler)
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayRecycler.clear()

        listArrayRecycler.addAll(listArray)
        notifyDataSetChanged()
    }
}