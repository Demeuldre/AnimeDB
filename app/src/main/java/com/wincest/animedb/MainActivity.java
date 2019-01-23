package com.wincest.animedb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_menu);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Clicked Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_anime:
                        Toast.makeText(MainActivity.this, "Clicked Anime", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_manga:
                        Toast.makeText(MainActivity.this, "Clicked Manga", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

    }
}
