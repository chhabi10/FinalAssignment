package com.chhabi.finalassignment.activities.ui.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.chhabi.finalassignment.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var txtv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        img= findViewById(R.id.img)
        txtv=findViewById(R.id.txtv)


        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            startActivity(Intent(this@SplashscreenActivity, LoginActivity::class.java))
            finish()
        }

    }
}


