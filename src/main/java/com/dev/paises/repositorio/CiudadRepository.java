/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.paises.repositorio;

import com.dev.paises.model.Ciudad;
import com.dev.paises.model.Departamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author HOGAR
 */
public interface CiudadRepository  extends JpaRepository<Ciudad,Long>{
    public List<Ciudad> findByDepartamento(Departamento departamento);
}
