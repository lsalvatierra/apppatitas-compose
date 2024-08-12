package pe.edu.idat.apppatitas_compose.auth.data.repository

import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import pe.edu.idat.apppatitas_compose.core.bd.PersonaDao
import javax.inject.Inject

class PersonaAuthRepository @Inject constructor(
    private val personaDao: PersonaDao
) {

    suspend fun insertarPersona(personaEntity: PersonaEntity){
        personaDao.insertarPersona(personaEntity)
    }


}