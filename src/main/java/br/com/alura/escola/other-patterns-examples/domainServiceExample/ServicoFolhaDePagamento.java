/*
Domain Service é uma classe que contém operações que 
implementam regras de negócio que envolvem várias entidades 
e/ou objetos de valor. Ele geralmente é utilizado quando a 
lógica de negócio não é responsabilidade de uma única entidade, 
mas sim de várias entidades que trabalham juntas para alcançar 
um determinado objetivo. O Domain Service permite encapsular 
essa lógica em uma classe que pode ser reutilizada em diferentes 
partes do sistema, melhorando a modularidade e a coesão do código.

Nesse exemplo, a classe ServicoFolhaDePagamento implementa a lógica 
de processamento da folha de pagamento, que envolve vários objetos de 
valor e entidades, como Funcionario, Salario e Pagamento. Além disso, 
a classe utiliza dois repositórios, RepositorioDeFuncionarios e RepositorioDePagamentos, 
para buscar os funcionários e salvar os pagamentos. Por isso, essa classe é 
classificada como um Domain Service.

A classe MatricularAluno (em academico/aplicacao/aluno) é responsável por executar 
a operação de matrícula de um único aluno, ou seja, ela está relacionada apenas 
com a entidade Aluno e não envolve a interação com outras entidades ou objetos de valor. 
Por isso, ela não é considerada um Domain Service, mas sim uma operação de aplicação que 
utiliza a entidade Aluno para realizar uma tarefa específica.
*/

public class ServicoFolhaDePagamento {

    private final RepositorioDeFuncionarios repositorioDeFuncionarios;
    private final RepositorioDePagamentos repositorioDePagamentos;

    public ServicoFolhaDePagamento(RepositorioDeFuncionarios repositorioDeFuncionarios, RepositorioDePagamentos repositorioDePagamentos) {
        this.repositorioDeFuncionarios = repositorioDeFuncionarios;
        this.repositorioDePagamentos = repositorioDePagamentos;
    }

    public void processarFolhaDePagamento(Mes mes, int ano) {
        List<Funcionario> funcionarios = repositorioDeFuncionarios.buscarTodos();
        for (Funcionario funcionario : funcionarios) {
            Salario salario = funcionario.calcularSalario(mes, ano);
            Pagamento pagamento = new Pagamento(funcionario, salario, mes, ano);
            repositorioDePagamentos.salvar(pagamento);
        }
    }
}
