package aminbadh.anishelf.screens

import aminbadh.anishelf.components.AniDTO
import aminbadh.anishelf.data.aniList
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class AddScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val instance = AniDTO();

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Add New",
                            style = TextStyle(fontFamily = FontFamily.Serif, fontSize = 24.sp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { navigator.pop() },
                            content = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            },
                        )
                    },
                    actions = {
                        IconButton(onClick = {
                            aniList = aniList.plus(instance)
                            navigator.pop()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Save",
                            )
                        }
                    })
            },
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp)) {
                val title = remember { mutableStateOf("") }
                val genre = remember { mutableStateOf("") }
                val url = remember { mutableStateOf("") }

                TextField(
                    title.value,
                    onValueChange = {
                        title.value = it
                        instance.title = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            "Title"
                        )
                    },
                )

                Box(modifier = Modifier.height(16.dp))

                TextField(
                    genre.value,
                    onValueChange = {
                        genre.value = it
                        instance.genre = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            "Genre"
                        )
                    },
                )

                Box(modifier = Modifier.height(16.dp))

                TextField(
                    url.value,
                    onValueChange = {
                        url.value = it
                        instance.url = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            "Image URL"
                        )
                    },
                )
            }
        }
    }

}