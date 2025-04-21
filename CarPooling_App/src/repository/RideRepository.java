package repository;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import model.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long>{
	List<Ride> findByStartLocationAndDestinationAndDepartureTimeBetween(
            String startLocation, String destination, LocalDateTime from, LocalDateTime to);
}
