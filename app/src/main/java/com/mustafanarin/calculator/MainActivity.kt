package com.mustafanarin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun btnSayiTik(view: View){
        if (yeniOperator){
            sayiGoster.setText("")
        }
        yeniOperator=false

        var btnSec = view as Button
        var btnTikDeger:String = sayiGoster.text.toString()
        when(btnSec.id){
            sifir.id->{
                btnTikDeger+="0"
            }
            bir.id->{
                btnTikDeger+="1"
            }
            iki.id->{
                btnTikDeger+="2"
            }
            uc.id->{
                btnTikDeger+="3"
            }
            dort.id->{
                btnTikDeger+="4"
            }
            bes.id->{
                btnTikDeger+="5"
            }
            alti.id->{
                btnTikDeger+="6"
            }
            yedi.id->{
                btnTikDeger+="7"
            }
            sekiz.id->{
                btnTikDeger+="8"
            }
            dokuz.id->{
                btnTikDeger+="9"
            }
            toplamBolu.id->{
                btnTikDeger="-"+btnTikDeger
            }
        }
        sayiGoster.setText(btnTikDeger)

    }

    var operator = ""
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOpTik(view: View){
        var btnSec = view as Button
        when(btnSec.id){
            bolme.id->{
                operator="/"
            }
            carpma.id->{
                operator="x"
            }
            toplama.id->{
                operator="+"
            }
            eksi.id->{
                operator="-"
            }
        }

        eskiSayi=sayiGoster.text.toString()
        yeniOperator=true
    }

    fun btnEsittirTik(view: View){
        var yeniSayi = sayiGoster.text.toString()
        var sonucSayisi:Double? = null
        when(operator){
            "/"->{
                sonucSayisi=eskiSayi.toDouble()/yeniSayi.toDouble()
            }
            "-"->{
                sonucSayisi=eskiSayi.toDouble()-yeniSayi.toDouble()
            }
            "x"->{
                sonucSayisi=eskiSayi.toDouble()*yeniSayi.toDouble()
            }
            "+"->{
                sonucSayisi=eskiSayi.toDouble()+yeniSayi.toDouble()
            }
        }
        sayiGoster.setText(sonucSayisi.toString())
        yeniOperator=true
    }

    fun btnSilTik(view: View){
        sayiGoster.setText("0")
        yeniOperator=true
    }

    fun btnYuzde(view: View){
        var sayi:Double = sayiGoster.text.toString().toDouble()/100
        sayiGoster.setText(sayi.toString())
        yeniOperator=true
    }



}