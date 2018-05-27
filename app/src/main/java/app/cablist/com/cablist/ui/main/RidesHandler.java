package app.cablist.com.cablist.ui.main;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Project: CabList
 * Created by Gil on 5/25/2018.
 */
class RidesHandler extends Handler {

    private static final int MSG_REFRESH_TIMES = 1;
    private static final long LIST_REFRESH_INTERVAL = 5 * 1000;

    private final WeakReference<MainViewModel> mModelRef;

    public RidesHandler(MainViewModel mainViewModel, Looper looper) {
        super(looper);
        mModelRef = new WeakReference<>(mainViewModel);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        final MainViewModel mainViewModel = mModelRef.get();
        if (mainViewModel != null) {
            switch (msg.what) {
                case MSG_REFRESH_TIMES:
                    mainViewModel.refreshMutableList();
                    break;
            }
        }
    }

    public void postRefresh() {
        sendEmptyMessageDelayed(MSG_REFRESH_TIMES, LIST_REFRESH_INTERVAL);
    }
}
