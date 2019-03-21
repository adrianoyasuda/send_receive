package envia.br.com.edu.ifpr.yasuda.envia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_enviar.setOnClickListener {
            compartilharTexto()
        }

        img_default.setOnClickListener{
            compartilharImagem()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val uri =  data?.data

        val intentshare = Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, uri)
        }
        startActivity(intentshare)
    }

    private fun compartilharTexto(){
        val shareIntent = Intent(Intent.ACTION_SEND)

        with(shareIntent) {
            putExtra(Intent.EXTRA_SUBJECT, "Compartilhar")
            putExtra(Intent.EXTRA_TEXT, txf_texto.text.toString())
            type = "text/multiline"
        }
        startActivity(shareIntent)
    }

    private fun compartilharImagem(){
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent,1)
    }
}
