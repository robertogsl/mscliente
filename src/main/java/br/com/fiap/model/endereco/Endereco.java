package br.com.fiap.model.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Endereco {

    private Integer cep;

    private Integer numero;

    private String bloco;

    private Integer apartamento;

    public Endereco(Integer cep, Integer numero) {
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco(Integer cep, Integer numero, Integer apartamento) {
        this.cep = cep;
        this.numero = numero;
        this.apartamento = apartamento;
    }
}
