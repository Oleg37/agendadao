package es.miapp.ad.agendasimple.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import es.miapp.ad.agendasimple.R;
import es.miapp.ad.agendasimple.model.entity.Persona;
import es.miapp.ad.agendasimple.view.adapter.PersonaAdapter;
import es.miapp.ad.agendasimple.viewmodel.PersonaViewModel;

public class ListaAgendaFragment extends Fragment {

    private PersonaViewModel viewModel;
    private PersonaAdapter adapter;

    String tIETNombre, tIETApellidos, tIETFecNac, tIETLocalidad, tIETCalle;
    int tIETTelefono, tIETNumero;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fg_lista_agenda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        recibirDatos(); // No en uso

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerAgenda);
        adapter = new PersonaAdapter(new PersonaAdapter.PersonaDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(PersonaViewModel .class);

        init();
    }

    private void init() {
        viewModel.getListAllPersona().observe(getViewLifecycleOwner(), new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
                Log.v("agenda", "onChanged" + personas.toString());
                adapter.submitList(personas);
            }
        });
    }

    public void recibirDatos() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tIETNombre = bundle.getString("tIETNombre", "tIETNombre");
            tIETApellidos = bundle.getString("tIETApellidos", "tIETApellidos");
            tIETTelefono = bundle.getInt("tIETNombre", Integer.parseInt("tIETNombre"));
            tIETFecNac = bundle.getString("tIETFecNac", "tIETFecNac");
            tIETLocalidad = bundle.getString("tIETLocalidad", "tIETLocalidad");
            tIETCalle = bundle.getString("tIETCalle", "tIETCalle");
            tIETNumero = bundle.getInt("tIETNumero", Integer.parseInt("tIETNumero"));

            viewModel.insertar(new Persona(tIETNombre, tIETApellidos, tIETTelefono, tIETFecNac, tIETLocalidad, tIETCalle, tIETNumero));

            Log.v("mipersona", tIETCalle);
        }
    }
}