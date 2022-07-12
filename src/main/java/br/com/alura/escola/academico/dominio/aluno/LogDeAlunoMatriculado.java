package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected void reageAo(Evento evento) {
        System.out.println("Aluno com CPF "+((AlunoMatriculado) evento).getCpf().getNumero()+" matriculaldo na data "+evento.momento());
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
