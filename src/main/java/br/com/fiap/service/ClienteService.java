package br.com.fiap.service;

import br.com.fiap.dto.ClienteDto;
import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<ClienteDto> salvar(ClienteDto clienteDto) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteDto.cpf());
        if (cliente.isPresent()) {
            return ResponseEntity.status(400).build();
        }
        clienteRepository.save(clienteDto.toModel());
        return ResponseEntity.status(201).body(clienteDto);
    }

    public ResponseEntity<Cliente> buscar(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(cliente.get());
    }

    public ResponseEntity<Cliente> atualizar(String cpf, Cliente clienteNovo) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        clienteRepository.save(clienteNovo);
        return ResponseEntity.status(200).body(clienteNovo);
    }

    public ResponseEntity deletar(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        clienteRepository.delete(cliente.get());
        return ResponseEntity.status(200).build();
    }
}
