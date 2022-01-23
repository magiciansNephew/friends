package com.example.friends

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.adapter.LetterAdapter
import com.example.friends.data.DataSource

private const val TAG = "DataSource"
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource = DataSource()

        val letters = dataSource.loadLetters()

        recyclerView = findViewById(R.id.recycler_view)
        chooseLayout()
        recyclerView.adapter = LetterAdapter(letters)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

    private fun chooseLayout(){
        recyclerView.layoutManager = if (isLinearLayoutManager)
            LinearLayoutManager(this)
        else GridLayoutManager(this, 4)
    }

    private fun setIcon(menuItem: MenuItem?){
        if (menuItem == null) return

        menuItem.icon = if (isLinearLayoutManager)
            ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
            
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}