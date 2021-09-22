package tr.com.mekhti.ricknmorty.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RNMCharacter(
    val name : String,
    val image : String,
    val status : String,
    val species : String,
    val gender : String,
    val episodes : List<String>
) : Parcelable
