package tr.com.mekhti.ricknmorty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tr.com.mekhti.ricknmorty.databinding.EpisodeItemBinding

class EpisodesAdapter(private var episodes : List<String>)
    : RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>() {




    class EpisodeViewHolder(private val binding: EpisodeItemBinding)
        :RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: String){
            binding.episode = episode

            binding.executePendingBindings()
        }


        companion object {
            fun from(parent : ViewGroup) : EpisodeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EpisodeItemBinding.inflate(layoutInflater,parent,false)
                return EpisodeViewHolder(binding)
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(episodes[position])
    }

    override fun getItemCount(): Int {
        return episodes.size
    }
}