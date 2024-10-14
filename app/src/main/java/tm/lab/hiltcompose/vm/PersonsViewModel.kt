package tm.lab.hiltcompose.vm

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import tm.lab.hiltcompose.PersonsUiState
import tm.lab.hiltcompose.db.Persons
import tm.lab.hiltcompose.repository.PersonsRepository
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(val personsRepository: PersonsRepository): ViewModel(){

    val personsUiState : StateFlow<PersonsUiState> =
        personsRepository.getAllPersons()
            .map { PersonsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = PersonsUiState()
            )

    fun savePerson(person: Persons) {
       viewModelScope.launch {
           personsRepository.insertPerson(person)
       }
    }
    fun clearPersons() {
        viewModelScope.launch {
            personsRepository.clearPaersons()
        }
    }
}