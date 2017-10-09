package br.edu.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.edu.notasapp.domain.Materia;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO = 555;

    //@BindView(R.id.adiciona_btn)
    //Button adiciona_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.adiciona_btn)
    public void callAddActivity(View view){
        Intent intent = new Intent(this, AdicionaActivity.class);
        //Terá foco maior em aulas posteriores
        startActivityForResult(intent, CODIGO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO && resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();

            Materia materia = (Materia) bundle.getSerializable("MATERIA");
            //Use uma constante pois é muito fácil errar o nome e isso compromete a legibilidade
        }
    }
}
