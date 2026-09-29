package com.example.projeto.service;

import com.example.projeto.entity.ProdutoEntity;
import com.example.projeto.reposity.ProdutoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoReposity reposity;

    public List<ProdutoEntity> listarTodosProdutos(){
        return reposity.findAll();

    }

    public ProdutoEntity salvarProduto(ProdutoEntity produto){
        if (reposity.findBylote(produto.getLote()).isPresent())
            throw new IllegalArgumentException("Produto já cadastrado.");

        return reposity.save(produto);
    }

    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produto){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado.");

        produto.setId(id);
        return reposity.save(produto);
    }

    public void excluirProduto(Long id){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado.");

        reposity.deleteById(id);
    }
}
