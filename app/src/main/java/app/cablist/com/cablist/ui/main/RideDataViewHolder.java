package app.cablist.com.cablist.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.cablist.com.cablist.R;

/**
 * Project: CabList
 * Created by Gil on 5/25/2018.
 */
class RideDataViewHolder extends RecyclerView.ViewHolder {

    private final ImageView mImgIcon;
    private final TextView mTxtName;
    private final TextView mTxtMinutesAway;

    public RideDataViewHolder(View itemView) {
        super(itemView);
        mImgIcon = itemView.findViewById(R.id.item_ride_img_icon);
        mTxtName = itemView.findViewById(R.id.item_ride_txt_display_name);
        mTxtMinutesAway = itemView.findViewById(R.id.item_ride_txt_minutes_away);
    }

    public void bind(Ride ride) {
//        mImgIcon.setImageDrawable();
        mTxtName.setText(ride.getDisplayName());

        int minutesAway = ride.getMinutesAway();
        final Context context = itemView.getContext();
        if (minutesAway < 60) {
            mTxtMinutesAway.setText(context.getString(R.string.minutes_away, minutesAway));
        } else {
            int hoursAway = minutesAway / 60;
            int minutes = minutesAway - (hoursAway * 60);
            mTxtMinutesAway.setText(context.getString(R.string.hours_away, hoursAway, minutes));
        }
    }
}
