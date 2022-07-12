package br.com.alura.escola.shared.dominio;

public class CPF {
    //conceito de VO (value object) pois se eu tiver 2 entidades
    //com o mesmo numero, ainda é o mesmo CPF
    //sempre que temos conceitos do dominio que, o que interessa são os valores
    // em sí e não há uma propriedade que diferencie um objeto do outro
    // e estamos falando do mesmo objeto, ai entra o padrao value object
    private String numero;

    public CPF(String numero) {
        //if (numero == null ||
        //        !numero.matches("\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}\\\\-\\\\d{2}")){
        //    throw new IllegalArgumentException("CPF invalido");
        //}
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
