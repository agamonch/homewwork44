package kg.unicapp.homework43


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.SetClickListener {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLongListOfItems()
    }

    fun getLongListOfItems() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        myAdapter = MyAdapter(this)
        recyclerView.adapter = myAdapter
        val button = findViewById<Button>(R.id.button)
        val edit = findViewById<EditText>(R.id.editText)
        button.setOnClickListener {
            if (edit.text.isNotEmpty()) {
                val text = edit.text.toString()
                var data = mutableListOf(Item(text))
                myAdapter.setItems(data)
            } else Toast.makeText(this, "EditText is EMPTY", Toast.LENGTH_SHORT).show()
        }
    }

    override fun deleteIcon(position: Int) {
        myAdapter.deleteById(position)
    }
}





