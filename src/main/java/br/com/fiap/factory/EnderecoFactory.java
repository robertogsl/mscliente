package br.com.fiap.factory;

import br.com.fiap.model.endereco.Endereco;

public class EnderecoFactory {

    private Endereco endereco;

    public EnderecoFactory comTodosArgumentos(Integer cep, Integer numero, String bloco, Integer apartamento) {
        this.endereco = new Endereco(cep, numero, bloco, apartamento);
        return this;
    }

    public EnderecoFactory comCepNumero(Integer cep, Integer numero) {
        this.endereco = new Endereco(cep, numero);
        return this;
    }

    public EnderecoFactory comCepNumeroApartamento(Integer cep, Integer numero, Integer apartamento) {
        this.endereco = new Endereco(cep, numero, apartamento);
        return this;
    }

    public Endereco criar() {
        return this.endereco;
    }
}
