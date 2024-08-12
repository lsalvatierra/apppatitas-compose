package pe.edu.idat.apppatitas_compose.home.domain

import pe.edu.idat.apppatitas_compose.home.data.repository.PersonaHomeRepository
import javax.inject.Inject

class EliminarPersonaUseCase @Inject constructor(
    private val repository: PersonaHomeRepository
)  {

    suspend operator fun invoke(){
        return repository.eliminarPersona()
    }
}