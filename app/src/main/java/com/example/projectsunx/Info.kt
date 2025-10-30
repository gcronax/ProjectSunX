package com.example.projectsunx

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun info(navController: NavHostController, modifier: Modifier = Modifier, imagen: Int){
    Column {
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
    }

}