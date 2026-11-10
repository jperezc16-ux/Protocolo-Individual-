
package com.protocolo.individual.domain.core.valueobject;

import java.util.Objects;
import java.util.UUID;

public final class EquipoId {

    private final UUID valor;

    private EquipoId(UUID valor) {
        this.valor = valor;
    }

    public static EquipoId nuevo() {
        return new EquipoId(UUID.randomUUID());
    }

    public static EquipoId of(String texto) {
        return new EquipoId(UUID.fromString(texto));
    }

    public UUID valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipoId)) return false;
        return valor.equals(((EquipoId) o).valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
