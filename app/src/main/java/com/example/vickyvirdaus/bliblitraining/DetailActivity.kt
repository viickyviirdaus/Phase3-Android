package com.example.vickyvirdaus.bliblitraining

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class DetailActivity : AppCompatActivity() {
    var edUsername: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
