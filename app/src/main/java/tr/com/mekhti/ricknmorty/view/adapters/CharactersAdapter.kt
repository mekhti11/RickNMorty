package tr.com.mekhti.ricknmorty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tr.com.mekhti.ricknmorty.databinding.CharacterItemBinding
import tr.com.mekhti.ricknmorty.model.RNMCharacter

class CharactersAdapter(
    private var characters : ArrayList<RNMCharacter>,
    private val onSelect: (RNMCharacter?) -> Unit)
    : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val leftIndex = position*2
        val rightIndex = leftIndex+1

        holder.bind(characters[leftIndex],characters[rightIndex],onSelect)
    }

    override fun getItemCount() : Int {
        val size = characters.size/2 + characters.size%2
        return size
    }



    //for paging, not implemented yet
    fun addData(newList:ArrayList<RNMCharacter>){
        val from = characters.size
        characters.addAll(newList)
        notifyItemRangeInserted(from,characters.size-1)
    }

    fun setData(newList:ArrayList<RNMCharacter>){
        characters.addAll(newList)
        notifyItemRangeInserted(0,newList.size)
    }



    class CharacterViewHolder(private val binding:CharacterItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(characterLeft:RNMCharacter,
                 characterRight:RNMCharacter,
                 onSelect: (RNMCharacter) -> Unit){

            binding.left = characterLeft
            binding.right = characterRight

            binding.clLeft.setOnClickListener { onSelect(characterLeft) }
            binding.clRight.setOnClickListener { onSelect(characterRight) }

            binding.executePendingBindings()

        }


        companion object {
            fun from(parent : ViewGroup) : CharacterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CharacterItemBinding.inflate(layoutInflater,parent,false)
                return CharacterViewHolder(binding)
            }
        }

    }
}