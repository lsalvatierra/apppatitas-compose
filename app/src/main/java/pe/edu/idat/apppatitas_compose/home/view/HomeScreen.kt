package pe.edu.idat.apppatitas_compose.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.OfflinePin
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.edu.idat.apppatitas_compose.R
import pe.edu.idat.apppatitas_compose.core.rutas.Ruta
import pe.edu.idat.apppatitas_compose.core.utils.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(items = opcionesMenu(), onItemClick = { item ->
                coroutineScope.launch {
                    drawerState.close()
                }
                when (item.title) {
                    "Mascotas" -> navController.navigate(Ruta.mascotaScreen.path)
                    "Voluntario" -> navController.navigate(Ruta.voluntarioScreen.path)
                    // Manejar otros elementos del menú si es necesario
                }
            })
        },
        content = {
            Column {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    ),
                    title = { Text("Patitas APP") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
                NavHost(
                    navController = navController,
                    startDestination = Ruta.mascotaScreen.path
                ) {
                    composable(Ruta.mascotaScreen.path) { mascotaScreen() }
                    composable(Ruta.voluntarioScreen.path) { voluntarioScreen() }
                    // Agrega otras rutas aquí si es necesario
                }
            }
        }
    )

}

@Composable
fun DrawerContent(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    Column(Modifier
        .fillMaxSize()
        .background(Color.White)
        .systemBarsPadding()) {
        // Header
        UserHeader()
        Spacer(modifier = Modifier.height(8.dp))
        // Menu items
        items.forEach { item ->
            DrawerMenuItem(item = item, onItemClick = onItemClick)
        }
    }
}

@Composable
fun UserHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.imgperfil), // Reemplaza con tu imagen
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Sandra Adams", fontWeight = FontWeight.Bold)
            Text(text = "sandra_a88@gmail.com", color = Color.Gray)
        }
    }
}

@Composable
fun DrawerMenuItem(
    item: MenuItem,
    onItemClick: (MenuItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = item.icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.title)
    }
}


fun opcionesMenu(): List<MenuItem>{
    val menuItems = listOf(
        MenuItem(Icons.Default.Folder, "Mascotas"),
        MenuItem(Icons.Default.People, "Voluntario")
    )
    return menuItems
}