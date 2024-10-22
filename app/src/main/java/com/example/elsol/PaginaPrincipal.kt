import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import com.example.elsol.R

@Composable
fun Cards(modifier: Modifier = Modifier) {
    val imagenesCards = listOf(
        R.drawable.corona_solar to "Corona solar",
        R.drawable.erupcionsolar to "Errupción solar",
        R.drawable.espiculas to "Espiculas",
        R.drawable.filamentos to "Filamentos",
        R.drawable.magnetosfera to "Magnetosfera",
        R.drawable.manchasolar to "Mancha solar"
    )

    val cardSize: Dp = 230.dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(imagenesCards.size) { index ->
            val (imagenResId, nombre) = imagenesCards[index]

            Card(
                modifier = Modifier
                    .size(cardSize)
                    .padding(4.dp)
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
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Menú",
                            modifier = Modifier
                                .weight(1f)
                                .size(24.dp)
                        )
                    }
                }
            }
        }
    }
}
