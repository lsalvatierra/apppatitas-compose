package pe.edu.idat.apppatitas_compose.auth.data.db.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import pe.edu.idat.apppatitas_compose.core.bd.PersonasDao
import javax.inject.Inject

class PersonaAuthService @Inject constructor(
    private val personasDao: PersonasDao
) {

}