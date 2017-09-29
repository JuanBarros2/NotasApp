package br.edu.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        ButterKnife.bind(this);
        setContentView(R.layout.activity_adiciona);
    }

    @OnClick(R.id.add_btn)
    public void onBtnClick(Button btn){
    }


}
