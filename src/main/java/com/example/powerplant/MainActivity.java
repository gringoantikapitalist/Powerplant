package com.example.powerplant;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, InterActive {
    private Toolbar myToolbar;
    private DrawerLayout drawer;
    private NavigationView nvDrawer;
    private workfragment fragment;
    private ActionBarDrawerToggle drawerToggle;
    //String wlinie= "22";

    //private View linie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_toolbar();

        fragment = (workfragment) getSupportFragmentManager().findFragmentById(R.id.fragmentwork);
        drawer = findViewById(R.id.drawerLayout);
        nvDrawer = findViewById(R.id.nav_view);
        nvDrawer.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, myToolbar,
                R.string.drawer_navigation_open, R.string.drawer_navigation_close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }
    String wlinie= "22";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.powerplant_menu, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navi_work:
                fragment = new workfragment();
                Bundle data = new Bundle();
                data.putString("linie", wlinie);
                fragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameView,  fragment).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void init_toolbar() {

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backact:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onLinieChange(int linie) {
        if (linie<29) {
            linie++;
            //chline.setText(""+linie);
            wlinie = "" + linie;
        }
        else{
             wlinie="22";
        }
        fragment = new workfragment();
        Bundle data = new Bundle();
        data.putString("linie", wlinie);
        fragment.setArguments(data);
            //fragment.wline=""+linie;
           // finish();

           getSupportFragmentManager().beginTransaction().replace(R.id.frameView, fragment).commit();
        
    }

    @Override
    public void onMhdChange() {
        fragment = new workfragment();
        Bundle data = new Bundle();
        data.putString("MHD", "330");
        data.putString("linie", wlinie);
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameView, fragment).commit();
    }

    @Override
    public void onFormatChange(String linie) {

    }


}
