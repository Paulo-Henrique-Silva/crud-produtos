package com.paulo.crudprodutos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.crudprodutos.modelo.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> { }
