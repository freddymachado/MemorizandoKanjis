package com.example.memorizandokanjis;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.memorizandokanjis.R.drawable.star;

public class Juego extends Activity {

    //los botones del juego
    ImageButton el0, el1, el2, el3, el4, el5, el6, el7,
            el8, el9, el10, el11, el12, el13, el14, el15, starU, starD, starT;



    //los botones del menú
    Button reiniciar, salir;

    //los kanjis
    int kanjis[];
    //los hiraganas
    int hiragana[];
    //se guardan duplicadas en un array
    ImageButton [] botonera = new ImageButton[16];

    //declaramos las estrellas
    /*ImageView star1=(ImageView) findViewById(R.id.star1);
    ImageView star2=(ImageView) findViewById(R.id.star2);
    ImageView star3=(ImageView) findViewById(R.id.star3);*/

    //imagen de fondo;
    int fondo;
    //declaramos el contador de movimientos
    int moves;

    //para barajar
//el ArrayList que recoge el resultado de barajar
    ArrayList<Integer> arrayBarajado;

    //COMPARACIÓN
//los botones que se han pulsado y se comparan
    ImageButton primero;
    //posiciones de las imágenes a comparar en el vector de imágenes
    int numeroPrimero, numeroSegundo;

    //durante un segundo se bloquea el juego y no se puede pulsar ningún botón
    boolean bloqueo = false;

    //para controlar las pausas del juego
    final Handler handler = new Handler();

    //finalmente, el número de aciertos y la puntuación
    int aciertos=0;
    int errores=0;
    TextView textoPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        //NUEVAS LÍNEAS

        cargarImagenes();
        botonesMenu();
        iniciar();
    }

    public void cargarImagenes(){
        String dato = getIntent().getStringExtra("nivel");

        switch (dato) {
            case "1":
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Nivel 1", Toast.LENGTH_LONG);
                toast1.show();
                kanjis = new int[]{
                        R.drawable.n1k1,
                        R.drawable.n1k2,
                        R.drawable.n1k3,
                        R.drawable.n1k4,
                        R.drawable.n1k5,
                        R.drawable.n1k6,
                        R.drawable.n1k7,
                        R.drawable.n1k8,
                };
                hiragana = new int[]{
                        R.drawable.n1h1,
                        R.drawable.n1h2,
                        R.drawable.n1h3,
                        R.drawable.n1h4,
                        R.drawable.n1h5,
                        R.drawable.n1h6,
                        R.drawable.n1h7,
                        R.drawable.n1h8,
                };
                break;

            case "2":
                Toast toast2 = Toast.makeText(getApplicationContext(),
                        "Nivel 2", Toast.LENGTH_LONG);
                toast2.show();
                kanjis = new int[]{
                        R.drawable.n2k1,
                        R.drawable.n2k2,
                        R.drawable.n2k3,
                        R.drawable.n2k4,
                        R.drawable.n2k5,
                        R.drawable.n2k6,
                        R.drawable.n2k7,
                        R.drawable.n2k8,
                };
                hiragana = new int[]{
                        R.drawable.n2h1,
                        R.drawable.n2h2,
                        R.drawable.n2h3,
                        R.drawable.n2h4,
                        R.drawable.n2h5,
                        R.drawable.n2h6,
                        R.drawable.n2h7,
                        R.drawable.n2h8,
                };
                break;

            case "3":
                Toast toast3 = Toast.makeText(getApplicationContext(),
                        "Nivel 3", Toast.LENGTH_LONG);
                toast3.show();
                kanjis = new int[]{
                        R.drawable.n3k1,
                        R.drawable.n3k2,
                        R.drawable.n3k3,
                        R.drawable.n3k4,
                        R.drawable.n3k5,
                        R.drawable.n3k6,
                        R.drawable.n3k7,
                        R.drawable.n3k8,
                };
                hiragana = new int[]{
                        R.drawable.n3h1,
                        R.drawable.n3h2,
                        R.drawable.n3h3,
                        R.drawable.n3h4,
                        R.drawable.n3h5,
                        R.drawable.n3h6,
                        R.drawable.n3h7,
                        R.drawable.n3h8,
                };
                break;

            case "4":
                Toast toast4 = Toast.makeText(getApplicationContext(),
                        "Nivel 4", Toast.LENGTH_LONG);
                toast4.show();
                kanjis = new int[]{
                        R.drawable.n4k1,
                        R.drawable.n4k2,
                        R.drawable.n4k3,
                        R.drawable.n4k4,
                        R.drawable.n4k5,
                        R.drawable.n4k6,
                        R.drawable.n4k7,
                        R.drawable.n4k8,
                };
                hiragana = new int[]{
                        R.drawable.n4h1,
                        R.drawable.n4h2,
                        R.drawable.n4h3,
                        R.drawable.n4h4,
                        R.drawable.n4h5,
                        R.drawable.n4h6,
                        R.drawable.n4h7,
                        R.drawable.n4h8,
                };
                break;

            case "5":
                Toast toast5 = Toast.makeText(getApplicationContext(),
                        "Nivel 5", Toast.LENGTH_LONG);
                toast5.show();
                kanjis = new int[]{
                        R.drawable.n5k1,
                        R.drawable.n5k2,
                        R.drawable.n5k3,
                        R.drawable.n5k4,
                        R.drawable.n5k5,
                        R.drawable.n5k6,
                        R.drawable.n5k7,
                        R.drawable.n5k8,
                };
                hiragana = new int[]{
                        R.drawable.n5h1,
                        R.drawable.n5h2,
                        R.drawable.n5h3,
                        R.drawable.n5h4,
                        R.drawable.n5h5,
                        R.drawable.n5h6,
                        R.drawable.n5h7,
                        R.drawable.n5h8,
                };
                break;

            default:
                Toast toast6 = Toast.makeText(getApplicationContext(),
                        "error", Toast.LENGTH_LONG);
                toast6.show();

                break;
        }

        fondo = R.drawable.anvs;

        starU = (ImageButton) findViewById(R.id.star1);
        starD = (ImageButton) findViewById(R.id.star2);
        starT = (ImageButton) findViewById(R.id.star3);
        //Quedamos en copiar el proceso ya escrito para la correcta invocacion del imageButton

    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultadoA = new ArrayList<Integer>();
        for(int i=0; i<longitud; i++)
            resultadoA.add(i % longitud/2);
        Collections.shuffle(resultadoA);
        return  resultadoA;
    }

    public void cargarBotones(){
        el0 = (ImageButton) findViewById(R.id.boton00);
        botonera[0] = el0;
        el1 = (ImageButton) findViewById(R.id.boton01);
        botonera[1] = el1;
        el2 = (ImageButton) findViewById(R.id.boton02);
        botonera[2] = el2;
        el3 = (ImageButton) findViewById(R.id.boton03);
        botonera[3] = el3;
        el4 = (ImageButton) findViewById(R.id.boton04);
        botonera[4] = el4;
        el5 = (ImageButton) findViewById(R.id.boton05);
        botonera[5] = el5;
        el6 = (ImageButton) findViewById(R.id.boton06);
        botonera[6] = el6;
        el7 = (ImageButton) findViewById(R.id.boton07);
        botonera[7] = el7;
        el8 = (ImageButton) findViewById(R.id.boton08);
        botonera[8] = el8;
        el9 = (ImageButton) findViewById(R.id.boton09);
        botonera[9] = el9;
        el10 = (ImageButton) findViewById(R.id.boton10);
        botonera[10] = el10;
        el11 = (ImageButton) findViewById(R.id.boton11);
        botonera[11] = el11;
        el12 = (ImageButton) findViewById(R.id.boton12);
        botonera[12] = el12;
        el13 = (ImageButton) findViewById(R.id.boton13);
        botonera[13] = el13;
        el14 = (ImageButton) findViewById(R.id.boton14);
        botonera[14] = el14;
        el15 = (ImageButton) findViewById(R.id.boton15);
        botonera[15] = el15;

        textoPuntuacion = (TextView)findViewById(R.id.textoPuntuacion);
        textoPuntuacion.setText("Puntuación: ");
    }

    public void botonesMenu(){
        reiniciar = (Button) findViewById(R.id.Reiniciar);
        salir = (Button) findViewById(R.id.Salir);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){//ningún botón ha sido pulsado
            //el botón primero será el que acabamos de pulsar
            primero = imgb;
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(kanjis[arrayBarajado.get(i)]);
            //bloqueamos el botón
            primero.setEnabled(false);
            //almacenamos el valor de arrayBarajado[i]
            numeroPrimero=arrayBarajado.get(i);
            moves++;
            if(moves==16){
                starT.setBackground(null);
            } else if(moves==22){
                starD.setBackground(null);
            }
        }else{//ya hay un botón descubierto
            //bloqueamos todos los demás
            bloqueo=true;
            //el botón segundo será el que acabamos de pulsar
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(hiragana[arrayBarajado.get(i)]);
            //bloqueamos el botón
            imgb.setEnabled(false);
            //almacenamos el valor de arrayBarajado.get(i)
            numeroSegundo=arrayBarajado.get(i);
            if(numeroPrimero==numeroSegundo){//si coincide el valor los dejamos   destapados
                //reiniciamos
                primero=null;
                bloqueo=false;
                //aumentamos los aciertos y la puntuación
                aciertos++;

                //puntuacion++;
                textoPuntuacion.setText("Puntuación: ");
                //al llegar a 8 aciertos se ha ganado el juego
                if(aciertos==8){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Has  ganado!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{//si NO coincide el valor los volvemos a tapar al cabo de un segundo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //les ponemos la imagen de fondo
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.anvs);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(R.drawable.anvs);
                        //los volvemos a habilitar
                        primero.setEnabled(true);
                        imgb.setEnabled(true);
                        //reiniciamos la variables auxiliares
                        primero = null;
                        bloqueo = false;
                        //restamos uno a la puntuación
                        errores++;

                    }
                }, 1000);//al cabo de un segundo
            }
        }
    }

    public void iniciar(){
        arrayBarajado = barajar(kanjis.length*2);
        cargarBotones();
        moves = 0;
        starD.setBackgroundResource(star);
        starT.setBackgroundResource(star);

        //MOSTRAMOS LA IMAGEN
        for(int i=0; i<kanjis.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(kanjis[arrayBarajado.get(i)]);
        }

        for(int i=8; i<hiragana.length*2; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(hiragana[arrayBarajado.get(i)]);
        }

        //Y EN UN SEGUNDO LA OCULTAMOS
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        //AÑADIMOS LOS EVENTOS A LOS BOTONES DEL JUEGO
        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        errores=0;
        textoPuntuacion.setText("Puntuación: ");
    }
}
