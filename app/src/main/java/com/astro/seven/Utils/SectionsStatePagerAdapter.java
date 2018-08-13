package com.astro.seven.Utils;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> fragments = new HashMap<>();
    private final HashMap<String, Integer> fragmentNumbers = new HashMap<>();
    private final HashMap<Integer, String> fragmentNames = new HashMap<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String fragmentName){
        fragmentList.add(fragment);
        fragments.put(fragment, fragmentList.size()-1);
        fragmentNames.put(fragmentList.size()-1, fragmentName);
    }

    /**
     * returns the fragment with the name @param
     * @param fragmentName
     * @return
     */
    public Integer getFragmentNumber(String fragmentName){
        if(fragmentNumbers.containsKey(fragmentName)){
            return fragmentNumbers.get(fragmentName);
        }
        else {
            return null;
        }
    }

    /**
     * returns the fragment with the name @param
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment){
        if(fragmentNumbers.containsKey(fragment)){
            return fragmentNumbers.get(fragment);
        }
        else {
            return null;
        }
    }

    /**
     * returns the fragment with the name @param
     * @param fragmentNumber
     * @return
     */
    public String getFragmentName(Integer fragmentNumber){
        if(fragmentNumbers.containsKey(fragmentNumber)){
            return fragmentNames.get(fragmentNumber);
        }
        else {
            return null;
        }
    }
}
