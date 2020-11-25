package es.miapp.ad.agendasimple.model.room;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import es.miapp.ad.agendasimple.model.dao.PersonaDao;
import es.miapp.ad.agendasimple.model.entity.Persona;

import static es.miapp.ad.agendasimple.AgendaApplication.threadExecutor;

@Database(entities = {Persona.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {

    private volatile static AgendaDatabase INSTANCE;

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            threadExecutor.execute(() -> {
                PersonaDao dao = INSTANCE.getPalabroDao();
                dao.eliminarTodo();

                Persona persona = new Persona("Paco", "Gustavo Gutiérrez", 638567412, "13/08/2000", "Granada", "El Caladero", 18);
                dao.insertaPersona(persona);
                persona = new Persona("Francisco", "Adolfo Macelex", 618569800, "30/10/1998", "Jaen", "Los Matorrales", 10);
                dao.insertaPersona(persona);
                persona = new Persona("Sara", "Holza Triam", 765458930, "14/09/1999", "Málaga", "San Petenery", 1);
                dao.insertaPersona(persona);
                persona = new Persona("Lola", "Golaica Tusla", 610985612, "22/11/1994", "Barcelona", "Plaza Los Cármenes", 38);
                dao.insertaPersona(persona);
                persona = new Persona("Alfonso", "Uritre Polaco", 675656321, "20/01/1998", "Huelva", "Los Matorrales", 10);
                dao.insertaPersona(persona);
                persona = new Persona("Clara", "Salts Rodríguez", 789989054, "23/05/2003", "Ourense", "Calle Lacix", 5);
                dao.insertaPersona(persona);
            });
        }
    };

    static synchronized AgendaDatabase getDB(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    , AgendaDatabase.class
                    , "BD_Agenda").build();
            Toast.makeText(context, "Base de datos creada", Toast.LENGTH_SHORT).show();
        }
        return INSTANCE;
    }

    public static AgendaDatabase getBaseDatos(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            , AgendaDatabase.class
                            , "BD_Agenda").addCallback(callback).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract PersonaDao getPalabroDao();
}
