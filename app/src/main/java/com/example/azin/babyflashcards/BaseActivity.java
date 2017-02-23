package com.example.azin.babyflashcards;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public abstract class BaseActivity extends AppCompatActivity {


    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Resources resources = this.getResources();
        getSupportActionBar().setTitle(resources.getString(R.string.app_name));
    }

    protected abstract int getLayoutResource();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.home:
                //handle the home button onClick event here.
                finish();
                return true;
            case R.id.sub_menu_english:
                LocaleHelper.setLocale(this, "en_CA");

                this.recreate();
                return true;
            case R.id.sub_menu_farsi:
                LocaleHelper.setLocale(this, "fa");
                this.recreate();
             //   Resources resources = this.getResources();
             //   String title = resources.getString(R.string.app_name);
              //  setTitle(title);
                return true;


             //   return true
        }

        return super.onOptionsItemSelected(item);
    }


   @Override
   protected void attachBaseContext(Context newBase) {

       super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));

  }


}
