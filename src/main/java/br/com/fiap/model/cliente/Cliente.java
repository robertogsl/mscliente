package br.com.fiap.model.cliente;

import br.com.fiap.model.endereco.Endereco;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document
public class Cliente {

    private CPF cpf;

    private Email email;

    private Integer telefone;

    private String nome;

    private List<Endereco> enderecos;

    public Cliente(CPF cpf, Email email, Integer telefone, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nome = nome;
        this.enderecos.add(endereco);
    }

    public void setEnderecos(Endereco endereco) {
        this.enderecos.add(endereco);
    }
}
