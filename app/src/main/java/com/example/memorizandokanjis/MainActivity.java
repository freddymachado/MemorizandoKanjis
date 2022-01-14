package com.example.memorizandokanjis;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonJugar1;
    Button botonJugar2;
    Button botonJugar3;
    Button botonJugar4;
    Button botonJugar5;
    Button botonSalir;

     String nivel="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        botonJugar1 = (Button) findViewById(R.id.botonJugar1);
        botonJugar2 = (Button) findViewById(R.id.botonJugar2);
        botonJugar3 = (Button) findViewById(R.id.botonJugar3);
        botonJugar4 = (Button) findViewById(R.id.botonJugar4);
        botonJugar5 = (Button) findViewById(R.id.botonJugar5);
        botonSalir = (Button) findViewById(R.id.botonSalir);

        botonJugar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar1();
            }
        });
        botonJugar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar2();
            }
        });
        botonJugar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar3();
            }
        });
        botonJugar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar4();
            }
        });
        botonJugar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar5();
            }
        });


        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void jugar1(){
        Intent i = new Intent(this, Juego.class);
        nivel="1";
        i.putExtra("nivel",nivel);
        startActivity(i);
    }
    public void jugar2(){
        Intent i = new Intent(this, Juego.class);
        nivel="2";
        i.putExtra("nivel",nivel);
        startActivity(i);
    }
    public void jugar3(){
        Intent i = new Intent(this, Juego.class);
        nivel="3";
        i.putExtra("nivel",nivel);
        startActivity(i);
    }
    public void jugar4(){
        Intent i = new Intent(this, Juego.class);
        nivel="4";
        i.putExtra("nivel",nivel);
        startActivity(i);
    }
    public void jugar5(){
        Intent i = new Intent(this, Juego.class);
        nivel="5";
        i.putExtra("nivel",nivel);
        startActivity(i);
    }

}
