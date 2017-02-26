package com.example.azin.babyflashcards;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    ImageButton buttonAnimals, buttonColors, buttonFruits;
    MediaPlayer soundAnimals, soundColors;
    //EditText userName;
    private  SharedPreferences  preferences;
    private  SharedPreferences.Editor  editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonAnimals = (ImageButton) findViewById(R.id.buttonAnimals);
        buttonAnimals.setOnClickListener(this);

        buttonColors = (ImageButton) findViewById(R.id.buttonColors);
        buttonColors.setOnClickListener(this);

        buttonFruits = (ImageButton) findViewById(R.id.buttonFruits);
        buttonFruits.setOnClickListener(this);

        soundAnimals = MediaPlayer.create(this, R.raw.sound_animal);
        //userName = (EditText) findViewById(R.id.editTextName);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


        //if(preferences.contains(PersistedPreferences.SELECTED_CHILD_NAME)){
        //    userName.setText(preferences.getString(PersistedPreferences.SELECTED_CHILD_NAME, "Enter your child's name "));
        //}

       /* userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString(PersistedPreferences.SELECTED_CHILD_NAME, userName.getText().toString());
                editor.commit();
            }
        });*/






    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }


    @Override
    public void onClick(View v) {

       // String category = "";
        Intent goToCards = new Intent();

        if(v.equals(buttonAnimals)){
            Toast.makeText(getApplicationContext(), "Anilams !! Good choice madam", Toast.LENGTH_SHORT).show();
            //soundAnimals.start();
       //    category = "animals";
            goToCards.setClass(this, AnimalCardsActivity.class);


        }else if(v.equals(buttonColors)){
            Toast.makeText(getApplicationContext(), "Colors !! Good choice madam", Toast.LENGTH_SHORT).show();
         //   category="colors";
            goToCards.setClass(this, ColorCardsActivity.class);

        }else if(v.equals(buttonFruits)){
            Toast.makeText(getApplicationContext(), "Fruits !! Good Choice madam", Toast.LENGTH_SHORT).show();
         //   category = "fruits";
            goToCards.setClass(this, FruitCardsActivity.class);

        }

       // goToCards.putExtra("category", category);
        startActivity(goToCards);

    }


}
