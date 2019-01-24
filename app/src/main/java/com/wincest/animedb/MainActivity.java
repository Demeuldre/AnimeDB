package com.wincest.animedb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.content.Intent;

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

                        Intent Home_Screen = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(Home_Screen);

                        break;

                    case R.id.nav_anime:

                        Intent Series_Screen = new Intent(MainActivity.this, Series_List.class);
                        startActivity(Series_Screen);

                        break;

                    case R.id.nav_manga:

                        Intent Book_Screen = new Intent(MainActivity.this, BookList.class);
                        startActivity(Book_Screen);

                        break;
                }

                return false;
            }
        });

    }
}
