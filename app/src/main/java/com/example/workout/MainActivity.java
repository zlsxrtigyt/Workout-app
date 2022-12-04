package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tablayout = findViewById(R.id.taber);
        ViewPager viewpager = findViewById(R.id.viewpager);

        tablayout.setupWithViewPager(viewpager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new fragment_ruecken(), "Rücken");
        vpAdapter.addFragment(new fragment_beine(), "Beine");
        vpAdapter.addFragment(new fragment_arme(), "Arme");

        viewpager.setAdapter(vpAdapter);

    }
}