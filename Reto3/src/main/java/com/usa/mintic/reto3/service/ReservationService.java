package com.usa.mintic.reto3.service;


import com.usa.mintic.reto3.model.Reservation;
import com.usa.mintic.reto3.model.personalizado.CountClient;
import com.usa.mintic.reto3.model.personalizado.StatusAmount;
import com.usa.mintic.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public Reservation save(Reservation r){
        if (r.getIdReservation()!= null){
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isPresent()){
                return r;
            }else{
                return reservationRepository.save(r);
            }
        }else{
            return reservationRepository.save(r);
        }
    }

    public Reservation update(Reservation r){
        if (r.getIdReservation()!=null){
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isPresent()){
                if (r.getStartDate()!=null){
                    e.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(r.getDevolutionDate());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservation> r = getReservation(id);
        if (r.isPresent()){
            flag=true;
            reservationRepository.delete(r.get());
        }
        return flag;
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public StatusAmount getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String dateA,String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }
}
