package tr.com.mekhti.ricknmorty.network


import retrofit2.Response
import retrofit2.http.GET
import tr.com.mekhti.ricknmorty.network.responses.GetCharactersResult

interface RickNMortyService {

    @GET("character")
    suspend fun getCharacters() : Response<GetCharactersResult>

}
