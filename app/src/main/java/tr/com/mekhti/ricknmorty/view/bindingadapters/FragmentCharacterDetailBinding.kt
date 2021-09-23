package tr.com.mekhti.ricknmorty.view.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class FragmentCharacterDetailBinding {

    companion object {

        @BindingAdapter("loadImg")
        @JvmStatic
        fun loadImg(img: ShapeableImageView, url: String) {
            Glide.with(img.context).load(url).into(img)
        }

        @BindingAdapter("status","species")
        @JvmStatic
        fun setStatusNSpecie(txt: TextView, status: String, species: String) {
            txt.text = "$status, $species"
        }

    }

}