package app.cablist.com.cablist.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.HandlerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.cablist.com.cablist.R;

public class MainViewModel extends ViewModel {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private MutableLiveData<List<Ride>> mMutableRides;
    private final List<Ride> mRides = new ArrayList<>();
    private final RidesHandler mHandler;

    public MainViewModel() {
        HandlerThread handlerThread = new HandlerThread("time change thread");
        handlerThread.start();
         mHandler = new RidesHandler(this,handlerThread.getLooper());
    }

    public LiveData<List<Ride>> getRides(Context context) {

        if (mMutableRides == null) {

            mMutableRides = new MutableLiveData<>();
            String[] rideNames = context.getResources().getStringArray(R.array.ride_names);

            for (int i = 0; i < rideNames.length; i++) {
                mRides.add(new Ride(i, rideNames[i]));
            }
            refreshMutableList();
        }

        return mMutableRides;
    }

    void refreshMutableList() {
        for (Ride ride : mRides) {
            ride.setMinutesAway(RANDOM.nextInt(120));
        }
        mMutableRides.postValue(mRides);
        mHandler.postRefresh();
    }

}
