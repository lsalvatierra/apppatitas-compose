package pe.edu.idat.apppatitas_compose.auth.domain

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.repository.AuthRepository
import pe.edu.idat.apppatitas_compose.auth.data.repository.PersonaAuthRepository
import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import javax.inject.Inject

class RegistroPersonaUseCase @Inject constructor(
    private val repository: PersonaAuthRepository){

    suspend operator fun invoke(personaEntity: PersonaEntity){
        return repository.insertarPersona(personaEntity)
    }
}