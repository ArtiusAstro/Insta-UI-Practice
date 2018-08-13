package com.astro.seven.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astro.seven.R;
import com.astro.seven.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView profilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        profilePhoto = (ImageView)view.findViewById(R.id.profile_photo);

        initImageLoader();
        setProfileImage();

        return view;
    }

    private void initImageLoader(){
        if (!ImageLoader.getInstance().isInited()) {
            UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
            ImageLoader.getInstance().init(universalImageLoader.getConfig());
        }
    }

    private void setProfileImage(){
        Log.d(TAG, "setProfileImage in settings: ");
        String imgURL = "avatarfiles.alphacoders.com/813/81302.jpg";
        UniversalImageLoader.setImage(imgURL, profilePhoto, null, "https://");

    }
}
