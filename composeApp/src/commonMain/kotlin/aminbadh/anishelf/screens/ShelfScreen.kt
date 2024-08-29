package aminbadh.anishelf.screens

import aminbadh.anishelf.components.AniCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ShelfScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = ShelfScreenModel().fetch();
        val state = viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = {
                    Text(
                        "My Shelf",
                        style = TextStyle(fontFamily = FontFamily.Serif, fontSize = 24.sp)
                    )
                })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.push(AddScreen())
                    }
                ) { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) { paddingValues ->
            LazyColumn(
                contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(paddingValues),
            ) {
                items(state.value.size) { index ->
                    AniCard(state.value[index], onClick = { viewModel.toggle(index) })
                }
            }
        }
    }

}