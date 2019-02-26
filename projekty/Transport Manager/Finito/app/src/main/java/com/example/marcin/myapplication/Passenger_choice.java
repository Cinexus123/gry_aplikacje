package com.example.marcin.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class Passenger_choice extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_choice);

        mToolbar = (Toolbar)findViewById(R.id.new_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        NavigationView navigationView = findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.wyprawa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Pasek5()).commit();
                break;
            case R.id.wyprawa1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Pasek2()).commit();
                break;
            case R.id.new_travel:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Pasek1()).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Pasek4()).commit();
                break;
            case R.id.logout:
                openActivity50();
                Toast.makeText(Passenger_choice.this,"Wylogowano",Toast.LENGTH_SHORT).show();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openActivity50() {
        Intent intent = new Intent(Passenger_choice.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToogle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
