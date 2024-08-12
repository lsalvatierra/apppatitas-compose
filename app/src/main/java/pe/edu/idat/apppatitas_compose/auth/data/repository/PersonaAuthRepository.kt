package pe.edu.idat.apppatitas_compose.auth.data.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import pe.edu.idat.apppatitas_compose.core.bd.PersonasDao
import javax.inject.Inject

class PersonaAuthRepository @Inject constructor(
    private val personaDao: PersonasDao
) {

    suspend fun insertarPersona(personaEntity: PersonaEntity){
        personaDao.insertarPersona(personaEntity)
    }
    suspend fun actualizarPersona(personaEntity: PersonaEntity){
        personaDao.actualizarPersona(personaEntity)
    }

}