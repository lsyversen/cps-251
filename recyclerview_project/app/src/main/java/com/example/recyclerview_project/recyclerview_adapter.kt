package com.example.recyclerview_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

// RecyclerView Adapter class to display a list of custom data items
class recyclerview_adapter(var context : Context , var list : ArrayList<data>) : RecyclerView.Adapter<recyclerview_adapter.ViewHolderCatcher>() {

    // ViewHolder inner class to hold references to the UI components in each item layout
    inner class ViewHolderCatcher(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item_icon : ImageView = itemView.findViewById(R.id.item_icon)      // Reference to the image view in item layout
        var title : TextView = itemView.findViewById(R.id.item_title)          // Reference to the title text view
        var detail : TextView = itemView.findViewById(R.id.item_details)       // Reference to the description/details text view
    }

    // Called when RecyclerView needs a new ViewHolder; inflates the item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCatcher {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout , parent  , false)
        return ViewHolderCatcher(view)
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Binds the data from the list to the corresponding views in the ViewHolder
    override fun onBindViewHolder(holder: ViewHolderCatcher, position: Int) {
        var myData = list.get(position)                                        // Get the data item at the current position
        holder.item_icon.setImageResource(Integer.valueOf(myData.imageUrl))    // Set the image using the image resource ID
        holder.title.setText(myData.title)                                     // Set the title text
        holder.detail.setText(myData.description)                              // Set the detail/description text
    }
}
