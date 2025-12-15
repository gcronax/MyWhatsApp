package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywhatsapp.ui.theme.MyWhatsAppTheme
import com.example.mywhatsapp.ui.theme.Pink40
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWhatsAppTheme {

                val navController = rememberNavController()
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    rememberTopAppBarState()
                )
                val titles = listOf("Chat", "Novedades", "Llamadas")
                val coroutineScope = rememberCoroutineScope()
                val pagerState = rememberPagerState(initialPage = 0, pageCount = { titles.size })

                LaunchedEffect(pagerState.currentPage) {
                }
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
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
                                        tint = Color(0xFFBCC2B1)
                                    )
                                }
                                IconButton(
                                    onClick = {
                                    }) {
                                    Icon(imageVector = Icons.Filled.Share,
                                        contentDescription = "Buscar",
                                        tint = Color(0xFFBCC2B1)

                                    )
                                }
                            },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor =  Color(0xFF007B70),
                                titleContentColor = Color(0xFFBCC2B1),
                                scrolledContainerColor = Color(0xFF007B70)
                            )
                        )
                    },
                    floatingActionButton = {


                        FloatingActionButton(
                            containerColor=Color(0xFF007B70),
                            onClick = {
//                                coroutineScope.launch {
//                                    pagerState.animateScrollToPage(0)
//                                }
                            }
                        ) {

                            val image =
                                AnimatedImageVector.animatedVectorResource(R.drawable.ad_animaciones
                                )
                            var atEnd by remember { mutableStateOf(false) }
                            Image(
                                painter = rememberAnimatedVectorPainter(image, atEnd),
                                contentDescription = "VectorDrawable",
                                modifier = Modifier.clickable {
                                    atEnd = !atEnd
                                }.size(24.dp),
                            )
                        }



                    }
                )
                { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        PrimaryTabRow(
                            selectedTabIndex = pagerState.currentPage,
                            containerColor =  Color(0xFF007B70),
                            contentColor = Color(0xFFBCC2B1)
                            ) {
                            titles.forEachIndexed { index, title ->
                                Tab(
                                    selected = pagerState.currentPage == index,
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }
                                    },
                                    text = {
                                        Text(text = title, maxLines = 2,
                                            overflow = TextOverflow.Ellipsis)
                                           },
                                )
                            }

                        }
                        HorizontalPager(state = pagerState) { page ->

                            when(page){
                                0->Chat(modifier = Modifier)
                                1->Novedades(modifier = Modifier)
                                2->Llamadas(modifier = Modifier)

                            }
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


val itemslist = items.groupBy { it.tipo }
@Composable
fun Chat(modifier: Modifier) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        itemslist.forEach { (tipo, myItems) ->
            stickyHeader {
                Row (modifier=Modifier.background(Color(0xFFC3C3C4)).fillMaxWidth()){
                    Text(
                        text = tipo
                    )
                }

            }

            items(myItems) { index ->
                var dropmenu by remember { mutableStateOf(false) }

                Row (modifier = Modifier
                    .pointerInput(true) {
                        detectTapGestures(onLongPress = { dropmenu=!dropmenu }
                        )
                    }
                    , verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = index.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                        )
                    Spacer(Modifier.size(10.dp))
                    Text(text=index.text)
                    if(dropmenu){
                        Dropdownmenu(modifier = Modifier, ondropmenu = { dropmenu= it})
                    }
                }

            }
        }
    }

}

@Composable
fun Novedades(modifier: Modifier) {
    Column (modifier= modifier.fillMaxSize()){ Text(text = "novedades") }


}

@Composable
fun Llamadas(modifier: Modifier) {
    Column (modifier= modifier.fillMaxSize()){ Text(text = "llamadas") }

}

@Composable
fun Dropdownmenu(modifier: Modifier, ondropmenu: (Boolean)->Unit) {
    var expanded by remember { mutableStateOf(true) }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false
            ondropmenu(false)
        },
        modifier=modifier
    ) {
        DropdownMenuItem(
            onClick = { expanded = false
                ondropmenu(false)

            },
            text = {Text(text = "Salir del grupo")}

        )
        DropdownMenuItem(
            onClick = { expanded = false
                ondropmenu(false)
            },

            text = {Text(text = "Info. grupo")},

            )
        DropdownMenuItem(
            onClick = { expanded = false
                ondropmenu(false)
            },

            text = {Text(text = "Crear acceso directo")},

            )

    }
}
