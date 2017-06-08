package me.doost.babyflashcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doost.babyflashcards.R;


public class AnimalCardsActivity extends CardsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent callerIntent = getIntent();
        int animalImages[] = {R.drawable.animals_cow, R.drawable.animals_horse, R.drawable.animals_rabbit, R.drawable.animals_cat, R.drawable.animals_dog};
        int animalTexts[] = {R.string.cow, R.string.horse, R.string.rabbit, R.string.cat, R.string.dog};

        ViewGroup viewFlipperAnimalCards = (ViewGroup) findViewById(R.id.viewFlipper_animal_cards);

        for (int index = 0; index < animalImages.length ; index++) {


            View flashCardLayout = getLayoutInflater().inflate(R.layout.flash_card, null);

            ImageView imageCard = (ImageView) flashCardLayout.findViewById(R.id.image_card);
            imageCard.setImageResource(animalImages[index]);

            TextView imageText = (TextView) flashCardLayout.findViewById(R.id.image_text);
            imageText.setText(animalTexts[index]);

            if (index == 0) {
                flashCardLayout.findViewById(R.id.arrow_prev).setVisibility(View.INVISIBLE);
            } else if (index == animalImages.length - 1) {
                flashCardLayout.findViewById(R.id.arrow_next).setVisibility(View.INVISIBLE);
            }
            viewFlipperAnimalCards.addView(flashCardLayout);

        }

    }

    @Override
    protected int getViewFlipperID() {
        return R.id.viewFlipper_animal_cards;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_animal_cards;
    }

}
