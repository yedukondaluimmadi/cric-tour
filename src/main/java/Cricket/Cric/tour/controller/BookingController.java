package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.Booking;
import Cricket.Cric.tour.model.CricTourRegisterModel;
import Cricket.Cric.tour.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public Booking bookTimeSlots(@RequestBody Booking booking) throws Exception {
        return bookingService.bookTimeSlots(booking);
    }
    @GetMapping("/bookings")
    public List<Booking> getBookedTimeSlots() {
        return bookingService.getBookingSlots();
    }
    @DeleteMapping("/bookings/{bookingId}")
    public void deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/pastBookings")
    public List<Booking> getPastBookedTimeSlots() {
        return bookingService.getPastBookingSlots();
    }
}
