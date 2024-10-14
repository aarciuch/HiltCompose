package tm.lab.hiltcompose.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persons::class], version = 1, exportSchema = false)
abstract class PersonsDB : RoomDatabase() {
    abstract fun personsDao() : PersonsDao
}