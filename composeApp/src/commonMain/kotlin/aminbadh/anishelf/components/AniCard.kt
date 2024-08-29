package aminbadh.anishelf.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

data class AniDTO(
    var url: String = "",
    var title: String = "",
    var genre: String = "",
    var watched: Boolean = false,
)

@Composable
fun AniCard(
    item: AniDTO,
    modifier: Modifier = Modifier,
    onClick: (AniDTO) -> Unit = {}
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        modifier = modifier.clickable(onClick = { onClick(item) })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            KamelImage(
                resource = asyncPainterResource(item.url),
                contentDescription = "Launch Image",
                contentScale = ContentScale.Crop,
                onFailure = {},
                onLoading = { CircularProgressIndicator() },
                modifier = Modifier.padding(end = 8.dp).clip(RoundedCornerShape(100.dp))
                    .size(46.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
                Box(Modifier.height(4.dp))
                Text(
                    item.genre,
                    style = TextStyle(fontSize = 12.sp)
                )
            }
            Icon(
                imageVector = if (item.watched) Icons.Default.Done else Icons.Rounded.Close,
                contentDescription = null,
                tint = if (item.watched) Color(0xFF008000) else Color.Unspecified,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}