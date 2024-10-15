package tm.lab.hiltcompose.repository

import kotlinx.coroutines.flow.Flow
import tm.lab.hiltcompose.db.Persons
import tm.lab.hiltcompose.db.PersonsDao
import javax.inject.Inject

class PersonsRepositoryImpl @Inject constructor(private val personsDao : PersonsDao) : PersonsRepository {
    override suspend fun insertPerson(person: Persons) {
        personsDao.insertPerson(person)
    }

    override fun getAllPersons(): Flow<List<Persons>> = personsDao.getAllPersons()

    override fun getPersonsSize(): Flow<Int> = personsDao.getPersonsSize()

    override suspend fun clearPersons() {
        personsDao.clearPersons()
    }

    override suspend fun delelePersonById(userID: Long) {
        personsDao.deletePersonById(userID)
    }

}