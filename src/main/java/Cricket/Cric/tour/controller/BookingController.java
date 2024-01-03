package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.Booking;
import Cricket.Cric.tour.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public void addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
    }
}