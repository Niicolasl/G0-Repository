package com.usa.mintic.reto3.repository;


import com.usa.mintic.reto3.model.Client;
import com.usa.mintic.reto3.model.Reservation;
import com.usa.mintic.reto3.model.personalizado.CountClient;
import com.usa.mintic.reto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }
    public List<CountClient> getTopClients(){
        List<CountClient> resultado = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            resultado.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return resultado;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
    return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
