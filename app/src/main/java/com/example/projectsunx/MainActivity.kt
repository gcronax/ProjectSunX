package com.example.projectsunx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectsunx.ui.theme.ProjectSunXTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectSunXTheme {
                var imagenPasarela by rememberSaveable { mutableIntStateOf(R.drawable.corona_solar) }
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(

                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet(
                            modifier = Modifier.background(Color.White),
                            drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxWidth()){
                                Image(
                                    painter = painterResource(id = imagenPasarela),
                                    contentDescription = "Header",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(350.dp)
                                )
                                Button(
                                    onClick ={
                                        navController.navigate("Primera")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE0D9F7)
                                    ),
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth().padding(horizontal = 16.dp)
                                ) {
                                    Row(horizontalArrangement = Arrangement.Start,
//                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Icon(
                                        imageVector = Icons.Default.Build,
                                        contentDescription = "Build",
                                        tint = Color.Black
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Build",
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                    }

                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick ={
                                        navController.navigate("Segunda")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE0D9F7)
                                    ),
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth().padding(horizontal = 16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = "Info",
                                        tint = Color.Black
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Info",
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick ={

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE0D9F7)
                                    ),
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth().padding(horizontal = 16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Email,
                                        contentDescription = "Email",
                                        tint = Color.Black
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Email",
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )
                                }





                            }
                        }
                    },

                ) {
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        bottomBar ={
                            BottomAppBar(
                                containerColor = Color(0xFFD31111),
                                contentColor = Color.White,
                                actions ={
                                    IconButton(onClick = {
                                        scope.launch {
                                            if (drawerState.isClosed) {
                                                drawerState.open()
                                            } else {
                                                drawerState.close()
                                            }
                                        }
                                    }) {
                                        Icon(
                                            Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Localized description")
                                    }

                                    var cunot by remember { mutableStateOf(0) }

                                    BadgedBox(
                                        badge = {
                                            if (cunot > 0) {
                                                Badge {
                                                    Text(cunot.toString())
                                                }
                                            }
                                        }
                                    ) {
                                        IconButton(
                                            onClick = { cunot++ }
                                        ) {
                                            Icon(
                                                imageVector = Icons.Filled.Favorite,
                                                contentDescription = "favorito"
                                            )
                                        }
                                    }

                                } ,
                                floatingActionButton = {
                                    FloatingActionButton(
                                        onClick = { },
                                    ) {
                                        Icon(Icons.Filled.Add, "Floating action button.")
                                    }
                                }
                            )
                        }
                    )
                    { innerPadding ->

                        NavHost(navController = navController, startDestination = "Primera") {
                            composable("Primera") {build(navController,
                                Modifier.padding(innerPadding),{imagenPasarela = it})  }
                            composable("Segunda") {info(navController,
                                Modifier.padding(innerPadding),imagenPasarela)  }

                        }
                    }
                }

            }
        }
    }
}
