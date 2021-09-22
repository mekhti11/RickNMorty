package tr.com.mekhti.ricknmorty.network

import retrofit2.Response
import tr.com.mekhti.ricknmorty.network.responses.GetCharactersResult

class Repository {

    suspend fun getCharacters() : GetCharactersResult?{
        val request = NetworkLayer.apiClient.getCharacters()

        if (request.isSuccessful){
            return request.body()!!
        }

        return null
    }

}