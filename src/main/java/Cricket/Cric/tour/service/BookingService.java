package Cricket.Cric.tour.service;

import Cricket.Cric.tour.BookingRepository;
import Cricket.Cric.tour.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    HashMap<String, Booking> bookingSlots = new HashMap<>();

    public Booking bookTimeSlots(Booking booking) throws Exception {

        Random random = new Random();
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);
        String id = String.format("%d%d", number1, number2);
        booking.setId(id);
        bookingSlots.put(id,booking);

        bookingRepository.createSchedule(booking);
        return booking;
    }

    public List<Booking> getBookingSlots() {

        if(bookingSlots.isEmpty()){
            List<Booking> bookings =  bookingRepository.queryBookings();
            for (Booking booking : bookings) {
                bookingSlots.put(booking.getId(), booking);
            }
        }
         return new ArrayList<>(bookingSlots.values());
    }

    public void deleteBooking(String bookingId) {
        bookingSlots.remove(bookingId);
    }

    public List<Booking> getPastBookingSlots() {
        return new ArrayList<>(bookingSlots.values());
    }
}
