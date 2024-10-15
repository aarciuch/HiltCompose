package tm.lab.hiltcompose.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonsDao {
    @Insert
    suspend fun insertPerson(persons: Persons)

    @Query("SELECT * FROM persons")
    fun getAllPersons() : Flow<List<Persons>>

    @Query("SELECT COUNT(*) FROM persons")
    fun getPersonsSize(): Flow<Int>

    @Query("DELETE FROM persons")
    suspend fun clearPersons()

    @Query("DELETE FROM persons WHERE id = :userId")
    suspend fun deletePersonById(userId: Long)

}