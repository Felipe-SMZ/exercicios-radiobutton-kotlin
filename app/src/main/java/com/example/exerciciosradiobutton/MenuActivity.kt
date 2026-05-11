package com.example.exerciciosradiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        val buttonGeometria =
            findViewById<Button>(R.id.buttonGeometria)

        val buttonOhm =
            findViewById<Button>(R.id.buttonOhm)

        buttonGeometria.setOnClickListener {

            startActivity(
                Intent(this, GeometriaActivity::class.java)
            )
        }

        buttonOhm.setOnClickListener {

            startActivity(
                Intent(this, OhmActivity::class.java)
            )
        }
    }
}