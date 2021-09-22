package tr.com.mekhti.ricknmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tr.com.mekhti.ricknmorty.R
import tr.com.mekhti.ricknmorty.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MAINACTIVITY"
    val viewmodel : MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewmodel.getCharacters()

        viewmodel.characters.observe(this, {
            Log.d(TAG, "onCreate: "+ it?.size)
        })
    }


    fun getViewModel() : MainViewModel{
        return viewmodel
    }
}