package com.leegyungjun.boostcourse_android;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MoviePagerActivity extends AppCompatActivity implements FragmentCallback, NavigationView.OnNavigationItemSelectedListener {
    private final static String TAG = "MoviePagerActivity";
    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_pager);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("영화 목록");
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void goMovieDetail(int index) {
        Fragment curFragment = null;
        switch (index) {
            case 1: {
                curFragment = new DetailFragment();
            }
            case 2: { }
            case 3: { }
            case 4: { }
            case 5: { }
            case 6: { }
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, curFragment).commit();
        toolbar.setTitle("영화 상세");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            drawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment curFragment = null;
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_list:
                toolbar.setTitle("영화 목록");
                curFragment = new ListFragment();
                break;
            case R.id.nav_review:
                toolbar.setTitle("영화 API");
                curFragment = new ReviewFragment();
                break;
            case R.id.nav_book:
                toolbar.setTitle("예매하기");
                curFragment = new BookFragment();
                break;
            case R.id.nav_settings:
                toolbar.setTitle("사용자 설정");
                curFragment = new SettingsFragment();
                break;
        }
        assert curFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


}
