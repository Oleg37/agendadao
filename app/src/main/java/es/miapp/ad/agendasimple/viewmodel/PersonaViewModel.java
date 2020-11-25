package es.miapp.ad.agendasimple.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import es.miapp.ad.agendasimple.model.entity.Persona;
import es.miapp.ad.agendasimple.model.room.AgendaRepositorio;

public class PersonaViewModel extends AndroidViewModel {

    private AgendaRepositorio repositorio;
    private final LiveData<List<Persona>> listAllPersona;

    public PersonaViewModel(@NonNull Application application) {
        super(application);
        repositorio = new AgendaRepositorio(application);
        listAllPersona = repositorio.getLiveListaPersona();
    }

    public LiveData<List<Persona>> getListAllPersona() {
        return listAllPersona;
    }

    public void insertar(Persona persona) {
        repositorio.insertPersona(persona);
    }

    public void borrarPersona(Persona persona) {
        repositorio.borrarPersona(persona);
    }

    public void borrarAgenda() {
        repositorio.borrarAgenda();
    }

    public void editarPersona(Persona persona) {
        repositorio.editarPersona(persona);
    }
}
