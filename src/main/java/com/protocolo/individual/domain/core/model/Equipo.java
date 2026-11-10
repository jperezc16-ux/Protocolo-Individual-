
package com.protocolo.individual.domain.core.model;

import com.protocolo.individual.domain.core.exception.EquipoCompletoException;
import com.protocolo.individual.domain.core.valueobject.EquipoId;
import com.protocolo.individual.domain.core.valueobject.NombreEquipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Equipo {

    private static final int MAX_JUGADORES = 26;

    private final EquipoId id;
    private NombreEquipo nombre;
    private final String pais;
    private String directorTecnico;

    private final List<String> jugadores = new ArrayList<>();

    public Equipo(EquipoId id, NombreEquipo nombre, String pais, String directorTecnico) {
        this.id = Objects.requireNonNull(id);
        this.nombre = Objects.requireNonNull(nombre);
        this.pais = Objects.requireNonNull(pais);
        this.directorTecnico = directorTecnico;
    }

    public void inscribirJugador(String jugador) {
        if (jugadores.size() >= MAX_JUGADORES) {
            throw new EquipoCompletoException(MAX_JUGADORES);
        }

        if (jugadores.contains(jugador)) {
            throw new IllegalArgumentException("El jugador ya está inscrito");
        }

        jugadores.add(jugador);
    }

    public void cambiarDirectorTecnico(String nuevo) {
        this.directorTecnico = nuevo;
    }

    public void renombrar(NombreEquipo nuevoNombre) {
        this.nombre = Objects.requireNonNull(nuevoNombre);
    }

    public EquipoId getId() {
        return id;
    }

    public NombreEquipo getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public List<String> getJugadores() {
        return Collections.unmodifiableList(jugadores);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        return id.equals(((Equipo) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
