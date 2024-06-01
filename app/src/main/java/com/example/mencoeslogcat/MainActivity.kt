package com.example.mencoeslogcat

import android.content.ContentValues.TAG
import androidx.compose.foundation.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mencoeslogcat.ui.theme.MencoesLogcatTheme
import com.example.mencoeslogcat.ui.theme.bButtonColors
import com.example.mencoeslogcat.ui.theme.rButtonColors
import com.example.mencoeslogcat.ui.theme.iButtonColors
import com.example.mencoeslogcat.ui.theme.mbButtonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MencoesLogcatTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("PAM 2")
            ActionButton(
                text = "I",
                buttonColors = iButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.e(TAG, "App: Nota I")
            }
            ActionButton(
                text = "R",
                buttonColors = rButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.w(TAG, "App: Nota R")
            }
            ActionButton(
                text = "B",
                buttonColors = bButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.i(TAG, "App: Nota B")
            }
            ActionButton(
                text = "MB",
                buttonColors = mbButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Nota MB")
                } catch(ex: Exception) {
                    /* Ação do Botão */
                    Log.d(TAG, "${ex.message}")
                }
            }
            TextField()
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    EtecZLImage()
    Text(
        text = "ATIVIDADE DE $name!",
        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppView() {
    MencoesLogcatTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(text = "Cadastrar") {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MencoesLogcatTheme {
        Greeting("PAM 2")
    }
}

@Composable
fun EtecZLImage() {
    val image = painterResource(R.drawable.eteczl_logo)
    Image(
        painter = image,
        contentDescription = "Logo da Etec Zona Leste"
    )
}

@Composable
fun TextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Digite o seu nome") }
    )
}