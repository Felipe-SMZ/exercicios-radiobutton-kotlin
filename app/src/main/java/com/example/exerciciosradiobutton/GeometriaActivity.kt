package com.example.exerciciosradiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI

class GeometriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_geometria)

        val radioGroup =
            findViewById<RadioGroup>(R.id.radioGroupGeometria)

        val editRaio =
            findViewById<EditText>(R.id.editRaio)

        val editBase =
            findViewById<EditText>(R.id.editBase)

        val editAltura =
            findViewById<EditText>(R.id.editAltura)

        val buttonCalcular =
            findViewById<Button>(R.id.buttonCalcularArea)

        val buttonVoltar =
            findViewById<Button>(R.id.buttonVoltarMenu)

        val textResultado =
            findViewById<TextView>(R.id.textResultadoArea)

        buttonVoltar.setOnClickListener {

            startActivity(
                Intent(this, MenuActivity::class.java)
            )

            finish()
        }

        buttonCalcular.setOnClickListener {

            try {

                var area = 0.0

                when (radioGroup.checkedRadioButtonId) {

                    R.id.radioCirculo -> {

                        if (editRaio.text.isEmpty()) {

                            Toast.makeText(
                                this,
                                "Digite o raio",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val raio =
                            editRaio.text.toString().toDouble()

                        area = PI * raio * raio
                    }

                    R.id.radioRetangulo -> {

                        if (
                            editBase.text.isEmpty() ||
                            editAltura.text.isEmpty()
                        ) {

                            Toast.makeText(
                                this,
                                "Digite base e altura",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val base =
                            editBase.text.toString().toDouble()

                        val altura =
                            editAltura.text.toString().toDouble()

                        area = base * altura
                    }

                    R.id.radioTriangulo -> {

                        if (
                            editBase.text.isEmpty() ||
                            editAltura.text.isEmpty()
                        ) {

                            Toast.makeText(
                                this,
                                "Digite base e altura",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val base =
                            editBase.text.toString().toDouble()

                        val altura =
                            editAltura.text.toString().toDouble()

                        area = (base * altura) / 2
                    }

                    else -> {

                        Toast.makeText(
                            this,
                            "Selecione uma opção",
                            Toast.LENGTH_SHORT
                        ).show()

                        return@setOnClickListener
                    }
                }

                textResultado.text =
                    getString(R.string.area_format, area)

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    "Valor inválido",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}