package tm.lab.hiltcompose.repository

import kotlinx.coroutines.flow.Flow
import tm.lab.hiltcompose.db.Persons

interface PersonsRepository {
    suspend fun insertPerson(person: Persons)
    fun getAllPersons() : Flow<List<Persons>>
    fun getPersonsSize(): Flow<Int>
    suspend fun clearPersons()
    suspend fun delelePersonById(userID : Long)
}