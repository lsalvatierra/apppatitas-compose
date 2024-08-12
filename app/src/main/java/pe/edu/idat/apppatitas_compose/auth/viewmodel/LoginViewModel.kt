package pe.edu.idat.apppatitas_compose.auth.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.domain.LoginUseCase
import pe.edu.idat.apppatitas_compose.auth.domain.RegistroPersonaUseCase
import pe.edu.idat.apppatitas_compose.core.bd.PersonaEntity
import pe.edu.idat.apppatitas_compose.core.utils.Event
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registroPersonaUseCase: RegistroPersonaUseCase
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private var _isLoginEnable = MutableLiveData<Boolean>()
    var isLoginEnable: LiveData<Boolean> = _isLoginEnable
    private val _loginResponse = MutableLiveData<Event<LoginResponse>>()
    val loginResponse: LiveData<Event<LoginResponse>> = _loginResponse

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = habilitarButtonLogin(email, password)
    }

    fun loginUserPassword(){
        viewModelScope.launch {
            val response = loginUseCase(
                LoginRequest(
                    email.value!!,
                    password.value!!
                )
            )
            _loginResponse.value = Event(response)
            registroPersonaUseCase(PersonaEntity(
                response.idpersona.toInt(),
                response.nombres,
                response.apellidos, response.email, response.celular, response.usuario,
                response.password, response.esvoluntario
            ))
        }

    }

    fun habilitarButtonLogin(email: String, password: String) =
        email.length > 1 && password.length > 1
}