package com.astro.seven.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.astro.seven.Home.HomeActivity;
import com.astro.seven.Likes.LikesActivity;
import com.astro.seven.Profile.ProfileActivity;
import com.astro.seven.R;
import com.astro.seven.Search.SearchActivity;
import com.astro.seven.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavViewHelper {
    private static final String TAG = "BottomNavViewHelper";

    public static void setupBottomNavView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavView: Setting up BottomNavView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setIconVisibility(true);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent intent0 = new Intent(context, HomeActivity.class);
                        context.startActivity(intent0);
                        break; //test

                    case R.id.ic_search:
                        Intent intent1 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_circle:
                        Intent intent2 = new Intent(context, ShareActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_alert:
                        Intent intent3 = new Intent(context, LikesActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_profile:
                        Intent intent4 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }
}
