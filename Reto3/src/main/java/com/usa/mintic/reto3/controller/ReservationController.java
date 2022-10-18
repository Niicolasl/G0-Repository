package com.usa.mintic.reto3.controller;

;
import com.usa.mintic.reto3.model.Message;
import com.usa.mintic.reto3.model.Reservation;
import com.usa.mintic.reto3.model.personalizado.CountClient;
import com.usa.mintic.reto3.model.personalizado.StatusAmount;
import com.usa.mintic.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int reservationId){
        return reservationService.getReservation(reservationId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationService.delete(reservationId);
    }

    @GetMapping("/report-clients")
        public List<CountClient> getReservationReportClient(){
            return reservationService.getTopClients();
        }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return reservationService.getReservationStatusReport();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }

}


