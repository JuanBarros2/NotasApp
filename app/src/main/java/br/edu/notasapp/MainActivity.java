package br.edu.notasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNotas = (EditText) findViewById(R.id.editText);

    }

    public void onBtnClick(View v){
        String notas = campoNotas.getText().toString();

        Log.d("Log", notas);
        /* Utilizamos para mostrar mensagens de Log. Será tratado com mais detalhes
        posteriormente
        */
        Toast.makeText(this, notas, Toast.LENGTH_LONG).show();
        /*Não se preocupe com esse comando, ele apenas mostra uma mensagem
        na tela sem precisar de um componente específico para isso.
         */
    }
}
