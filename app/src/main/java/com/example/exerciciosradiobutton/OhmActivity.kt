package com.example.exerciciosradiobutton

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class OhmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ohm)

        val radioGroup =
            findViewById<RadioGroup>(R.id.radioGroupOhm)

        val editV =
            findViewById<EditText>(R.id.editV)

        val editI =
            findViewById<EditText>(R.id.editI)

        val editR =
            findViewById<EditText>(R.id.editR)

        val buttonCalcular =
            findViewById<Button>(R.id.buttonCalcularOhm)

        val buttonVoltar =
            findViewById<Button>(R.id.buttonVoltarMenuOhm)

        val textResultado =
            findViewById<TextView>(R.id.textResultadoOhm)

        buttonVoltar.setOnClickListener {

            startActivity(
                Intent(this, MenuActivity::class.java)
            )

            finish()
        }

        buttonCalcular.setOnClickListener {

            try {

                when (radioGroup.checkedRadioButtonId) {

                    R.id.radioV -> {

                        if (
                            editI.text.isEmpty() ||
                            editR.text.isEmpty()
                        ) {

                            Toast.makeText(
                                this,
                                "Digite corrente e resistência",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val i =
                            editI.text.toString().toDouble()

                        val r =
                            editR.text.toString().toDouble()

                        val v = r * i

                        textResultado.text =
                            getString(R.string.voltagem_format, v)
                    }

                    R.id.radioI -> {

                        if (
                            editV.text.isEmpty() ||
                            editR.text.isEmpty()
                        ) {

                            Toast.makeText(
                                this,
                                "Digite tensão e resistência",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val v =
                            editV.text.toString().toDouble()

                        val r =
                            editR.text.toString().toDouble()

                        if (r == 0.0) {

                            Toast.makeText(
                                this,
                                "Resistência não pode ser zero",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val i = v / r

                        textResultado.text =
                            getString(R.string.corrente_format, i)
                    }

                    R.id.radioR -> {

                        if (
                            editV.text.isEmpty() ||
                            editI.text.isEmpty()
                        ) {

                            Toast.makeText(
                                this,
                                "Digite tensão e corrente",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val v =
                            editV.text.toString().toDouble()

                        val i =
                            editI.text.toString().toDouble()

                        if (i == 0.0) {

                            Toast.makeText(
                                this,
                                "Corrente não pode ser zero",
                                Toast.LENGTH_SHORT
                            ).show()

                            return@setOnClickListener
                        }

                        val r = v / i

                        textResultado.text =
                            getString(R.string.resistencia_format, r)
                    }

                    else -> {

                        Toast.makeText(
                            this,
                            "Selecione uma opção",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

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