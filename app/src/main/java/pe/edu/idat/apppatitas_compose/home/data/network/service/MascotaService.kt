package pe.edu.idat.apppatitas_compose.home.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.core.retrofit.PatitasClient
import pe.edu.idat.apppatitas_compose.home.data.network.request.VoluntarioRequest
import pe.edu.idat.apppatitas_compose.home.data.network.response.MascotaResponse
import pe.edu.idat.apppatitas_compose.home.data.network.response.VoluntarioResponse
import javax.inject.Inject

class MascotaService @Inject constructor(
    private val patitasClient: PatitasClient
) {

    suspend fun listarMascota(): List<MascotaResponse> {
        return withContext(Dispatchers.IO){
            val response = patitasClient.listarMascota()
            response.body()!!
        }
    }

    suspend fun registrarVoluntario(voluntarioRequest: VoluntarioRequest): VoluntarioResponse {
        return withContext(Dispatchers.IO){
            val response = patitasClient.registrarVoluntario(voluntarioRequest)
            response.body()!!
        }
    }
}