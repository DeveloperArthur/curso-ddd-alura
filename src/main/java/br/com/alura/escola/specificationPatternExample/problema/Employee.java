package com.globo.jv.checkout.bff.domain.specificationPatternExample.problema;

/*
* Imagine um sistema de folha de pagamento
* onde há uma lógica que diz se um funcionário
* pode ou não se aposentar
*
* o mais comum é ter essa lógica dentro
* de uma service, ou dentro da classe
* de funcionário (caso seu domínio seja rico)
*
* mas vamos supor que o governo mude as regras
* de aposentadoria, e agora? Aqui dentra a specification
*/

public class Employee {

  public boolean isEnableForRetirement(){
    //business rules
    return false;
  }
}
