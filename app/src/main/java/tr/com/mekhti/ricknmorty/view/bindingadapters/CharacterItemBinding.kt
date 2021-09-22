package tr.com.mekhti.ricknmorty.view.bindingadapters

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class CharacterItemBinding {

    companion object {

        @BindingAdapter("loadUrl")
        @JvmStatic
        fun loadUrl(img: ShapeableImageView, url: String) {
            Glide.with(img.context).load(url).into(img)
        }

    }

}