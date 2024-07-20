package pe.edu.idat.apppatitas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.idat.apppatitas_compose.auth.view.LoginViewModel
import pe.edu.idat.apppatitas_compose.auth.view.loginScreen
import pe.edu.idat.apppatitas_compose.auth.view.registroScreen
import pe.edu.idat.apppatitas_compose.core.rutas.Ruta
import pe.edu.idat.apppatitas_compose.ui.theme.ApppatitascomposeTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApppatitascomposeTheme {
                val navigation = rememberNavController()
                NavHost(navController = navigation,
                    startDestination = Ruta.loginScreen.path,
                    builder = {
                        composable(Ruta.loginScreen.path){
                            loginScreen(loginViewModel, navigation)
                        }
                        composable(Ruta.registroScreen.path) {
                            registroScreen()
                        }
                    })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApppatitascomposeTheme {
        
    }
}