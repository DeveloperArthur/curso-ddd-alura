package com.globo.jv.checkout.bff.domain.specificationPatternExample.solucao;

import java.time.LocalDate;

public interface RetirementSpecification {
  boolean isEnableForRetirement(Employee employee);

  //factory pattern
  static RetirementSpecification create(LocalDate date){
    if (date.isAfter(LocalDate.of(2020, 7, 13))){
      return new RetirementLaw1232020Specification();
    } else {
      return new RetirementLaw2342022Specification();
    }
  }
}
