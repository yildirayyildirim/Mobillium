package com.app.mobillium.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.mobillium.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_home)
    }
}