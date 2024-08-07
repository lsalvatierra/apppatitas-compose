package pe.edu.idat.apppatitas_compose.home.domain

import pe.edu.idat.apppatitas_compose.auth.data.repository.AuthRepository
import pe.edu.idat.apppatitas_compose.home.data.network.request.VoluntarioRequest
import pe.edu.idat.apppatitas_compose.home.data.network.response.MascotaResponse
import pe.edu.idat.apppatitas_compose.home.data.network.response.VoluntarioResponse
import pe.edu.idat.apppatitas_compose.home.data.repository.MascotaRepository
import javax.inject.Inject

class MascotaUseCase @Inject
constructor(private val repository: MascotaRepository) {

    suspend operator fun invoke()
            : List<MascotaResponse> {
        return repository.listarMascota()
    }
}