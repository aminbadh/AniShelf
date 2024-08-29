package aminbadh.anishelf.screens

import aminbadh.anishelf.components.AniDTO
import aminbadh.anishelf.data.aniList
import androidx.compose.runtime.toMutableStateList
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShelfScreenModel : ScreenModel {
    private val _state = MutableStateFlow<List<AniDTO>>(emptyList());
    val state = _state.asStateFlow();

    fun fetch(): ShelfScreenModel {
        _state.value = aniList
        return this
    }

    fun toggle(index: Int) {
        val updatedList = _state.value.toMutableList()
        if (index != -1) {
            updatedList[index] = updatedList[index].copy(watched = !updatedList[index].watched)
            _state.value = updatedList.toMutableStateList()
        }
    }
}