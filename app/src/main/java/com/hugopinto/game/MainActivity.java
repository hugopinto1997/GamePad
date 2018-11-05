package com.hugopinto.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView equis, cuadrado, triangulo, circulo;
    ImageView nitro, luz, claxon, sensor;
    TextView gearbox, nitrotext, sensortext, lights;
    int gbox=1;
    Boolean nitroflag=false, lightflag=false, sensorflag=false;
    

    LinearLayout fondo;
    AnimationDrawable animacion;

    Vibrator vibrator;
    Vibrator vibrator2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        fondo = findViewById(R.id.layout);
        animacion = (AnimationDrawable) fondo.getBackground();



        //Inicializar vibracion
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator2 = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        //Botones
        equis = findViewById(R.id.cross);
        cuadrado = findViewById(R.id.square);
        triangulo = findViewById(R.id.triangle);
        circulo = findViewById(R.id.circle);

        //Features
        nitro = findViewById(R.id.nitrous);
        luz = findViewById(R.id.led);
        claxon = findViewById(R.id.pito);
        sensor = findViewById(R.id.radar);

        //Estados
        gearbox = findViewById(R.id.gearbox);
        nitrotext = findViewById(R.id.n20);
        sensortext = findViewById(R.id.usensor);
        lights = findViewById(R.id.lights);

        cuadrado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int actionS = event.getAction();
                if(nitroflag==true) {
                    if (actionS == MotionEvent.ACTION_DOWN) {
                        vibrator.vibrate(60000);
                    } else if (actionS == MotionEvent.ACTION_UP) {
                        vibrator.cancel();
                    }
                }
               // Toast.makeText(getApplicationContext(), "Reversa", Toast.LENGTH_SHORT);
                    return true;
            }
        });

        circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gbox<4){
                    gbox++;
                    vibrator2.vibrate(10);
                }
                gearbox.setText(gbox+"");
              //  Toast.makeText(getApplicationContext(), "Velocidad: "+gbox, Toast.LENGTH_SHORT).show();
            }
        });

       equis.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               int actionX = event.getAction();
               if(nitroflag==true) {
                   if (actionX == MotionEvent.ACTION_DOWN) {
                       vibrator.vibrate(60000);
                   } else if (actionX == MotionEvent.ACTION_UP) {
                       vibrator.cancel();
                   }
               }
               //Toast.makeText(getApplicationContext(), "Reversa", Toast.LENGTH_SHORT).show();
               return true;
           }
       });

        nitro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nitroflag==false){
                    nitroflag=true;
                    animacion.setEnterFadeDuration(2000);
                    animacion.setExitFadeDuration(2000);
                    animacion.start();
                    nitrotext.setText("ON");
                    vibrator.vibrate(50);
                }else{
                    nitroflag=false;
                    nitrotext.setText("OFF");
                    vibrator.cancel();
                    animacion.stop();
                    vibrator.vibrate(25);
                }
            }
        });

        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gbox>1){
                    gbox--;
                    vibrator2.vibrate(10);
                }
                gearbox.setText(gbox+"");
               // Toast.makeText(getApplicationContext(), "Velocidad: "+gbox, Toast.LENGTH_SHORT).show();
            }
        });

        luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lightflag==false){
                    lightflag=true;
                    lights.setText("ON");
                    vibrator.vibrate(50);
                }else{
                    lightflag=false;
                    lights.setText("OFF");
                    vibrator.cancel();
                    vibrator.vibrate(25);
                }
            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sensorflag==false){
                    sensorflag=true;
                    sensortext.setText("ON");
                    vibrator.vibrate(50);
                }else{
                    sensorflag=false;
                    sensortext.setText("OFF");
                    vibrator.cancel();
                    vibrator.vibrate(25);
                }
            }
        });

        claxon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int actionP = event.getAction();

                    if (actionP == MotionEvent.ACTION_DOWN) {
                        vibrator.vibrate(60000);
                        Toast.makeText(getApplicationContext(), "Claxon", Toast.LENGTH_SHORT).show();
                    } else if (actionP == MotionEvent.ACTION_UP) {
                        vibrator.cancel();
                    }

                return true;
            }
        });





    }
}
