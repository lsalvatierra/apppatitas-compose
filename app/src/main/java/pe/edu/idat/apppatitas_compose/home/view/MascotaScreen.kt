package pe.edu.idat.apppatitas_compose.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun mascotaScreen() {
    // Contenido del formulario "My Files"
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "My Files")
        // Agrega los campos del formulario aquí
    }
}