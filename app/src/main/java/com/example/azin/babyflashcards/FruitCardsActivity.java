package com.example.azin.babyflashcards;

import android.content.Intent;
import android.os.Bundle;

public class FruitCardsActivity extends CardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent callerIntent = getIntent();
    }

    @Override
    protected int getViewFlipperID() {
        return R.id.viewFlipper_fruit_cards;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_fruit_cards;
    }
}
