package br.com.elvisfarias.main.exceptions;

public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException() {
        super("Vaga não encontrada");
    }
}
