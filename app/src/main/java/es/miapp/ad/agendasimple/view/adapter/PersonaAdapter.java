package es.miapp.ad.agendasimple.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import es.miapp.ad.agendasimple.model.entity.Persona;

public class PersonaAdapter extends ListAdapter<Persona, PersonaViewHolder> {

    public PersonaAdapter(@NonNull DiffUtil.ItemCallback<Persona> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PersonaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona current = getItem(position);
        holder.settVNombre(current.getNombre());
        holder.settVApellido(current.getApellidos());
        holder.settVId(String.valueOf(current.getId()));
        holder.settVTelefono(String.valueOf(current.getNumeroTel()));
        holder.settVFecNac(current.getFecNac());
        holder.settVLocalidad(current.getLocalidad());
        holder.settVCalle(current.getCalle());
        holder.settVNumero(String.valueOf(current.getNumeroViv()));
    }

    public static class PersonaDiff extends DiffUtil.ItemCallback<Persona> {
        @Override
        public boolean areItemsTheSame(@NonNull Persona oldItem, @NonNull Persona newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Persona oldItem, @NonNull Persona newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }
}
