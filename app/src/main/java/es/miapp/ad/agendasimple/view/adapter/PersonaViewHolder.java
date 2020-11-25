package es.miapp.ad.agendasimple.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.miapp.ad.agendasimple.R;

public class PersonaViewHolder extends RecyclerView.ViewHolder {

    private final TextView tVNombre, tVApellido, tVId, tVTelefono, tVFecNac, tVLocalidad, tVCalle, tVNumero;

    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        tVNombre = itemView.findViewById(R.id.tVNombre);
        tVApellido = itemView.findViewById(R.id.tVApellido);
        tVId = itemView.findViewById(R.id.tVId);
        tVTelefono = itemView.findViewById(R.id.tVTelefono);
        tVFecNac = itemView.findViewById(R.id.tVFecNac);
        tVLocalidad = itemView.findViewById(R.id.tVLocalidad);
        tVCalle = itemView.findViewById(R.id.tVCalle);
        tVNumero = itemView.findViewById(R.id.tVNumero);
    }

    static PersonaViewHolder create(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_persona, viewGroup, false);

        return new PersonaViewHolder(view);
    }

    public void settVNombre(String text) {
        tVNombre.setText(text);
    }

    public void settVApellido(String text) {
        tVApellido.setText(text);
    }

    public void settVId(String text) {
        tVId.setText(text);
    }

    public void settVTelefono(String text) {
        tVTelefono.setText(text);
    }

    public void settVFecNac(String text) {
        tVFecNac.setText(text);
    }

    public void settVLocalidad(String text) {
        tVLocalidad.setText(text);
    }

    public void settVCalle(String text) {
        tVCalle.setText(text);
    }

    public void settVNumero(String text) {
        tVNumero.setText(text);
    }
}
