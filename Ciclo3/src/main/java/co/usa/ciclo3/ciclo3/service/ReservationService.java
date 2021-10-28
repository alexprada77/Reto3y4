package co.usa.ciclo3.ciclo3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public List<Reservation> getAll(){
		return reservationRepository.findAll();
	}
	public Optional<Reservation> getReservation(int id){
		return reservationRepository.findById(id);
	}
	public Reservation updateReservation(Reservation reservation) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaIni;
        Date fechaFin;
		if(reservation.getIdReservation()!=null) {
			Optional<Reservation> reserva= getReservation(reservation.getIdReservation());
			try {
				fechaIni = sdf.parse(reservation.getStartDate());
			} catch (ParseException e) {
				fechaIni=null;
			}
			try {
				fechaFin = sdf.parse(reservation.getDevolutionDate());
			} catch (ParseException e) {
				fechaFin=null;
			}
			if(reserva.isPresent() && !fechaFin.before(fechaIni)) {
				if(reservation.getStartDate()!=null) {
					reserva.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate()!=null) {
					reserva.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if(reservation.getStatus()!=null) {
					reserva.get().setStatus(reservation.getStatus());
				}
				return saveReservation(reserva.get());
			} else if(fechaFin.before(fechaIni)) {
				System.out.println("Fecha Devolucion no puede ser inferior a fecha de inicio");
			}
		}
		return reservation;
	}
	
	public boolean deleteReservation(int id) {
		Optional<Reservation> reserva= getReservation(id);
		if(reserva.isPresent()) {
			reservationRepository.delete(reserva.get());
			return true;
		}
		return false;
	}
}
