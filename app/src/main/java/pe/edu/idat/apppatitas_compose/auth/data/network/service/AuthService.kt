package pe.edu.idat.apppatitas_compose.auth.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.retrofitclient.PatitasClient
import javax.inject.Inject

class AuthService @Inject constructor(
    private val patitasClient: PatitasClient) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return withContext(Dispatchers.IO){
            val response = patitasClient.login(loginRequest)
            response.body()!!
        }
    }
}