package com.astro.seven.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.astro.seven.R;
import com.astro.seven.Utils.BottomNavViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class LikesActivity extends AppCompatActivity{
    private static final String TAG = "LikesActivity";
    private final int ACTIVITY_NUM = 3;
    private Context mContext = LikesActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started.");

        setUpBottomNavigationView();
    }

    /**
     * BottomNavView Setup
     */
    private void setUpBottomNavigationView(){
        Log.d(TAG, "setUpBottomNavigationView: setting uo BottomNavView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
