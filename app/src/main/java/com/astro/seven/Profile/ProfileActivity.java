package com.astro.seven.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.astro.seven.R;
import com.astro.seven.Utils.BottomNavViewHelper;
import com.astro.seven.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ProfileActivity extends AppCompatActivity{
    private static final String TAG = "ProfileActivity";
    private final int ACTIVITY_NUM = 4;
    private Context mContext = ProfileActivity.this;

    private ImageView profilePhoto;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");

        profilePhoto = (ImageView)findViewById(R.id.profile_image);
        progressBar = (ProgressBar)findViewById(R.id.profileprogressBar);
        progressBar.setVisibility(View.GONE);

        setUpBottomNavigationView();
        setup();

        initImageLoader();
        setProfileImage();
    }

    private void initImageLoader(){
        if (!ImageLoader.getInstance().isInited()) {
            UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
            ImageLoader.getInstance().init(universalImageLoader.getConfig());
        }
    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage in profile: ");
        String imgURL = "avatarfiles.alphacoders.com/813/81302.jpg";
        UniversalImageLoader.setImage(imgURL, profilePhoto, null, "https://");

    }

    private void setup() {
        /*
         * Menu to settings
         */

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);

        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: going to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);

                startActivity(intent);
            }
        });
    }

    /**
     * BottomNavView Setup
     */
    private void setUpBottomNavigationView(){
        Log.d(TAG, "setUpBottomNavigationView: setting up BottomNavView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
