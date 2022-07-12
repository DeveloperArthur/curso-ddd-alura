package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

//conceito de entidade do DDD: classe que possui alguma info que diferencia ela
//de outra entidade, 2 alunos podem ter o mesmo nome e serem pessoas diferentes
//a info que diferencia é o CPF

//esta classe é um aggregate root
//pois ela é tem diversos value objects
//é responsabilidade do aggregate root manter, ele é a raiz desses value objects

//na parte de persistencia de aggregates, a ideia é seguir
//a ideia do aggregate root, salvar o telefone na tabela aluno
//da mesma forma nao faz sentido ter um repository para telefone
//abriria brecha para alterar o telefone fora do aluno
public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    //aluno como um aggregate root deve manter e fazer o controle de acesso
    //aos value objects para evitar inconsistencia
    public void adicionarTelefone(String ddd, String numero){
        Telefone telefone = new Telefone(ddd, numero);
        if (this.telefones.size() == 2){
            throw new IllegalArgumentException("Numero max de telefones atingido");
        }
        this.telefones.add(telefone);
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }
}
