package Cricket.Cric.tour;

import Cricket.Cric.tour.model.Booking;
import com.azure.cosmos.*;
import com.azure.cosmos.models.*;
import com.azure.cosmos.util.CosmosPagedIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private final CosmosContainer cosmosContainer;

    @Autowired
    public BookingRepository(CosmosDatabase cosmosDatabase) {
        this.cosmosContainer = cosmosDatabase.getContainer("booking");
    }

    public Booking createSchedule(Booking booking) throws Exception {
        CosmosItemResponse<Booking> item = cosmosContainer.createItem(booking, new PartitionKey(booking.getId()), new CosmosItemRequestOptions());
       return item.getItem();
    }


    public List<Booking> queryBookings() {

        CosmosQueryRequestOptions queryOptions = new CosmosQueryRequestOptions();
        queryOptions.setQueryMetricsEnabled(true);

        CosmosPagedIterable<Booking> bookings = cosmosContainer.queryItems(
                "SELECT * FROM c", queryOptions, Booking.class);

        List<Booking> bookingsList = new ArrayList<>();
        for (Booking booking : bookings) {
            bookingsList.add(booking);
        }
        return bookingsList;
    }
}
