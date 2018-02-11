/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.paises.repositorio;

import com.dev.paises.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HOGAR
 */
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    
}
