package pe.edu.idat.apppatitas_compose.auth.domain

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.auth.data.repository.AuthRepository
import javax.inject.Inject

class RegistroUseCase @Inject
constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(registroRequest: RegistroRequest)
            : RegistroResponse {
        return repository.registro(registroRequest)
    }

}