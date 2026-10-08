package cib.erpipa.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var nom : String = ""
    private var pes : Int = 80

    private var altura : Int = 170


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         var btPlus : Button
         var btMinus : Button
         var btCalcular : Button
         var tvPes : TextView
         var tvResuNom : EditText
         var tvVerNombre : TextView
         var tvResuIMC : TextView
         var sbAltura : SeekBar = findViewById(R.id.sbAltura)
         var tvAltura : TextView = findViewById(R.id.tvAlturaNum)

        btPlus = findViewById(R.id.btPesMes)
        btMinus = findViewById(R.id.btPesMenos)
        btCalcular = findViewById(R.id.bt_calcular)
        tvPes = findViewById(R.id.tvPesoNum)
        tvResuNom = findViewById(R.id.etNombre)
        tvResuIMC = findViewById(R.id.tv_resuICM)
        tvVerNombre = findViewById(R.id.tv_resuNom)

        sbAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean){
                altura = progress
                tvAltura.text  = altura.toString()
            }

            override fun onStartTrackingTouch(SeekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(SeekBar: SeekBar?) {

            }
        })

        btPlus.setOnClickListener(){
            pes++
            tvPes.text = pes.toString()
        }

        btMinus.setOnClickListener() {
            pes--
            tvPes.text = pes.toString()
        }

       btCalcular.setOnClickListener() {
            nom = tvResuNom.text.toString()
           tvVerNombre.text = "Hola, $nom"
            // TODO calcular imc
           val alturametros = altura / 100.0
            var imc = pes / (alturametros * alturametros)
            tvResuIMC.text = imc.toString()
        }

    }

}