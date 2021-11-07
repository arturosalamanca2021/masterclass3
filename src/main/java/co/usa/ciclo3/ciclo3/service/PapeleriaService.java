/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.repository.PapeleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Papeleria;
import java.util.List;
import java.util.Optional;

@Service
public class PapeleriaService {
    
    @Autowired
    private PapeleriaRepository papeleriaRepository;
    
    public List<Papeleria> getAll(){
        return papeleriaRepository.getAll();
    }
    
    public Optional<Papeleria> getPapeleria(int id){
        return papeleriaRepository.getPapeleria(id);
    }
    
    public Papeleria save(Papeleria p){
        if(p.getId() == null){
            return papeleriaRepository.save(p);
        }else{
            Optional<Papeleria> paux = papeleriaRepository.getPapeleria(p.getId());
            if(paux.isEmpty()){
                return papeleriaRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
