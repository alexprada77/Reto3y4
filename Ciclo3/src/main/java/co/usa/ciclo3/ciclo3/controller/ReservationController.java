package co.usa.ciclo3.ciclo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) 
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/all")
	public List<Reservation> getReservations() {
		return reservationService.getAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation insertReservation(@RequestBody Reservation reservation) {
		try {
			reservation.setStatus("created");
			return reservationService.saveReservation(reservation);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{idReservation}")
	public Optional<Reservation> getReservation(@PathVariable("idReservation") int reservationId) {
		return reservationService.getReservation(reservationId);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation updateReservation(@RequestBody Reservation reservation) {
		try {
			return reservationService.updateReservation(reservation);
		} catch (Exception e) {
			return null;
		}
	}
	@DeleteMapping("/{idReservation}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteReservation(@PathVariable("idReservation") int reservationId) {
		return reservationService.deleteReservation(reservationId);
		
	}
	
}
