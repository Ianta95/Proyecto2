package com.example.guiainteractiva;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guiainteractiva.models.Preguntas;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button respuesta1, respuesta2, respuesta3;
    TextView marcador, pregunta1, opcion1, opcion2, opcion3;

    private Preguntas mPreguntas = new Preguntas();
    private String mRespuestas;
    private int mScore = 0;
    private int mQuestionsLenght = mPreguntas.mQuestions.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        respuesta1 = (Button) findViewById(R.id.btn_pregunta1);
        respuesta2 = (Button) findViewById(R.id.btn_pregunta2);
        respuesta3 = (Button) findViewById(R.id.btn_pregunta3);

        marcador = (TextView) findViewById(R.id.texto_score);
        pregunta1 = (TextView) findViewById(R.id.texto_pregunta1);
        opcion1 = (TextView) findViewById(R.id.texto_opcion1);
        opcion2 = (TextView) findViewById(R.id.texto_opcion2);
        opcion3 = (TextView) findViewById(R.id.texto_opcion3);

        updateQuestion(r.nextInt(mQuestionsLenght));

        marcador.setText(mScore);


        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (opcion1.getText() == mRespuestas) {
                    mScore++;
                    marcador.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                } else {
                    gameOver();
                }

            }
        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (opcion2.getText() == mRespuestas) {
                    mScore++;
                    marcador.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                } else {
                    gameOver();
                }

            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (opcion3.getText() == mRespuestas) {
                    mScore++;
                    marcador.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLenght));

                } else {
                    gameOver();
                }

            }

        });}


    private void updateQuestion(int n) {
        pregunta1.setText(mPreguntas.getQuestion(n));
        opcion1.setText(mPreguntas.getChoice1(n));
        opcion2.setText(mPreguntas.getChoice2(n));
        opcion3.setText(mPreguntas.getChoice3(n));

        mRespuestas = mPreguntas.getCorrectAnswer(n);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Haz Perdido! tu marcador es: " + mScore + " puntos.")
                .setCancelable(false)
                .setPositiveButton("Nuevo Juego",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialoginterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        })
                .setNegativeButton("Salir",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}




