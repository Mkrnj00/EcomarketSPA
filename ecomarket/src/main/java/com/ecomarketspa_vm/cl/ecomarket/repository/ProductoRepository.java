package com.ecomarketspa_vm.cl.ecomarket.repository;
import com.ecomarketspa_vm.cl.ecomarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{

}
