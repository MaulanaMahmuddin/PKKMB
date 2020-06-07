package com.example.pkkmb2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.example.pkkmb2020.adapter.ViewPagerAdapter;
import com.example.pkkmb2020.fragment.AbsenFragment;
import com.example.pkkmb2020.fragment.BeradaFragment;
import com.example.pkkmb2020.fragment.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   ViewPagerAdapter adapter;
   BottomNavigationView bottomNavigationView;
   private ViewPager viewPager;
   MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final TabLayout tabLayout = findViewById(R.id.Tl1);
//        ViewPager viewPager = findViewById(R.id.vp1);
//        adapter = new ViewPagerAdapter(getSupportFragmentManager());

//        Add Fragment Here

//        adapter.AddFragment(new BeradaFragment(),"beranda");
//        adapter.AddFragment(new AbsenFragment(),"absen");
//        adapter.AddFragment(new ProfilFragment(),"profil");
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.web);
//        tabLayout.getTabAt(1).setIcon(R.drawable.technology);
//        tabLayout.getTabAt(2).setIcon(R.drawable.signs);
//
//        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grayDark),PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grayDark),PorterDuff.Mode.SRC_IN);
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(getResources().getColor(R.color.grayDark), PorterDuff.Mode.SRC_IN);
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        viewPager = findViewById(R.id.vp1);
        bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.beranda:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.absen:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.profil:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               if (prevMenuItem != null) {
                   prevMenuItem.setChecked(false);
               }
               else
               {
                   bottomNavigationView.getMenu().getItem(0).setChecked(false);
               }
               Log.d("page",""+position);
               bottomNavigationView.getMenu().getItem(position).setChecked(true);
               prevMenuItem = bottomNavigationView.getMenu().getItem(position);
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
        setuoViewPager(viewPager);
    }

    private void setuoViewPager(ViewPager viewPager) {
        adapter  = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new BeradaFragment(),"");
        adapter.AddFragment(new AbsenFragment(),"");
        adapter.AddFragment(new ProfilFragment(),"");
        viewPager.setAdapter(adapter);
    }
}
