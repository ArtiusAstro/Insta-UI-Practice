package com.astro.seven.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.astro.seven.R;
import com.astro.seven.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private Context mContext;

    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: started");

        viewPager = (ViewPager)findViewById(R.id.container);
        relativeLayout = (RelativeLayout)findViewById(R.id.relLayout1);

        setupStuff();
        setupFragments();
    }

    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment)); // fragment 0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment)); // framgent 1
    }

    private void setViewPager(int fragmentNumber){
        relativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: going to fragment number " + fragmentNumber);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setupStuff() {
        /*
         * "back to profile" button
         */
        ImageView backButton = (ImageView) findViewById(R.id.backArrow);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: going back to profile");
                Intent intent = new Intent(mContext, ProfileActivity.class);

                startActivity(intent);
            }
        });

        /*
         * List of options in settings
         */
        ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: going to fragment position " + position);
                setViewPager(position);
            }
        });
    }
}
