package pe.edu.idat.apppatitas_compose.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun registroScreen() {
    Scaffold { paddingInit ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInit)
        ) {
            headerRegistro()
            bodyRegistro()

        }
    }
}

@Composable
fun headerRegistro() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = Icons.Filled.Pets,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = "logo"
        )
        Text(
            text = "REGISTRO DE USUARIO",
            fontSize = 14.sp, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun bodyRegistro() {
    var nombre by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .verticalScroll(rememberScrollState())
    ) {
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtNombre(nombre) { nombre = it }

    }
}

@Composable
fun txtNombre(nombre: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = nombre,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Nombres") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icono de persona"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}
