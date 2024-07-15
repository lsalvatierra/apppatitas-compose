package pe.edu.idat.apppatitas_compose.auth.view

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.idat.apppatitas_compose.R
import androidx.compose.runtime.livedata.observeAsState
import pe.edu.idat.apppatitas_compose.core.rutas.Ruta

@Composable
fun loginScreen(authViewModel: LoginViewModel, navController: NavController) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) {
        paddingInit ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInit)
        ) {
            header(Modifier.align(Alignment.TopEnd))
            body(Modifier.align(Alignment.Center), authViewModel, snackbarHostState, navController)
            footer(Modifier.align(Alignment.BottomCenter), navController)
        }
    }
}
@Composable
private fun header(modifier: Modifier) {
    //Obtener el contexto y convertirlo a un Activity
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Cerrar",
        modifier = modifier.clickable { activity.finish() }
    )
}
@Composable
fun footer(modifier: Modifier, navController: NavController) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        singUp(navController)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun singUp(navController: NavController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "¿No tienes cuenta?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5))
        Text(
            text = "Registrate aquí",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
                .clickable {  navController.navigate(Ruta.registroScreen.path) },
            fontWeight = FontWeight.Bold,
            color = Color(0xFF052E80),


        )
    }
}


@Composable
fun body(modifier: Modifier, loginViewModel: LoginViewModel,
         state: SnackbarHostState, navController: NavController) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)
    Column(modifier = modifier.padding(start = 5.dp, end = 5.dp)) {
        imageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        email(email) { loginViewModel.onLoginChanged(it, password) }
        Spacer(modifier = Modifier.size(4.dp))
        password(password) { loginViewModel.onLoginChanged(email, it) }
        Spacer(modifier = Modifier.size(8.dp))
        //Para poder alinear un componente hijo debe heredar el modifier del pader
        //En este caso se envia el modifier del Column ya no del Box
        Spacer(modifier = Modifier.size(16.dp))
        loginButton(isLoginEnable,
            loginViewModel,
            state,
            navController)
    }
}



@Composable
fun loginButton(loginEnable: Boolean,
                loginViewModel: LoginViewModel,
                state: SnackbarHostState,
                navController: NavController) {
    Button(
        onClick = { /*TODO*/ },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "INGRESAR")
    }
}

@Composable
fun password(password: String, onTextChanged: (String) -> Unit) {
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
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else PasswordVisualTransformation()

    )
}

@Composable
fun email(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
    )
}

@Composable
fun imageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.imgsplash),
        contentDescription = "logo",
        modifier = modifier
    )
}

