package com.paulo.crudprodutos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paulo.crudprodutos.servico.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoControlador {
    
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping("")
    public ModelAndView verLista() {
        ModelAndView listaModelAndView = new ModelAndView("lista");

        return listaModelAndView;
    }
}
