package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PageAdapter(private val images: List<String>, private val names: List<String>, private val descriptions: List<String>) : RecyclerView.Adapter<PageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.card_page, parent, false) )
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.itemView.run {
            Picasso.get()
                .load(images[position])
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(findViewById<ImageView>(R.id.image_view))
             findViewById<TextView>(R.id.tv_name).text = names[position]
            findViewById<TextView>(R.id.tv_description).text = descriptions[position]
        }
    }
}




class PageViewHolder(iV: View) : RecyclerView.ViewHolder(iV)