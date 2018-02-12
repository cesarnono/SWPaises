/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.paises.controller;

import com.dev.paises.model.Ciudad;
import com.dev.paises.model.Departamento;
import com.dev.paises.model.Pais;
import com.dev.paises.repositorio.CiudadRepository;
import com.dev.paises.repositorio.DepartamentoRepository;
import com.dev.paises.repositorio.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author César Aguirre Vega
 */

@RestController
public class RestApiApp {
    @Autowired
    PaisRepository paisRepository;
    
    @Autowired
    DepartamentoRepository departamentoRepository;
    
    @Autowired
    CiudadRepository ciudadRepository;
    
    
    @CrossOrigin
    @GetMapping("/paises") 
    public List<Pais> listarAllPaises(){
       return   paisRepository.findAll();
    }
    
    
    @GetMapping("/paises/{id}")
    public ResponseEntity<Pais> consultarPais(@PathVariable("id") Long id){
        Pais pais = paisRepository.findOne(id);
        if(pais == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pais);
    }
    
    
    @CrossOrigin
    @PostMapping("/paises")
    public Pais registrarPais(@RequestBody Pais pais){
        return paisRepository.save(pais);
    }
    
    @CrossOrigin
    @PostMapping("/departamentos")
    public List<Departamento> listarAllDepartamento(@RequestBody Pais pais){
        System.out.println("pais ->"+pais);
       return   departamentoRepository.findByPais(pais);
    }
    
    
    @GetMapping("/departamentos/{id}")
    public ResponseEntity<Departamento> consultarDepartamento(@PathVariable("id") Long id){
        Departamento departamento = departamentoRepository.findOne(id);
        if(departamento == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(departamento);
    }
    
    
    @CrossOrigin
    @PostMapping("/registrardepartamento") 
    public Departamento registrarDepartamento(@RequestBody Departamento departamento){
        System.out.println("registrar departamento -> "+departamento);
        return departamentoRepository.save(departamento);
    }
    
    @CrossOrigin
    @PostMapping("/ciudades")
    public List<Ciudad> listarAllCiudad(@RequestBody Departamento departamento){
       return   ciudadRepository.findByDepartamento(departamento);
    }
    
    
    @GetMapping("/ciudades/{id}")
    public ResponseEntity<Ciudad> consultarCiudad(@PathVariable("id") Long id){
        Ciudad ciudad = ciudadRepository.findOne(id);
        if(ciudad == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ciudad);
    }
    
    @CrossOrigin
    @PostMapping("/registrarciudad")
    public Ciudad registrarCiudad(@RequestBody Ciudad ciudad){
        return ciudadRepository.save(ciudad); 
    }
    
    @CrossOrigin
    @PostMapping("/actualizarpais")
    public Pais actualizarPais(@RequestBody Pais pais){
       Pais paisUpdate  = paisRepository.findOne(pais.getId());
       paisUpdate.setNombre(pais.getNombre());
       return paisRepository.save(paisUpdate);      
    }
    
    @Transactional
    @CrossOrigin
    @PostMapping("/eliminarpais")
    public void eliminarPais(@RequestBody Pais pais){      
       paisRepository.delete(pais.getId());
    }
    
    @CrossOrigin
    @PostMapping("/actualizardepartamento")
    public Departamento actualizarDepartamento (@RequestBody Departamento departamento){ 
        Departamento departamentoUpdate = departamentoRepository.findOne(departamento.getId());
        departamentoUpdate.setNombre(departamento.getNombre());
        return departamentoRepository.save(departamentoUpdate);  
                
    }
    
    @Transactional
    @CrossOrigin
    @PostMapping("/eliminardepartamento")
    public void eliminarDepartamento(@RequestBody Departamento departamento){      
       departamentoRepository.delete(departamento.getId());
    }
    
    @CrossOrigin
    @PostMapping("/actualizarciudad")
    public Ciudad actualizarCiudad (@RequestBody Ciudad ciudad){ 
        Ciudad ciudadUpdate = ciudadRepository.findOne(ciudad.getId());
        ciudadUpdate.setNombre(ciudad.getNombre());
        return ciudadRepository.save(ciudadUpdate);  
                
    }
    @Transactional
    @CrossOrigin
    @PostMapping("/eliminarciudad")
    public void eliminarCiudad(@RequestBody Ciudad ciudad){      
       ciudadRepository.delete(ciudad.getId());  
    }
}
