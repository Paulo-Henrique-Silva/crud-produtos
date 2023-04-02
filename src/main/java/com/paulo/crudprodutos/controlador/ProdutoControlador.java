package com.paulo.crudprodutos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paulo.crudprodutos.enums.Categoria;
import com.paulo.crudprodutos.modelo.Produto;
import com.paulo.crudprodutos.servico.ProdutoServico;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {
    
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping("")
    public ModelAndView verLista() {
        List<Produto> produtos = produtoServico.obterTodos();
        Categoria[] categorias = Categoria.values();

        ModelAndView listaModelAndView = new ModelAndView("lista");
        listaModelAndView.addObject("produtos", produtos);
        listaModelAndView.addObject("categorias", categorias);

        return listaModelAndView;
    }

    @PostMapping("") 
    public String adicionarProduto(@Valid Produto produto) {
        produtoServico.adicionar(produto);

        return "redirect:/produtos"; //"chama" o método get de produtos
    }

    @GetMapping("/editar/{id}")
    public ModelAndView verEditarProduto(@PathVariable Long id) {
        Categoria[] categorias = Categoria.values();
        Produto produto = produtoServico.obterPorId(id).get();

        ModelAndView adicionarModelAndView = new ModelAndView("editar_produto");
        adicionarModelAndView.addObject("categorias", categorias);
        adicionarModelAndView.addObject("produto", produto);

        return adicionarModelAndView;
    }

    @PostMapping("/editar/{id}")
    public String editarProduto(Produto produto) {
        produtoServico.editar(produto);

        return "redirect:/produtos";
    }
}
