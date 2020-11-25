package es.miapp.ad.agendasimple.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Persona {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "nombreAgenda")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "apellidosAgenda")
    private String apellidos;

    @ColumnInfo(name = "numeroTelefono")
    private int numeroTel;

    @NonNull
    @ColumnInfo(name = "fechaNacimientoPersona")
    private String fecNac;

    @NonNull
    @ColumnInfo(name = "localidad")
    private String localidad;

    @Nullable
    @ColumnInfo(name = "calle")
    private String calle;

    @ColumnInfo(name = "numeroVivienda")
    private int numeroViv;

    public Persona(@NonNull String nombre, @NonNull String apellidos, int numeroTel, @NonNull String fecNac, @NonNull String localidad, @Nullable String calle, int numeroViv) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroTel = numeroTel;
        this.fecNac = fecNac;
        this.localidad = localidad;
        this.calle = calle;
        this.numeroViv = numeroViv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    @NonNull
    public String getFecNac() {
        return fecNac;
    }

    @NonNull
    public String getLocalidad() {
        return localidad;
    }

    @NonNull
    public String getCalle() {
        return calle;
    }

    public int getNumeroViv() {
        return numeroViv;
    }
}