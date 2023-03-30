package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).get();
    }

    public Cidade inserir(Cidade objeto) {
        objeto.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(objeto);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade objeto) {
        objeto.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Cidade objeto = cidadeRepository.findById(id).get();
        cidadeRepository.delete(objeto);
    }
}