package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWhatsAppTheme {

                var tituloPasado by rememberSaveable { mutableStateOf("IES caminas") }
                var show by remember { mutableStateOf(false) }
                var select by remember { mutableIntStateOf(1) }

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = "MyWhatsApp")
                            },
                            actions = {
                                var expanded by remember { mutableStateOf(false) }

                                Column(Modifier.padding(20.dp)) {
                                    IconButton(
                                        onClick = {
                                            expanded = true
                                        }) {
                                        Icon(imageVector = Icons.Filled.MoreVert,
                                            contentDescription = "Buscar",
                                        )
                                    }

                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false },
                                    ) {
                                        DropdownMenuItem(
                                            onClick = { expanded = false
                                                select=1
                                            },
                                            leadingIcon ={
                                                Icon(imageVector = Icons.Filled.Share,
                                                    contentDescription = "stagg")
                                            },
                                            text = {Text(text = "a"
                                            )}
//                                                    stringResource(R.string.stag123)

                                        )
                                        DropdownMenuItem(
                                            onClick = { expanded = false
                                                select=2
                                            },
                                            leadingIcon ={
                                                Icon(imageVector = Icons.Filled.Lock,
                                                    contentDescription = "lazy")
                                            },
                                            text = {Text(text = "lazy")},

                                            )

                                    }
                                }
                            },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        )
                        var state by remember { mutableStateOf(0) }
                        val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")
                        Column {
                            PrimaryTabRow(selectedTabIndex = state) {
                                titles.forEachIndexed { index, title ->
                                    Tab(
                                        selected = state == index,
                                        onClick = { state = index },
                                        text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) },
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                text = "Text tab ${state + 1} selected",
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }
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
                    when(select){
                        1->principal(modifier = Modifier.padding(innerPadding))
                        2->secundario(modifier = Modifier.padding(innerPadding))
                    }

                    NavHost(navController = navController, startDestination = "Principal") {
                        composable("Principal") {

                        }
                        composable("Secundario") {

                        }

                    }
                }

            }
        }
    }
}



@Composable
fun principal(modifier: Modifier) {

}

@Composable
fun secundario(modifier: Modifier) {

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
