
package com.protocolo.individual.domain.core.exception;

public class EquipoCompletoException extends RuntimeException {

    public EquipoCompletoException(int maximo) {
        super("El equipo ya alcanzó el máximo de " + maximo + " jugadores");
    }
}

