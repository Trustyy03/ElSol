package com.example.elsol

import Cards
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun Menus(navigateToPlanetariumDate: () -> Unit) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    var favoritesClickCount by rememberSaveable {
        mutableIntStateOf(0)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp),
                    painter = painterResource(id = R.drawable.erupcionsolar),
                    contentDescription = "Descripción de la imagen",
                    contentScale = ContentScale.Crop
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Build,
                                contentDescription = "Build Icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.size(20.dp))
                            Text(text = "Build")
                        }
                    },
                    selected = false,
                    onClick = {},
                    shape = RoundedCornerShape(ZeroCornerSize)
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Info Icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.size(20.dp))
                            Text(text = "Info")
                        }
                    },
                    selected = false,
                    onClick = { navigateToPlanetariumDate() },
                    shape = RoundedCornerShape(ZeroCornerSize)
                )
                NavigationDrawerItem(
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "Email Icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.size(20.dp))
                            Text(text = "Email")
                        }
                    },
                    selected = false,
                    onClick = {},
                    shape = RoundedCornerShape(ZeroCornerSize)
                )
            }
        },
        content = {
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        containerColor = Color(0xFFF91f20)
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            horizontalAlignment = Alignment.Start
                        ) {
                            IconButton(
                                onClick = {
                                    selectedItemIndex = 0
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                    contentDescription = "Atrás"
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f),
                        ) {
                            IconButton(
                                modifier = Modifier.size(80.dp),
                                onClick = {
                                    favoritesClickCount++
                                    selectedItemIndex = 1
                                },
                            ) {
                                BadgedBox(
                                    badge = {
                                        Badge {
                                            Text(text = favoritesClickCount.toString())
                                        }
                                    },
                                    modifier = Modifier.padding(10.dp)

                                ) {
                                    Icon(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favoritos"
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            horizontalAlignment = Alignment.End,
                        ) {
                            Button(
                                onClick = {
                                    selectedItemIndex = 2
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Agregar"
                                )
                            }
                        }
                    }
                },
                content = { paddingValues ->

                    Cards(Modifier.padding(paddingValues))

                }
            )
        }
    )
}