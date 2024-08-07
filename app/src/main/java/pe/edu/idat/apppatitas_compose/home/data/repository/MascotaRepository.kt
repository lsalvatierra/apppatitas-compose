package pe.edu.idat.apppatitas_compose.home.data.repository

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.service.AuthService
import pe.edu.idat.apppatitas_compose.home.data.network.request.VoluntarioRequest
import pe.edu.idat.apppatitas_compose.home.data.network.response.MascotaResponse
import pe.edu.idat.apppatitas_compose.home.data.network.response.VoluntarioResponse
import pe.edu.idat.apppatitas_compose.home.data.network.service.MascotaService
import javax.inject.Inject

class MascotaRepository @Inject constructor(
    private val api: MascotaService
) {

    suspend fun listarMascota(): List<MascotaResponse>  {
        return api.listarMascota()
    }

    suspend fun registrarVoluntario(voluntarioRequest: VoluntarioRequest): VoluntarioResponse {
        return api.registrarVoluntario(voluntarioRequest)
    }
}