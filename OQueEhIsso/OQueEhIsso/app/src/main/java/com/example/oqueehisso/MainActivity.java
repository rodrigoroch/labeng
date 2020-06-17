package com.example.oqueehisso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView resultadoTxt;
    Button apresentar;
    ImageView conteudo;
    int[] imagens = {R.drawable.tubarao, R.drawable.leao, R.drawable.cavalo, R.drawable.pinguim, R.drawable.pomba, R.drawable.pato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultadoTxt = findViewById(R.id.resultado);
        apresentar = findViewById(R.id.calc);

        conteudo = findViewById(R.id.img);

        /*getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_container, new Animais())
                .commit();*/

        botao();
    }

    public void botao(){
        apresentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ativarVoz();
            }
        });
    }

    private static final int SPEECH_REQUEST_CODE = 0;

    private void ativarVoz(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0).toString();


            switch (spokenText){
                case "tubarão":
                    resultadoTxt.setText("Tubarão");
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resultadoTxt.setText("");
                            conteudo.setImageResource(R.drawable.leao);
                            apresentar.setVisibility(View.VISIBLE);
                        }
                    }, 5000);



                    /*getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.frame_container, new Animais())
                            .commit();*/
                    break;
                case "leão":
                    mostrarTexto(spokenText);
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resultadoTxt.setText("");
                            conteudo.setImageResource(R.drawable.cavalo);
                            apresentar.setVisibility(View.VISIBLE);
                        }
                    }, 5000);

                    break;
                case "cavalo":
                    mostrarTexto(spokenText);
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resultadoTxt.setText("");
                            conteudo.setImageResource(R.drawable.pinguim);
                            apresentar.setVisibility(View.VISIBLE);
                        }
                    }, 5000);
                    break;

                case "pinguim":
                    mostrarTexto(spokenText);
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler5 = new Handler();
                    handler5.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resultadoTxt.setText("");
                            conteudo.setImageResource(R.drawable.pomba);
                            apresentar.setVisibility(View.VISIBLE);
                        }
                    }, 5000);
                    break;

                case "pomba":
                    mostrarTexto(spokenText);
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler6 = new Handler();
                    handler6.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resultadoTxt.setText("");
                            conteudo.setImageResource(R.drawable.pato);
                            apresentar.setVisibility(View.VISIBLE);
                        }
                    }, 5000);
                    break;

                case "pato":
                    mostrarTexto(spokenText);
                    apresentar.setVisibility(View.INVISIBLE);

                    final Handler handler7 = new Handler();
                    handler7.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), FinalizouOJogo.class);
                            startActivity(intent);
                        }
                    }, 5000);
                    break;

                default:
                    Toast.makeText(getApplicationContext(), "Que pena você errou!", Toast.LENGTH_LONG).show();
                    break;


            }
            spokenText = "";
        }
    }

    public String mostrarTexto(String s){
        resultadoTxt.setText(s);
        return s;
    }

}
