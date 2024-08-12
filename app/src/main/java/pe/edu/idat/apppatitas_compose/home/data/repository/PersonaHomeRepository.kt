package pe.edu.idat.apppatitas_compose.home.data.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import pe.edu.idat.apppatitas_compose.core.bd.PersonasDao
import javax.inject.Inject

class PersonaHomeRepository @Inject constructor(
    private val personaDao: PersonasDao
) {

    suspend fun eliminarPersona(){
        personaDao.eliminarPersona()
    }

    fun obtenerPersona(): Flow<PersonaEntity> {
        return personaDao.obtenerPersona()
    }
}