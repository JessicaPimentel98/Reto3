
package com.ciclo3.ciclo3.repository;

import com.ciclo3.ciclo3.model.Machine;
import com.ciclo3.ciclo3.repository.crud.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    
    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }
    
    public Machine save(Machine m){
        return machineCrudRepository.save(m);
    }
    
}
