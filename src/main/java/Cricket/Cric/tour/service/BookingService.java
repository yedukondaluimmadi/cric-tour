package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final List<Booking> bookedSlots = new ArrayList<>();

    public List<Booking> getAllBookings() {
        return bookedSlots;
    }

    public void addBooking(Booking booking) {
        bookedSlots.add(booking);
    }
}