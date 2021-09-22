package tr.com.mekhti.ricknmorty.model

data class Character(
    val name : String,
    val image : String,
    val status : String,
    val species : String,
    val gender : String,
    val episodes : List<String>
)
