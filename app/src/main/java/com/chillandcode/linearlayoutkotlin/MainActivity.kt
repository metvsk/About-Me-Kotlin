package com.chillandcode.linearlayoutkotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
private lateinit var editText:EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText= findViewById<EditText>(R.id.editTextTextPersonName)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Log.i("TAG", "onCreate: ${button.text}")
            if (button.text == "Update") {
                if (!editText.text.equals("")) {
                    textView.text = editText.text
                    textView.visibility = View.VISIBLE
                    editText.visibility = View.GONE
                    button.text = "change"
                    hideKeyboard(it)
                } else {
                    Snackbar.make(button, "Type in your nick name", Snackbar.LENGTH_LONG).show()
                }
            } else {
                editText.visibility = View.VISIBLE
                textView.visibility = View.GONE
                button.text = "Update"
                showKeyboard(editText)
                editText.requestFocus()
            }
        }

    }

    private fun hideKeyboard(view:View) {
        val inputMethodManager=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun showKeyboard(view:View) {
        val inputMethodManager=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view,0)
    }
}