package app.cablist.com.cablist.ui.main;

/**
 * Project: CabList
 * Created by Gil on 5/25/2018.
 */
class Ride {

    private final int mId;
    private final String mDisplayName;
    private int mMinutesAway;

    public Ride(int id, String name) {
        mId = id;
        mDisplayName = name;
    }

    public int getMinutesAway() {
        return mMinutesAway;
    }

    public int getId() {
        return mId;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setMinutesAway(int minutesAway) {
        mMinutesAway = minutesAway;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "mId=" + mId +
                ", mDisplayName='" + mDisplayName + '\'' +
                ", mMinutesAway=" + mMinutesAway +
                '}';
    }
}
