package pe.edu.idat.apppatitas_compose.home.domain

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.home.data.network.request.VoluntarioRequest
import pe.edu.idat.apppatitas_compose.home.data.network.response.VoluntarioResponse
import pe.edu.idat.apppatitas_compose.home.data.repository.MascotaRepository
import javax.inject.Inject

class VoluntarioUseCase @Inject
constructor(private val repository: MascotaRepository) {

    suspend operator fun invoke(voluntarioRequest: VoluntarioRequest)
            : VoluntarioResponse {
        return repository.registrarVoluntario(voluntarioRequest)
    }
}