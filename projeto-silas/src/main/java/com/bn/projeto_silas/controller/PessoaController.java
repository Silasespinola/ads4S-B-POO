package com.bn.projeto_silas.controller;

import com.bn.projeto_silas.model.Pessoa;
import com.bn.projeto_silas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.adicionarPessoa(pessoa);
    }

    @GetMapping
    public Collection<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }
}
