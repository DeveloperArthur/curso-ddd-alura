package br.com.alura.escola.gamificacao.infraestrutura.selo;

import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAluno(CPF cpf) {
        return this.selos
                .stream()
                .filter(s -> cpf.getNumero().equals(s.getCpfDoAluno()))
                .collect(Collectors.toList());
    }
}
