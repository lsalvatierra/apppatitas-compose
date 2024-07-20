package pe.edu.idat.apppatitas_compose.auth.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.retrofitclient.PatitasClient
import pe.edu.idat.apppatitas_compose.auth.data.network.service.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api:AuthService)  {

    suspend fun login(loginRequest: LoginRequest):LoginResponse{
        return api.login(loginRequest)
    }

    suspend fun registro(registroRequest: RegistroRequest):RegistroResponse{
        return api.registro(registroRequest)
    }
}