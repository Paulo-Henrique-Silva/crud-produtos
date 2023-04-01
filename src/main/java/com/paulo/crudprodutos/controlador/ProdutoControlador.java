package com.paulo.crudprodutos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paulo.crudprodutos.enums.Categoria;
import com.paulo.crudprodutos.modelo.Produto;
import com.paulo.crudprodutos.servico.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoControlador {
    
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping("")
    public ModelAndView verLista() {
        List<Produto> produtos = produtoServico.obterProdutos();
        Categoria[] categorias = Categoria.values();

        ModelAndView listaModelAndView = new ModelAndView("lista");
        listaModelAndView.addObject("produtos", produtos);
        listaModelAndView.addObject("categorias", categorias);

        return listaModelAndView;
    }
}
