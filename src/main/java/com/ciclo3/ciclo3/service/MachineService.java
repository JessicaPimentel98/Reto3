
package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Machine;
import com.ciclo3.ciclo3.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {
    
    @Autowired
    private MachineRepository machineRepository;
    
    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }
    
    public Machine save(Machine m){
        if (m.getId() == null){
            return machineRepository.save(m);
        }
        else{
            Optional<Machine> mauxiliar = machineRepository.getMachine(m.getId());
            if(mauxiliar.isEmpty()){
                return machineRepository.save(m);
            }else{
                return m;
            }
        }
    }
    
}
