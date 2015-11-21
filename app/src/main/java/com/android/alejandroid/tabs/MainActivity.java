package com.android.alejandroid.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    /*Declarando las variables a usar*/
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  Iniciamos la variable 'toolbar' y buscamos su referencia mediante su id.
            Ademas, agregamos el soporte para utilizar las herramientas de la toolbar.
        */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*  Iniciamos la variable 'viewpager' y buscamos su referencia mediante su id.
            Ademas, agregamos un adaptador para utlizar la herramienta ViewPager
        */
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        final ViewPagerAdapter1 viewPagerAdapter1 = new ViewPagerAdapter1(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter1);

        /*  Inciamos las variables 'tabLayout' y buscamos su referencia mediante su id
            Agregamos la clase '.setTabGravity', con esto llenamos el ancho de la tab
        */
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_search){
            Toast.makeText(MainActivity.this, "Funciona", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.action_settings){
            Toast.makeText(MainActivity.this, "Funciona", Toast.LENGTH_SHORT).show();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}