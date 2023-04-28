package com.globo.jv.checkout.bff.domain.specificationPatternExample.solucao;

public class RetirementLaw1232020Specification implements RetirementSpecification {

  @Override
  public boolean isEnableForRetirement(Employee employee) {
    //business rules
    return false;
  }
}
