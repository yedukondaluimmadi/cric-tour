package Cricket.Cric.tour;

import Cricket.Cric.tour.model.Booking;
import com.azure.cosmos.*;
import com.azure.cosmos.implementation.RequestOptions;
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

    public int  deleteBookings(String bookingId) {

       // cosmosContainer.deleteItem("id", new PartitionKey("your_partition_key_value"))



        cosmosContainer.deleteItem(bookingId, new PartitionKey("id"), new CosmosItemRequestOptions());

       // cosmosContainer.getItem("itemIdToDelete", PartitionKey.NONE)
        //        .deleteItem();
       return  200;
    }

}
