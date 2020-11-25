package es.miapp.ad.agendasimple.model.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import es.miapp.ad.agendasimple.AgendaApplication;
import es.miapp.ad.agendasimple.model.dao.PersonaDao;
import es.miapp.ad.agendasimple.model.entity.Persona;

public class AgendaRepositorio {
    private AgendaDatabase agendaDatabase;
    private PersonaDao personaDao;

    private LiveData<List<Persona>> liveListaPersona;

    public AgendaRepositorio(Application context) {
        agendaDatabase = AgendaDatabase.getBaseDatos(context);
        personaDao = agendaDatabase.getPalabroDao();

        liveListaPersona = personaDao.getAllLive();
    }

    public LiveData<List<Persona>> getLiveListaPersona() {
        return liveListaPersona;
    }

    public void insertPersona(Persona persona) {
        AgendaApplication.threadExecutor.execute(() -> personaDao.insertaPersona(persona));
    }

    public void borrarPersona(Persona persona) {
        AgendaApplication.threadExecutor.execute(() -> personaDao.eliminaPersona(persona));
    }

    public void borrarAgenda() {
        AgendaApplication.threadExecutor.execute(() -> personaDao.eliminarTodo());
    }

    public void editarPersona(Persona persona) {
        AgendaApplication.threadExecutor.execute(() -> personaDao.actualizaPersona(persona));
    }
}
