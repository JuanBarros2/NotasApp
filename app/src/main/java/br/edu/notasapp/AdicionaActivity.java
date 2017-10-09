package br.edu.notasapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.notasapp.domain.Materia;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdicionaActivity extends AppCompatActivity {

    @BindView(R.id.materia_field)
    public EditText campoMaterial;
    @BindView(R.id.nota1_field)
    public EditText nota1_field;
    @BindView(R.id.nota2_field)
    public EditText nota2_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona);
        ButterKnife.bind(this);
        if(savedInstanceState != null){
            Materia materia = (Materia) savedInstanceState.getSerializable("MATERIA");
            campoMaterial.setText(materia.getNome());
            nota1_field.setText(materia.getNota1().toString());
            nota2_field.setText(materia.getNota2().toString());
        }
    }

    @OnClick(R.id.add_btn)
    public void onBtnClick(Button btn) {
        String nome = campoMaterial.getText().toString();
        Double nota1 = Double.valueOf(nota1_field.getText().toString());
        Double nota2 = Double.valueOf(nota2_field.getText().toString());

        Bundle bundle = new Bundle();

        bundle.putString("NOME", nome);
        bundle.putDouble("NOTA1", nota1);
        bundle.putDouble("NOTA2", nota2);
        // OU
        bundle.putSerializable("MATERIA", new Materia(nome, nota1, nota2));

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String nome = campoMaterial.getText().toString();
        Double nota1 = Double.valueOf(nota1_field.getText().toString());
        Double nota2 = Double.valueOf(nota2_field.getText().toString());

        outState.putSerializable("MATERIA", new Materia(nome, nota1, nota2));
    }
}
