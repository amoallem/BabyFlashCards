package me.doost.babyflashcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doost.babyflashcards.R;

public class FruitCardsActivity extends CardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent callerIntent = getIntent();
        int fruitImages[] = {R.drawable.fruits_apple, R.drawable.fruits_orange, R.drawable.fruits_strawberry, R.drawable.fruits_carrot, R.drawable.fruits_mango};
        int fruitTexts[] = {R.string.apple, R.string.orange, R.string.strawberry, R.string.carrot, R.string.mango};

        ViewGroup viewFlipperAnimalCards = (ViewGroup) findViewById(R.id.viewFlipper_fruit_cards);

        for (int index = 0; index < fruitImages.length ; index++) {


            View flashCardLayout = getLayoutInflater().inflate(R.layout.flash_card, null);

            ImageView imageCard = (ImageView) flashCardLayout.findViewById(R.id.image_card);
            imageCard.setImageResource(fruitImages[index]);

            TextView imageText = (TextView) flashCardLayout.findViewById(R.id.image_text);
            imageText.setText(fruitTexts[index]);

            if (index == 0) {
                flashCardLayout.findViewById(R.id.arrow_prev).setVisibility(View.INVISIBLE);
            } else if (index == fruitImages.length - 1) {
                flashCardLayout.findViewById(R.id.arrow_next).setVisibility(View.INVISIBLE);
            }
            viewFlipperAnimalCards.addView(flashCardLayout);

        }

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
