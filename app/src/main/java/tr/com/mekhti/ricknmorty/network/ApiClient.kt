package tr.com.mekhti.ricknmorty.network

import retrofit2.Response
import tr.com.mekhti.ricknmorty.network.responses.GetCharactersResult

class ApiClient(
    private val rickNMortyService: RickNMortyService
) {

    suspend fun getCharacters() : Response<GetCharactersResult> {
        return  rickNMortyService.getCharacters()
    }

}