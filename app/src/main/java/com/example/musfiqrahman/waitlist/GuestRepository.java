package com.example.musfiqrahman.waitlist;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by t00053669 on 1/25/2018.
 */

public class GuestRepository {

    private GuestDao guestDao;

    private LiveData<List<GuestInfo>> mAllGuests;

}
