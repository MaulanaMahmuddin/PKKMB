package com.example.pkkmb2020;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class IntroScreen extends Activity {
    ViewPager viewPager;
    LinearLayout dotsLayout;
    int[] layouts;
    Button btnext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

        btnext = (Button) findViewById(R.id.bt_next);
        viewPager =(ViewPager) findViewById(R.id.vp_intro);
        dotsLayout = (LinearLayout) findViewById(R.id.layout_dots);
        layouts = new int[]{R.layout.screen_intro1, R.layout.screen_intro2, R.layout.screen_intro3};
        addBottomDots(0);
        WelcomeViewAdater welcomeViewAdapter = new WelcomeViewAdater();
        viewPager.setAdapter(welcomeViewAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    launchLoginScreen();
                }
            }
        });
    }

    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[layouts.length];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.gray));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.white));
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchLoginScreen() {
        startActivity(new Intent(IntroScreen.this, login.class));
        finish();
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            if (position == layouts.length - 1) {
                btnext.setText("MULAI");
            } else {
                btnext.setText("LANJUTKAN");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

    private class WelcomeViewAdater extends PagerAdapter {
        private LayoutInflater layoutInflater;

        private WelcomeViewAdater() {
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {return layouts.length;}

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
