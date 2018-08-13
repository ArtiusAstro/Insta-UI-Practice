package com.astro.seven.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.astro.seven.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.ic_display_name;
    private Context mContext;

    public UniversalImageLoader(Context context) {
        mContext = context;
    }

    public ImageLoaderConfiguration getConfig(){

        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheOnDisk(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
		        .displayer(new FadeInBitmapDisplayer(300))
                .build();

       ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(mContext)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();

       return imageLoaderConfiguration;
    }

    /**
     * Method sets images that are static. It can't be used if the images are being changed in a Fragment/Activity or if
     * they're being used in a grid or list
     * @param imgURL
     * @param image
     * @param progressBar
     * @param append
     */
    public static void setImage(String imgURL, ImageView image, final ProgressBar progressBar, String append){
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(append + imgURL, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (progressBar!=null)
                    progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (progressBar!=null)
                    progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (progressBar!=null)
                    progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (progressBar!=null)
                    progressBar.setVisibility(View.GONE);
            }
        });
    }
}
