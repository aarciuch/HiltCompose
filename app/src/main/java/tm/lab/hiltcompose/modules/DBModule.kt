package tm.lab.hiltcompose.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tm.lab.hiltcompose.db.PersonsDB
import tm.lab.hiltcompose.db.PersonsDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DBModule {
    @Provides
    //@Singleton
    fun providePersonsDao(personsDB: PersonsDB) : PersonsDao = personsDB.personsDao()

    @Provides
    @Singleton
    fun providePersonsDB(@ApplicationContext context: Context) : PersonsDB {
        return Room.databaseBuilder(
            context = context,
            PersonsDB::class.java,
            "person_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}