package com.sa.coffebrew.repository;

import com.sa.coffebrew.entity.Comanda;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    
//    @Query(value = "SELECT * FROM comanda WHERE id_comanda = :idComanda", nativeQuery = true)
//    Optional<Comanda> findComandaByNumero(@Param("numero") Long numero);
    
    @Query(value = "SELECT * FROM comanda WHERE numero = :numero AND status = 'ATIVO'", nativeQuery = true)
    Optional<Comanda> findActiveComandaByNumero(@Param("numero") Integer numero);
    
}
