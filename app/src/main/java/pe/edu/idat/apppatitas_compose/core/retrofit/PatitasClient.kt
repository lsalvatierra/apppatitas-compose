package pe.edu.idat.apppatitas_compose.core.retrofit

import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.request.RegistroRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.data.network.response.RegistroResponse
import pe.edu.idat.apppatitas_compose.home.data.network.request.VoluntarioRequest
import pe.edu.idat.apppatitas_compose.home.data.network.response.MascotaResponse
import pe.edu.idat.apppatitas_compose.home.data.network.response.VoluntarioResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface PatitasClient {

    @POST("login.php")
    suspend fun login(@Body requestLogin: LoginRequest)
        : Response<LoginResponse>

    @PUT("persona.php")
    suspend fun registro(@Body requestRegistro: RegistroRequest)
        : Response<RegistroResponse>

    @GET("mascotaperdida.php")
    suspend fun listarMascota(): Response<List<MascotaResponse>>

    @POST("personavoluntaria.php")
    suspend fun registrarVoluntario(@Body requestVoluntario: VoluntarioRequest):
            Response<VoluntarioResponse>

}