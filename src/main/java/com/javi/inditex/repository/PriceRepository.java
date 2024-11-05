package com.javi.inditex.repository;

import com.javi.inditex.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Repositorio para gestionar las operaciones de la entidad PriceEntity.
 */
@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {


    /**
     * Método para encontrar precios basados en el identificador del producto,
     * el identificador de la marca y la fecha de aplicación en orden descendente de prioridad.
     */
    @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId "
            + "AND :applicationDate BETWEEN p.startDate AND p.endDate "
            + "ORDER BY p.priority DESC")
    List<PriceEntity> findPrices(@Param("productId") int productId,
                                 @Param("brandId") int brandId,
                                 @Param("applicationDate") LocalDateTime applicationDate);
}