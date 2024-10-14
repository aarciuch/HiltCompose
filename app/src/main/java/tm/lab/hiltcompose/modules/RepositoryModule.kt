package tm.lab.hiltcompose.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tm.lab.hiltcompose.repository.PersonsRepository
import tm.lab.hiltcompose.repository.PersonsRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPersonsRepository(impl: PersonsRepositoryImpl) : PersonsRepository
}