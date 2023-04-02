package com.paulo.crudprodutos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.crudprodutos.modelo.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
}
