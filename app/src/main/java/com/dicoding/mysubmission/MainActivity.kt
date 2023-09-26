package com.dicoding.mysubmission

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private lateinit var rvChar: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChar = findViewById(R.id.rv_char)
        rvChar.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    private fun getListCharacters(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listChar = ArrayList<Character>()
        for (i in dataName.indices) {
            val char = Character(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listChar.add(char)
        }
        return listChar
    }

    private fun showRecyclerList() {
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapterAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapterAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list ->{
                val intent = Intent(this@MainActivity, ProfilePage::class.java)
                startActivity(intent)
                return true
            }else->{
                return super.onOptionsItemSelected(item)
            }
        }
    }
}