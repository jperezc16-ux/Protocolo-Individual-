
package com.protocolo.individual.domain.core.valueobject;

import com.protocolo.individual.domain.core.exception.NombreEquipoInvalidoException;
import java.util.Objects;

public final class NombreEquipo {

    private final String valor;

    private NombreEquipo(String valor) {
        this.valor = valor;
    }

    public static NombreEquipo of(String texto) {

        if (texto == null || texto.isBlank()) {
            throw new NombreEquipoInvalidoException(
                "El nombre no puede estar vacío"
            );
        }

        String limpio = texto.trim();

        if (limpio.length() < 3 || limpio.length() > 50) {
            throw new NombreEquipoInvalidoException(
                "El nombre debe tener entre 3 y 50 caracteres"
            );
        }

        return new NombreEquipo(limpio);
    }

    public String valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NombreEquipo)) return false;
        return valor.equals(((NombreEquipo) o).valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}
