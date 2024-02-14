package com.example.examenrecu_esterrg

import android.graphics.Paint.Align
import android.os.Bundle
import android.telephony.TelephonyCallback
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenrecu_esterrg.ui.theme.ExamenRecu_EsterRGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenRecu_EsterRGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla()
                }
            }
        }
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier){

    var textoInferior1 by remember { mutableStateOf("No has hecho ninguna acción")}
    var textoInferior2 by remember { mutableStateOf("No hay nada que mostrar (defecto)")}

    Column (){
        Text(text = "Bienvenido a la academia de Ester Rivero Goldero",
            modifier = modifier
                .weight(0.5f)
                .background(Color.LightGray)
                .padding(start = 10.dp, top = 20.dp))
        Spacer(modifier = modifier.padding(2.dp))
        AsignaturasYBotones(modifier = modifier.weight(1f)
            ,asignatura = ArrayList(DataSource.asignaturas))
        Spacer(modifier = modifier.padding(2.dp))
        Text(
            text = textoInferior1,
            modifier = modifier
                .background(Color.Magenta)
                .padding(10.dp)
            )
        Text(
            text = textoInferior2,
            modifier = modifier
                .background(Color.White)
                .padding(10.dp)
            )
    }

}

@Composable
private fun AsignaturasYBotones (modifier: Modifier = Modifier, asignatura: ArrayList<Asignatura>,
                                 /**clickAction: () -> Unit)*/){

    var horasText by remember { mutableStateOf("")}
    var horasTextNueva by remember { mutableStateOf("")}
    Column (modifier = Modifier.fillMaxWidth()){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center
            ){
               items(asignatura){ asignaturas ->
                   Card (modifier = Modifier.padding(5.dp)){
                       Text(text = "Asig: ${asignaturas.nombre}",
                           modifier = Modifier
                               .background(Color.Yellow)
                               .padding(15.dp)
                               .fillMaxWidth())
                       Text(text = "€/hora: ${asignaturas.precioHora}",
                           modifier = Modifier
                               .background(Color.Cyan)
                               .padding(15.dp)
                               .fillMaxWidth())
                       Row (modifier = Modifier
                           .align(alignment = CenterHorizontally)) {
                           Button(onClick = {
                               //clickAction.invoke()
                           }) {
                               Text(text = "+")
                           }
                           Button(onClick = {
                               //clickAction.invoke()
                           }) {
                               Text(text = "-")
                           }
                       }
                   }
               }
           }
       }
    }

