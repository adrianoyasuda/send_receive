package receptor.br.com.edu.ifpr.yasuda.receptor

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Intent.ACTION_SEND == intent.action && intent.type != null){
            if ("text/multiline" == intent.type){
                val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
                if(sharedText != null)
                    txt_rcb.text = sharedText

            }
            else if(intent.type.startsWith("image/")){
                (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let{uri->
                    img_recebida.setImageURI(uri)

                }
            }
        }

    }
}
