package com.example.mywhatsapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialogDefaults.containerColor

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme
import com.example.mywhatsapp.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWhatsAppTheme {

                var show by remember { mutableStateOf(false) }
                var select by remember { mutableIntStateOf(1) }

                val navController = rememberNavController()
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    rememberTopAppBarState()
                )
                var state by remember { mutableStateOf(0) }
                val titles = listOf("Chat", "Novedades", "Llamadas")

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            scrollBehavior = scrollBehavior,
                            title = { Text(text = "MyWhatsApp")
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                    }) {
                                    Icon(imageVector = Icons.Filled.Search,
                                        contentDescription = "Buscar",
                                    )
                                }
                                IconButton(
                                    onClick = {
                                    }) {
                                    Icon(imageVector = Icons.Filled.Share,
                                        contentDescription = "Buscar",
                                    )
                                }
                            },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor =  Color(0xFF007B70),
                                titleContentColor = Color(0xFFBCC2B1),
                            )
                        )
                    },
                    floatingActionButton = {

                        FloatingActionButton(
                            onClick = { show=false
                                navController.navigate("Principal")
                            }
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Floating action button.")
                        }


                    }
                )
                { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        PrimaryTabRow(
                            selectedTabIndex = state,
                            containerColor =  Color(0xFF007B70),
                            contentColor = Color(0xFFBCC2B1)
                            ) {
                            titles.forEachIndexed { index, title ->
                                Tab(
                                    selected = state == index,
                                    onClick = { state = index },
                                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) },
                                )
                            }

                        }
                        when(state){
                            0->Chat(modifier = Modifier)
                            1->Novedades(modifier = Modifier)
                            2->Llamadas(modifier = Modifier)

                        }

                    }




                    NavHost(navController = navController, startDestination = "Chat") {
                        composable("Chat") {

                        }
                        composable("Novedades") {

                        }
                        composable("Llamadas") {

                        }

                    }
                }

            }
        }
    }
}



@Composable
fun Chat(modifier: Modifier) {
    Row (modifier=modifier){ Text(text = "chat") }

}

@Composable
fun Novedades(modifier: Modifier) {
    Text(text = "novedades")

}

@Composable
fun Llamadas(modifier: Modifier) {
    Text(text = "llamadas")

}

@Composable
fun IconDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(20.dp)) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(imageVector = Icons.Filled.MoreVert,
                contentDescription = "Buscar",
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
//            modifier = modifier.align(Alignment.End)
        ) {
            DropdownMenuItem(
                onClick = { expanded = false
                },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Share,
                        contentDescription = "Compartir")
                },
                text = {Text(text = "Compartir")}

            )
            DropdownMenuItem(
                onClick = { expanded = false },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Compartir")
                },
                text = {Text(text = "Album")},

                )

        }
    }
}
