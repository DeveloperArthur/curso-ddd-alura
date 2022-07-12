package br.com.alura.escola.academico.aplicacao.aluno;

import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.CPF;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorioDeAlunos;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos, PublicadorDeEventos publicador) {
        this.repositorioDeAlunos = repositorioDeAlunos;
        this.publicador = publicador;
    }

    public void executa(MatricularAlunoDto dados){
        Aluno novo = dados.criarAluno();
        repositorioDeAlunos.matricular(novo);

        //domain events
        //a classe PublicadorDeEventos que recebemos no parametro
        //ja tem os eventos adicionados, entao só publicamos
        AlunoMatriculado evento = new AlunoMatriculado(new CPF(novo.getCpf()));
        publicador.publicar(evento);
    }
}
