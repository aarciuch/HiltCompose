package tm.lab.hiltcompose

import tm.lab.hiltcompose.db.Persons

data class PersonsUiState(val persons: List<Persons> = listOf()) {
}