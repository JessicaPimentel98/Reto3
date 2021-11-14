
package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Reservation;
import com.ciclo3.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation c){
        if (c.getIdReservation()== null){
            return reservationRepository.save(c);
        }
        else{
            Optional<Reservation> mauxiliar = reservationRepository.getReservation(c.getIdReservation());
            if(mauxiliar.isEmpty()){
                return reservationRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
