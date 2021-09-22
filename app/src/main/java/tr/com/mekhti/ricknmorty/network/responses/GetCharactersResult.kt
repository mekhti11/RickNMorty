package tr.com.mekhti.ricknmorty.network.responses


import com.google.gson.annotations.SerializedName

data class GetCharactersResult(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)