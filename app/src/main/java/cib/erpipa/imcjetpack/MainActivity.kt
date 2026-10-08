package cib.erpipa.imcjetpack

import android.R
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cib.erpipa.imcjetpack.ui.theme.IMCJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMCJetPackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIScreen()
                }
            }
        }
    }
}

@Composable
fun BMIScreen() {
    var name: String by remember { mutableStateOf(value = "") }
    var pes: Int by remember { mutableStateOf(value = 80) }
    var altura: Int by remember { mutableStateOf(value = 180) }
    var bmi: Float by remember { mutableStateOf(value = 0f) }

    Column() {

        Text(text = "BMI Calculator :D" ,
            fontSize = 30.sp ,
            fontWeight = FontWeight.Bold,
            fontStyle = Italic
            )

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Text(text = "Pes")

        Row() {
            Text(text = "$pes Kg")
            Button(onClick = { pes-- }) {
                Text(text = "-")
            }
            Button(onClick = { pes++ }) {
                Text(text = "+")
            }
        }

        Text(text = "Altura: $altura cm")

        Slider(
            value = altura.toFloat(),
            onValueChange = { altura = it.toInt() },
            valueRange = 100f..250f
        )

        Button(onClick = {
            var alturaMetros = altura.toFloat() / 100

            bmi = (pes / (alturaMetros * alturaMetros))
        }) {
            Text(text = "Calcular BMI")
        }

        if (bmi != 0f) {
            Text(text = "El teu BMI es: $bmi")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMCJetPackTheme {
        BMIScreen()
    }
}