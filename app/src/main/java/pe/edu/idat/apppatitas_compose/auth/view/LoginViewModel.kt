package pe.edu.idat.apppatitas_compose.auth.view

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.idat.apppatitas_compose.auth.data.network.request.LoginRequest
import pe.edu.idat.apppatitas_compose.auth.data.network.response.LoginResponse
import pe.edu.idat.apppatitas_compose.auth.domain.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private var _isLoginEnable = MutableLiveData<Boolean>()
    var isLoginEnable: LiveData<Boolean> = _isLoginEnable
    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = habilitarButtonLogin(email, password)
    }

    fun loginUserPassword(){
        viewModelScope.launch {
            _loginResponse.value = loginUseCase(
                LoginRequest(
                    email.value!!,
                    password.value!!
                )
            )
            Log.i("LOGINPATITAS", loginResponse.value!!.toString())
        }

    }

    fun habilitarButtonLogin(email: String, password: String) =
        email.length > 1 && password.length > 1
}