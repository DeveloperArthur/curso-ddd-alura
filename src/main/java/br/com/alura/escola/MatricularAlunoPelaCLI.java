package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.MatricularAlunoDto;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infraestrutura.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infraestrutura.aluno.RepositorioDeAlunoEmMemoria;
import br.com.alura.escola.academico.aplicacao.aluno.MatricularAluno;

public class MatricularAlunoPelaCLI {
    public static void main(String[] args) {
        String nome = "Fulano Silva";
        String cpf = "123.456.789-00";
        String email = "fluano@jdhsj";

        //domain events
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunoEmMemoria(), publicadorDeEventos);
        matricular.executa(new MatricularAlunoDto(nome, cpf, email));
    }
}
