package kg.unicapp.homework43

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Item) {
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        itemView.run {
            tv_name.text = item.name
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: MyAdapter.SetClickListener): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my_viewholder, parent, false)
            val holder = MyViewHolder(view)
            val deleteBtn = view.findViewById<Button>(R.id.button2)
            deleteBtn.setOnClickListener {
                listener.deleteIcon(holder.adapterPosition)
            }
            return holder
        }
    }
}