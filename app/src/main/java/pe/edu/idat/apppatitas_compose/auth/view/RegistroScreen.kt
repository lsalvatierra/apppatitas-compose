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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
        txtNombreReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtApellidoReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtEmailReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtCelularReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtUsuarioReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
        txtPasswordReg(nombre) { nombre = it }
        Spacer(modifier = Modifier.size(4.dp))
    }
}

@Composable
fun txtNombreReg(nombre: String, onTextChanged: (String) -> Unit) {
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
@Composable
fun txtApellidoReg(apellido: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = apellido,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Apellidos") },
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
@Composable
fun txtEmailReg(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Icono de persona"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}
@Composable
fun txtCelularReg(celular: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = celular,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Celular") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.PhoneAndroid,
                contentDescription = "Icono de persona"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}
@Composable
fun txtUsuarioReg(celular: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = celular,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.PersonPin,
                contentDescription = "Icono de persona"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}
@Composable
fun txtPasswordReg(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password, onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "ver password")
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Password,
                contentDescription = "Icono de persona"
            )
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else PasswordVisualTransformation()

    )
}