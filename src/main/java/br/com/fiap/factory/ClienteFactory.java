package br.com.fiap.factory;

import br.com.fiap.model.cliente.CPF;
import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.model.cliente.Email;
import br.com.fiap.model.endereco.Endereco;

public class ClienteFactory {

    private Cliente cliente;

    public ClienteFactory comTodosArgumentos(String cpf, String email, Integer telefone, String nome, Integer cep, Integer numero, String bloco, Integer apartamento) {
        EnderecoFactory enderecoFactory = new EnderecoFactory();

        if (bloco.isBlank() && apartamento.describeConstable().isEmpty()) {
            this.cliente = new Cliente(new CPF(cpf), new Email(email), telefone, nome, enderecoFactory.comCepNumero(cep, numero).criar());
        }
        else if (bloco.isBlank()) {
            this.cliente = new Cliente(new CPF(cpf), new Email(email), telefone, nome, enderecoFactory.comCepNumeroApartamento(cep, numero, apartamento).criar());
        }
        else {
            this.cliente = new Cliente(new CPF(cpf), new Email(email), telefone, nome, enderecoFactory.comTodosArgumentos(cep, numero, bloco, apartamento).criar());
        }
        return this;
    }

    public Cliente criar() {
        return this.cliente;
    }
}
