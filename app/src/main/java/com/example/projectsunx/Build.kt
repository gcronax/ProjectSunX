package com.example.projectsunx

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.projectsunx.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch
import kotlin.text.contains


data class cartas(
    val titulo: String,
    val direccion: Int
)


@Composable
fun Build(navController: NavHostController, modifier: Modifier = Modifier,
          direccion: (Int) -> Unit,snackbarHostState: SnackbarHostState ) {
    val cartaSelect = remember {
        mutableStateListOf(
            cartas("Corona solar", R.drawable.corona_solar),
            cartas("Erupcion", R.drawable.erupcionsolar),
            cartas("Espiculas", R.drawable.espiculas),
            cartas("Filamentos", R.drawable.filamentos),
            cartas("Magnetosfera", R.drawable.magnetosfera),
            cartas("Manchasolar", R.drawable.manchasolar)
        )
    }
    val scope = rememberCoroutineScope()
        LazyVerticalStaggeredGrid(
            modifier = modifier.fillMaxSize(),
//                .height(834.dp),
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(cartaSelect.size) { indice ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable {
                                direccion(cartaSelect[indice].direccion)
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        cartaSelect[indice].titulo,
                                        duration = SnackbarDuration.Short
                                        )
                                }
                            }
                    ) {
                        Image(
                            painter = painterResource(id = cartaSelect[indice].direccion),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Spacer(Modifier.size(5.dp))
                            Text(
                                text = cartaSelect[indice].titulo,
                                modifier = Modifier.padding(5.dp),
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.size(5.dp))
                            Spacer(Modifier.size(5.dp))

                            var expanded by remember { mutableStateOf(false) }
                            Column {
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
                                ) {
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = false

                                            cartaSelect.add(cartaSelect[indice])


                                        },
                                        leadingIcon ={
                                            Icon(imageVector = Icons.Filled.Add,
                                                contentDescription = "Copiar")
                                        },
                                        text = {Text(text = "Copiar")}

                                    )
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = false
                                            cartaSelect.remove(cartaSelect[indice])


                                                  },
                                        leadingIcon ={
                                            Icon(imageVector = Icons.Filled.Delete,
                                                contentDescription = "Eliminar")
                                        },
                                        text = {Text(text = "Eliminar")},

                                        )

                                }
                            }

                            Spacer(Modifier.size(5.dp))
                        }
                    }
                }
            }
        )

}
