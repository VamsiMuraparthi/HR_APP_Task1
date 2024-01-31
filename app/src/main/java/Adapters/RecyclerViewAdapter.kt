package Adapters

import DataModels.ItemDataModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task_1.R

class RecyclerViewAdapter(private val items: ArrayList<ItemDataModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.employee_name)
        val imageView: ImageView = itemView.findViewById(R.id.employee_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]

        holder.textView.text = currentItem.text
        holder.imageView.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}