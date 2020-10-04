package com.produtos.api.repository;

import java.util.List;

import com.produtos.api.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findById(long id);

    @Query(value = "SELECT * FROM tb_produto WHERE LOWER(nome) LIKE LOWER(CONCAT('%',:nome,'%'))", nativeQuery = true)
    List<Produto> findBySearch(@Param("nome") String nome);

}
