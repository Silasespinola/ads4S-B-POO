package com.bn.projeto_silas.service;

import com.bn.projeto_silas.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PessoaService {

    private final Map<Long, Pessoa> bancoDePessoas = new HashMap<>();

    public Pessoa atualizarPessoa(Long id, Pessoa novaPessoa) {
        if (!bancoDePessoas.containsKey(id)) {
            throw new NoSuchElementException("Pessoa não encontrada");
        }
        novaPessoa.setId(id); // Garante que o ID permaneça
        bancoDePessoas.put(id, novaPessoa);
        return novaPessoa;
    }

    public void deletarPessoa(Long id) {
        if (!bancoDePessoas.containsKey(id)) {
            throw new NoSuchElementException("Pessoa não encontrada");
        }
        bancoDePessoas.remove(id);
    }

    public Pessoa adicionarPessoa(Pessoa pessoa) {
        bancoDePessoas.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    public Collection<Pessoa> listarPessoas() {
        return bancoDePessoas.values();
    }
}
