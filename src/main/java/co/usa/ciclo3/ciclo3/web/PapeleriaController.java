/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.service.PapeleriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.usa.ciclo3.ciclo3.model.Papeleria;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Papeleria")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PapeleriaController {
    @Autowired
    private PapeleriaService papeleriaService;
    
    @GetMapping("/all")
    public List<Papeleria> getPapelerias(){
        return papeleriaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Papeleria> getPapeleria(@PathVariable("id") int id){
        return papeleriaService.getPapeleria(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria save(@RequestBody Papeleria p){
        return papeleriaService.save(p);
    }
}
