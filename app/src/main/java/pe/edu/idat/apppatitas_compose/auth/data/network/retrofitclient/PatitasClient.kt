package pe.edu.idat.apppatitas_compose.auth.data.network.retrofitclient

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface PatitasClient {

    @POST("login.php")
    fun login(@Body requestLogin: LoginRequest)
        : Response<LoginResponse>

    @PUT("persona.php")
    fun registro(@Body requestRegistro: RegistroRequest)
        : Response<RegistroResponse>


}