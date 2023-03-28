package com.globo.jv.checkout.bff.domain.specificationPatternExample.solucao;

import java.time.LocalDate;

/*
* Quando temos uma regra de negócio que
* pode mudar ao longo do tempo, o que se
* recomenda é mover a regra de negócio
* para uma classe ESPECIFICA para essa
* regra de negócio, no caso da lei
* de aposentadoria, o ideal é termos
* uma classe para cada edição da lei
*
* vantagens: toda vez que surgir uma
* nova edição da lei, basta que criemos
* uma nova implementação dessa especificação
* os testes da especificação antiga continuarão
* passando, e podemos escrever novos testes
* para a nova implementação
*/

public class Main {

  public static void main(String[] args) {
    Employee employee = new Employee();

    RetirementSpecification retirementSpecification = RetirementSpecification.create(
        LocalDate.now());

    boolean enableForRetirement = retirementSpecification.isEnableForRetirement(employee);
    System.out.println(enableForRetirement);
  }
}
