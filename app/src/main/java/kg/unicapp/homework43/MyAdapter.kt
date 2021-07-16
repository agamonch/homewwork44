package kg.unicapp.homework43

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listener: SetClickListener) : RecyclerView.Adapter<MyViewHolder>() {
    private val items = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    fun setItems(newItems: List<Item>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun deleteById(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    interface SetClickListener {
        fun deleteIcon(position: Int)
    }
}