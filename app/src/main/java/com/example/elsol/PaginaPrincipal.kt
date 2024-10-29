import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import com.example.elsol.R

@Composable
fun Cards(modifier: Modifier = Modifier) {
    var imagenesCards by remember { mutableStateOf(
        listOf(
            R.drawable.corona_solar to "Corona solar",
            R.drawable.erupcionsolar to "Errupción solar",
            R.drawable.espiculas to "Espiculas",
            R.drawable.filamentos to "Filamentos",
            R.drawable.magnetosfera to "Magnetosfera",
            R.drawable.manchasolar to "Mancha solar"
        )
    )}

    val cardSize: Dp = 230.dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(imagenesCards.size) { index ->
            val (imagenResId, nombre) = imagenesCards[index]
            val context = LocalContext.current
            Card(
                modifier = Modifier
                    .size(cardSize)
                    .padding(4.dp),
                onClick = {
                    Toast.makeText(context, nombre, Toast.LENGTH_SHORT).show()
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = imagenResId),
                        contentDescription = nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = nombre,
                            modifier = Modifier.padding(start = 3.dp).weight(4f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        var expanded by remember { mutableStateOf(false) }

                        Icon(
                            modifier = Modifier
                                .weight(1f)
                                .size(24.dp)
                                .clickable { expanded = true },
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Menú",
                        )

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                leadingIcon = {
                                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Copiar")
                                },
                                text = { Text("Copiar") },
                                onClick = {
                                    imagenesCards = imagenesCards + (imagenResId to nombre)
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                leadingIcon = {
                                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "Borrar")
                                },
                                text = { Text("Borrar") },
                                onClick = {
                                    imagenesCards = imagenesCards.filterIndexed { idx, _ -> idx != index }
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
