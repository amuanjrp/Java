package com.example.projeto.reposity;

import com.example.projeto.entity.ProdutoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoReposity extends JpaRepository<ProdutoEntity, Long> {
    Optional<ProdutoEntity> findBylote (String lote);
}
