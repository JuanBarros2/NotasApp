package br.edu.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.notasapp.domain.Materia;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO = 555;

    @BindView(R.id.content_list)
    RecyclerView content;

    private MateriaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        content.setLayoutManager(manager);
        content.setHasFixedSize(true);

        adapter = new MateriaAdapter(new ArrayList<Materia>(), new MateriaAdapter.OnItemSelected() {
            @Override
            public void onClick(Materia materia) {
                adapter.removeMateria(materia);
            }
        });
        content.setAdapter(adapter);


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
            adapter.addMateria(materia);
        }
    }


    /*public void addMateria(Materia materia) {
        View view = getLayoutInflater().inflate(R.layout.materia_viewholder, content, false);
        ((TextView) view.findViewById(R.id.nome_text)).setText(materia.getNome());
        ((TextView) view.findViewById(R.id.media_text)).setText(materia.getNota1().toString());

        content.addView(view);
    }*/
}
