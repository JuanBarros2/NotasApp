package br.edu.notasapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.notasapp.domain.Materia;

/**
 * Created by juan on 22/10/17.
 */

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder>{

    private List<Materia> lista;
    private OnItemSelected listener;

    public MateriaAdapter(List<Materia> materias, OnItemSelected listener){
        this.lista = materias;
        this.listener = listener;
    }

    @Override
    public MateriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*Onde será feita a criação da view que aparecerá em tela. Aqui só estamos interessados
        em como será inflado o componente.
         */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.materia_viewholder, parent, false);
        MateriaViewHolder materiaViewHolder = new MateriaViewHolder(view);
        return materiaViewHolder;
    }

    @Override
    public void onBindViewHolder(MateriaViewHolder holder, int position) {
        Materia materia = lista.get(position);
        holder.nomeField.setText(materia.getNome());
        holder.mediaField.setText(materia.calcMedia().toString());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void addMateria(Materia materia){
        lista.add(materia);
        notifyItemInserted(lista.size());
    }

    public void removeMateria(Materia materia){
        int position = lista.indexOf(materia);
        if (position != -1){
            lista.remove(position);
            notifyItemRemoved(position);
        }

    }

    public void updateMateria(Materia velha, Materia nova){
        int position = lista.indexOf(velha);
        if (position != -1){
            lista.set(position, nova);
            notifyItemChanged(position);
        }
    }

    class MateriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nomeField;
        private final TextView mediaField;


        public MateriaViewHolder(View itemView) {
            super(itemView);
            this.nomeField = (TextView) itemView.findViewById(R.id.nome_text);
            this.mediaField = (TextView) itemView.findViewById(R.id.media_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(lista.get(getAdapterPosition()));
        }
    }

    interface OnItemSelected{
        void onClick(Materia materia);
    }
}
