package es.miapp.ad.agendasimple.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.miapp.ad.agendasimple.model.entity.Persona;

@Dao
public interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertaPersona(Persona persona);

    @Update
    void actualizaPersona(Persona persona);

    @Delete
    void eliminaPersona(Persona persona);

    @Query("SELECT * FROM Persona ORDER BY nombreAgenda")
    LiveData<List<Persona>> getAllLive();

    @Query("DELETE FROM Persona")
    void eliminarTodo();
}
