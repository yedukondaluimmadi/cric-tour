package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {

    HashMap<String, Booking> bookingSlots = new HashMap<>();

    HashMap<String, Booking> pastBookingSlots = new HashMap<>();

    public Booking bookTimeSlots(Booking booking) {

        Random random = new Random();
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);
        String id = String.format("%d%d", number1, number2);
        booking.setId(id);
        bookingSlots.put(id,booking);
        pastBookingSlots.put(id,booking);
        return booking;
    }

    public List<Booking> getBookingSlots() {
        return new ArrayList<>(bookingSlots.values());
    }

    public void deleteBooking(String bookingId) {
        bookingSlots.remove(bookingId);
    }

    public List<Booking> getPastBookingSlots() {
        return new ArrayList<>(pastBookingSlots.values());
    }
}
