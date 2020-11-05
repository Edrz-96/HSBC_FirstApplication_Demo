package com.qa.firstapplication.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.qa.firstapplication.R
import com.qa.firstapplication.data.joinedList
import com.qa.firstapplication.data.listbase

class MainActivity : AppCompatActivity() {
    var TAG = "Debug Message: "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textEdit = findViewById<TextView>(R.id.randomizedText)

        var randomizeBtn = findViewById<Button>(R.id.randomizedBtn)
        randomizeBtn.setOnClickListener {
            textEdit.text = listbase()
            Log.d(TAG, "$joinedList")
            Toast.makeText(this, "Updating text", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menu?.getItem(1)?.isEnabled = false
//        menu?.getItem(1)?.isVisible = false
        return super.onPrepareOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Title of dialog")
                builder.setMessage("Enter some stuff...")
                builder.setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(applicationContext, "Yes selected", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("No") { _, _ ->
                    Toast.makeText(applicationContext, "No selected", Toast.LENGTH_SHORT).show()
                }
                builder.setNeutralButton("Neutral") { _, _ ->
                    Toast.makeText(applicationContext, "Neutral selected", Toast.LENGTH_SHORT).show()
                }
                builder.show()
                true
            }
            R.id.menu_remove -> {
                Toast.makeText(this, "Another Toast", Toast.LENGTH_SHORT).show()
                true

            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

}







