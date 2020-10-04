package com.produtos.api.resources;

import com.produtos.api.repository.ProdutoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.produtos.api.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{nome}")
    public List<Produto> pesquisaProduto(@PathVariable(value = "nome") String nome ){
        return produtoRepository.findBySearch(nome);
    }

    @GetMapping("/produto/{id}")
    public Produto produtoUnico(@PathVariable(value = "id") long id ){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
        public Map<String, String> deleteProduto(@PathVariable(value = "id") long id){
        produtoRepository.deleteById(id);
        
        HashMap<String, String> res = new HashMap<>();
        res.put("msg", "Produto Deletado");
        return res;
    }    
}
