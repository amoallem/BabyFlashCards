package com.example.azin.babyflashcards;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorCardsActivity extends CardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent callerIntent = getIntent();
        int colorImages[] = {Color.RED, Color.BLUE, Color.GREEN};
        int colorTexts[] = {R.string.red, R.string.blue, R.string.green};

        ViewGroup viewFlipperAnimalCards = (ViewGroup) findViewById(R.id.viewFlipper_color_cards);

        for (int index = 0; index < colorImages.length ; index++) {


            View flashCardLayout = getLayoutInflater().inflate(R.layout.flash_card, null);

            ImageView imageCard = (ImageView) flashCardLayout.findViewById(R.id.image_card);
            imageCard.setBackgroundColor(colorImages[index]);

            TextView imageText = (TextView) flashCardLayout.findViewById(R.id.image_text);
            imageText.setText(colorTexts[index]);

           if (index == 0) {
                flashCardLayout.findViewById(R.id.arrow_prev).setVisibility(View.INVISIBLE);
            } else if (index == colorImages.length - 1) {
                flashCardLayout.findViewById(R.id.arrow_next).setVisibility(View.INVISIBLE);
            }
            viewFlipperAnimalCards.addView(flashCardLayout);

        }

    }

    @Override
    protected int getViewFlipperID() {
        return R.id.viewFlipper_color_cards;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_color_cards;
    }
}
