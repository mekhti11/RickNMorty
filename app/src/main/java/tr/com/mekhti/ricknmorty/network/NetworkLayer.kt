package tr.com.mekhti.ricknmorty.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tr.com.mekhti.ricknmorty.utils.Constants.Companion.BASE_URL

object NetworkLayer {

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val rickNMortyService : RickNMortyService by lazy {
        retrofit.create(RickNMortyService::class.java)
    }


    val apiClient = ApiClient(rickNMortyService)

}