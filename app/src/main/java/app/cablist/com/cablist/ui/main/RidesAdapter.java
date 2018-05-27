package app.cablist.com.cablist.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import app.cablist.com.cablist.R;

/**
 * Project: CabList
 * Created by Gil on 5/25/2018.
 */
public class RidesAdapter extends RecyclerView.Adapter<RideDataViewHolder> {

    private final SortedList<Ride> mItems = new SortedList<>(Ride.class, new SortedListAdapterCallback<Ride>(this) {

        @Override
        public int compare(Ride o1, Ride o2) {
            if (o1.getMinutesAway() < o2.getMinutesAway()) {
                return -1;
            }

            if (o1.getMinutesAway() > o2.getMinutesAway()) {
                return 1;
            }

            return 0;
        }

        @Override
        public boolean areContentsTheSame(Ride oldItem, Ride newItem) {
            return oldItem.getId() == newItem.getId() && oldItem.getMinutesAway() == newItem.getMinutesAway();
        }

        @Override
        public boolean areItemsTheSame(Ride item1, Ride item2) {
            return false;
        }
    });

    private final LayoutInflater mInflater;

    public RidesAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RideDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RideDataViewHolder(mInflater.inflate(R.layout.adapter_item_ride_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RideDataViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(final List<Ride> rides) {
        mItems.beginBatchedUpdates();
        mItems.replaceAll(rides);
        mItems.endBatchedUpdates();
    }
}
