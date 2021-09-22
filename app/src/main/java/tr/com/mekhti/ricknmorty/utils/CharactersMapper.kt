package tr.com.mekhti.ricknmorty.utils

import tr.com.mekhti.ricknmorty.model.RNMCharacter
import tr.com.mekhti.ricknmorty.network.responses.GetCharactersResult

object CharactersMapper {

    fun mapToCharacters(resp : GetCharactersResult) : ArrayList<RNMCharacter> {
        val characters : ArrayList<RNMCharacter> = arrayListOf()

        resp.results.forEach {
            characters.add(
                RNMCharacter(
                    it.name,
                    it.image,
                    it.status,
                    it.species,
                    it.gender,
                    it.episode
                )
            )
        }

        return characters
    }

}