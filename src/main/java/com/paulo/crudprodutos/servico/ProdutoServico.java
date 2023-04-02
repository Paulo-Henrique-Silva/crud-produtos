package com.paulo.crudprodutos.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.crudprodutos.modelo.Produto;
import com.paulo.crudprodutos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> obterTodos() {
        return produtoRepositorio.findAll();
    }

    public Produto adicionar(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public Optional<Produto> obterPorId(Long id) {
        return produtoRepositorio.findById(id);
    }
}
