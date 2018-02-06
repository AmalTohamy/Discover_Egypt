package com.egypt.channel.discoveregypt;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    private List<Place> historicalList = new ArrayList<>();
    private List<Place> coastalList = new ArrayList<>();
    private List<Place> modernList = new ArrayList<>();
    private List<SpinnerItem> historicalSpinnerList = new ArrayList<>();
    private List<SpinnerItem> coastalSpinnerList = new ArrayList<>();
    private List<SpinnerItem> modernSpinnerList = new ArrayList<>();
    private Spinner spinner;
    private ImageView image;
    private TextView location;
    private TextView history;
    private TextView info;
    private Animation fadeIn;
    private Animation fadeOut;
    private boolean first = true;
    private View mHeaderView;
    private Toolbar mToolbarView;
    private ObservableScrollView mScrollView;
    private int mBaseTranslationY;
    private AnimationDrawable animation;
    private String activity;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        Intent i = getIntent();
        index = i.getIntExtra("index", 0);
        activity = i.getStringExtra("Activity");
        initialize();


    }

    private void initialize() {
        image = findViewById(R.id.historical_place_image);
        location = findViewById(R.id.historical_place_location);
        history = findViewById(R.id.historical_place_history);
        info = findViewById(R.id.historical_place_info);
        spinner = findViewById(R.id.spinner);


        if (activity.equals("Coastal")) {

            coastalList.add(new Place(new int[]{R.drawable.sharmelsheikh_card}, R.string.sharm_location, R.string.sharm_history, R.string.sharm_info));
            coastalList.add(new Place(new int[]{R.drawable.naama_bay_card}, R.string.naama_location, R.string.naama_history, R.string.naama_info));
            coastalList.add(new Place(new int[]{R.drawable.ras_mohammed_card}, R.string.ras_mohammed_location, R.string.ras_mohammed_history, R.string.ras_mohammed_info));
            coastalList.add(new Place(new int[]{R.drawable.hurghada_card}, R.string.hurghada_location, R.string.hurghada_history, R.string.hurghada_info));
            coastalList.add(new Place(new int[]{R.drawable.marsamatruh_card}, R.string.marsa_matruh_location, R.string.marsa_matruh_history, R.string.marsa_matruh_info));
            coastalList.add(new Place(new int[]{R.drawable.alexandria_card}, R.string.alexandria_location, R.string.alexandria_history, R.string.alexandria_info));


            coastalSpinnerList.add(new SpinnerItem(R.drawable.sharmelsheikh, R.string.sharm_name, R.string.sharm_short_location));
            coastalSpinnerList.add(new SpinnerItem(R.drawable.naama_bay, R.string.naama_name, R.string.naama_short_location));
            coastalSpinnerList.add(new SpinnerItem(R.drawable.ras_mohammed, R.string.ras_mohammed_name, R.string.ras_mohammed_short_location));
            coastalSpinnerList.add(new SpinnerItem(R.drawable.hurghada, R.string.hurghada_name, R.string.hurghada_short_location));
            coastalSpinnerList.add(new SpinnerItem(R.drawable.marsamatruh, R.string.marsa_matruh_name, R.string.marsa_matruh_short_location));
            coastalSpinnerList.add(new SpinnerItem(R.drawable.alexandria_card, R.string.alexandria_name, R.string.alexandria_short_location));

            PlaceAdapter coastalAdapter = new PlaceAdapter(SecondActivity.this, coastalSpinnerList);
            spinner.setAdapter(coastalAdapter);

        } else if (activity.equals("Historical")) {

            historicalList.add(new Place(new int[]{R.drawable.pyramid1_card,R.drawable.pyramid2_card,R.drawable.pyramid3_card,
                    R.drawable.pyramid5_card,R.drawable.pyramid_card,R.drawable.pyramids_card},
                    R.string.pyramid_location, R.string.pyramid_history, R.string.pyramid_info));
            historicalList.add(new Place(new int[]{R.drawable.sphinx_card}, R.string.great_sphinx_location, R.string.great_sphinx_history, R.string.great_sphinx_info));
            historicalList.add(new Place(new int[]{R.drawable.abu_simbel2_card,R.drawable.abu_simbel1_card}, R.string.abu_simbel_location, R.string.abu_simbel_history, R.string.abu_simbel_info));
            historicalList.add(new Place(new int[]{R.drawable.hatshepsut2_card,R.drawable.hatshepsut1_card,R.drawable.hatshepsut3_card}, R.string.temple_of_hatshepsut_location, R.string.temple_of_hatshepsut_history, R.string.temple_of_hatshepsut_info));
            historicalList.add(new Place(new int[]{R.drawable.luxor_temple1_card,R.drawable.luxor_temple2_card}, R.string.luxor_temple_location, R.string.luxor_temple_history, R.string.luxor_temple_info));
            historicalList.add(new Place(new int[]{R.drawable.ibn_tulun3_card,R.drawable.ibn_tulun1_card,R.drawable.ibn_tulun2_card}, R.string.mosque_of_ibn_tulun_location, R.string.mosque_of_ibn_tulun_history, R.string.mosque_of_ibn_tulun_info));
            historicalList.add(new Place(new int[]{R.drawable.azhar2_card,R.drawable.azhar1_card,R.drawable.azhar3_card}, R.string.mosque_of_al_azhar_location, R.string.mosque_of_al_azhar_history, R.string.mosque_of_al_azhar_info));
            historicalList.add(new Place(new int[]{R.drawable.al_hakim_bi_amrillah2_card,R.drawable.al_hakim_bi_amrillah1_card,R.drawable.al_hakim_bi_amrillah3_card}, R.string.mosque_of_al_Hakim_bi_amrillah_location, R.string.mosque_of_al_Hakim_bi_amrillah_history, R.string.mosque_of_al_Hakim_bi_amrillah_info));
            historicalList.add(new Place(new int[]{R.drawable.sakarra2_card,R.drawable.sakkara1_card,R.drawable.sakkara3_card}, R.string.pyramid_of_sakkara_location, R.string.pyramid_of_sakkara_history, R.string.pyramid_of_sakkara_info));
            historicalList.add(new Place(new int[]{R.drawable.botanical_island3_card,R.drawable.botanical_island1_card,R.drawable.botanical_island2_card}, R.string.botanical_gardens_location, R.string.botanical_gardens_history, R.string.botanical_gardens_info));

            historicalSpinnerList.add(new SpinnerItem(R.drawable.pyramid1, R.string.pyramid_name, R.string.pyramid_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.sphinx, R.string.great_sphinx_name, R.string.great_sphinx_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.abu_simbel2, R.string.abu_simbel_name, R.string.abu_simbel_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.hatshepsut2_card, R.string.temple_of_hatshepsut_name, R.string.temple_of_hatshepsut_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.luxor_temple1_card, R.string.luxor_temple_name, R.string.luxor_temple_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.ibn_tulun3_card, R.string.mosque_of_ibn_tulun_name, R.string.mosque_of_ibn_tulun_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.azhar2_card, R.string.mosque_of_al_azhar_name, R.string.mosque_of_al_azhar_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.al_hakim_bi_amrillah2, R.string.mosque_of_al_Hakim_bi_amrillah_name, R.string.mosque_of_al_Hakim_bi_amrillah_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.sakarra2, R.string.pyramid_of_sakkara_name, R.string.pyramid_of_sakkara_short_location));
            historicalSpinnerList.add(new SpinnerItem(R.drawable.botanical_island3, R.string.botanical_gardens_name, R.string.botanical_gardens_short_location));

            PlaceAdapter historyAdapter = new PlaceAdapter(SecondActivity.this, historicalSpinnerList);
            spinner.setAdapter(historyAdapter);

        } else if (activity.equals("Modern")) {

            modernList.add(new Place(new int[]{R.drawable.operahouse_card}, R.string.opera_location, R.string.opera_history, R.string.opera_info));
            modernList.add(new Place(new int[]{R.drawable.alexandria_library_card}, R.string.library_of_alexandria_location, R.string.library_of_alexandria_history, R.string.library_of_alexandria_info));
            modernList.add(new Place(new int[]{R.drawable.cairo_tower_card}, R.string.cairo_tower_location, R.string.cairo_tower_history, R.string.cairo_tower_info));
            modernList.add(new Place(new int[]{R.drawable.cairo_metro_card}, R.string.cairo_metro_location, R.string.cairo_metro_history, R.string.cairo_metro_info));

            modernSpinnerList.add(new SpinnerItem(R.drawable.operahouse, R.string.opera_name, R.string.opera_short_location));
            modernSpinnerList.add(new SpinnerItem(R.drawable.alexandria_library, R.string.library_of_alexandria_name, R.string.library_of_alexandria_short_location));
            modernSpinnerList.add(new SpinnerItem(R.drawable.cairo_tower, R.string.cairo_tower_name, R.string.cairo_tower_short_location));
            modernSpinnerList.add(new SpinnerItem(R.drawable.cairo_metro, R.string.cairo_metro_name, R.string.cairo_metro_short_location));

            PlaceAdapter modernAdapter = new PlaceAdapter(SecondActivity.this, modernSpinnerList);
            spinner.setAdapter(modernAdapter);

        }

        setSupportActionBar((findViewById(R.id.toolbar)));
//        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
//        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//        image.setFactory(() -> {
//            ImageView imageView = new ImageView(getApplicationContext());
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setLayoutParams(
//                    new ImageSwitcher.LayoutParams(
//                            LinearLayout.LayoutParams.MATCH_PARENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT));
//            return imageView;
//        });


        mHeaderView = findViewById(R.id.header);
        ViewCompat.setElevation(mHeaderView, getResources().getDimension(R.dimen.toolbar_elevation));
        mToolbarView = findViewById(R.id.toolbar);
        mScrollView = findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (animation!=null) {
                    animation.stop();
                    animation=null;
                }
                Place currentPlace = null;
                switch (activity) {
                    case "Coastal":
                        if (first) {
                            currentPlace = coastalList.get(index);
//                            image.setImageResource(currentPlace.getImageResource()[0]);
//                            image.setInAnimation(null);
//                            image.setOutAnimation(null);
                            first = false;
                            spinner.setSelection(index);

                        } else {
                            currentPlace = coastalList.get(position);
//                            image.setImageResource(currentPlace.getImageResource()[0]);
//                            if (index != position) {
//                                image.setInAnimation(fadeIn);
//                                image.setOutAnimation(fadeOut);
//                            }
                        }
                        break;

                    case "Historical":
                        if (first) {
                            currentPlace = historicalList.get(index);
//                            image.setImageResource(currentPlace.getImageResource()[0]);
//                            image.setInAnimation(null);
//                            image.setOutAnimation(null);
                            first = false;
                            spinner.setSelection(index);
                        } else {
                            currentPlace = historicalList.get(position);
//                            image.setImageResource(currentPlace.getImageResource()[0]);
//                            if (index != position) {
//                                image.setInAnimation(fadeIn);
//                                image.setOutAnimation(fadeOut);
//                            }
                        }
                        break;
                    case "Modern":
                       if (first) {
                            currentPlace = modernList.get(index);
//                            image.setImageResource(currentPlace.getImageResource()[0]);
//                            image.setInAnimation(null);
//                            image.setOutAnimation(null);
                            first = false;
                            spinner.setSelection(index);
                        } else {
                            currentPlace = modernList.get(position);
//                            if (index != position) {
//                                image.setImageResource(currentPlace.getImageResource()[0]);
//                                image.setInAnimation(fadeIn);
//                                image.setOutAnimation(fadeOut);
                            }
//                        }
                }


//                image.setImageResource(currentPlace.getImageResource()[0]);
                location.setText(currentPlace.getLocation());
                history.setText(currentPlace.getHistory());
                info.setText(currentPlace.getInfo());


                animation = new AnimationDrawable();
                for (int i:currentPlace.getImageResource()) {
                    Bitmap drawable = decodeSampledBitmapFromResource(getResources(),i, 640, 280);
                    BitmapDrawable bitmapDrawable =new BitmapDrawable(drawable);

                    animation.addFrame(bitmapDrawable,3000);
                }
                animation.setExitFadeDuration(700);
                animation.setEnterFadeDuration(700);
                animation.setOneShot(false);

                image.setImageDrawable(animation);

                // start the animation!
                animation.start();



                if (view != null) {
                    View blueLine = view.findViewById(R.id.view);
                    blueLine.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (dragging) {
            int toolbarHeight = mToolbarView.getHeight();
            if (firstScroll) {
                float currentHeaderTranslationY = ViewHelper.getTranslationY(mHeaderView);
                if (-toolbarHeight < currentHeaderTranslationY) {
                    mBaseTranslationY = scrollY;
                }
            }
            float headerTranslationY = ScrollUtils.getFloat(-(scrollY - mBaseTranslationY), -toolbarHeight, 0);
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewHelper.setTranslationY(mHeaderView, headerTranslationY);
        }
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        mBaseTranslationY = 0;

        if (scrollState == ScrollState.DOWN) {
            showToolbar();
        } else if (scrollState == ScrollState.UP) {
            int toolbarHeight = mToolbarView.getHeight();
            int scrollY = mScrollView.getCurrentScrollY();
            if (toolbarHeight <= scrollY) {
                hideToolbar();
            } else {
                showToolbar();
            }
        } else {
            // Even if onScrollChanged occurs without scrollY changing, toolbar should be adjusted
            if (!toolbarIsShown() && !toolbarIsHidden()) {
                // Toolbar is moving but doesn't know which to move:
                // you can change this to hideToolbar()
                showToolbar();
            }
        }
    }

    private boolean toolbarIsShown() {
        return ViewHelper.getTranslationY(mHeaderView) == 0;
    }

    private boolean toolbarIsHidden() {
        return ViewHelper.getTranslationY(mHeaderView) == -mToolbarView.getHeight();
    }

    private void showToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        if (headerTranslationY != 0) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(0).setDuration(200).start();
        }
    }

    private void hideToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        int toolbarHeight = mToolbarView.getHeight();
        if (headerTranslationY != -toolbarHeight) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(-toolbarHeight).setDuration(200).start();
        }
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}



