package me.doost.babyflashcards;

import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

import com.doost.babyflashcards.R;

public abstract class CardsActivity extends BaseActivity {


    protected ViewFlipper viewFlipper;
    private float lastX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewFlipper  = (ViewFlipper) findViewById(getViewFlipperID());
    }

    protected abstract int getViewFlipperID();

    // Method to handle touch event like left to right swap and right to left swap
    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();

                // if left to right swipe on screen
                if (lastX < currentX) {
                 setViewFlipperSwipeLeftToRight();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                   viewFlipperSwipeRightToLeft();
                }
                break;
            }
        }
        return false;
    }

    public void arrowNext(View view){
        viewFlipperSwipeRightToLeft();
    }

    public void arrowPrev(View view){
        setViewFlipperSwipeLeftToRight();
    }

    private void viewFlipperSwipeRightToLeft(){
        if (viewFlipper.getDisplayedChild() == viewFlipper.getChildCount() - 1)
            return;
        // set the required Animation type to ViewFlipper
        // The Next screen will come in form Right and current Screen will go OUT from Left
        viewFlipper.setInAnimation(this, R.anim.in_from_right);
        viewFlipper.setOutAnimation(this, R.anim.out_to_left);
        viewFlipper.showNext();

    }

    private void  setViewFlipperSwipeLeftToRight(){

        // If no more View/Child to flip
        if (viewFlipper.getDisplayedChild() == 0)
            return;

        // set the required Animation type to ViewFlipper
        // The Next screen will come in form Left and current Screen will go OUT from Right
        viewFlipper.setInAnimation(this, R.anim.in_from_left);
        viewFlipper.setOutAnimation(this, R.anim.out_to_right);
        viewFlipper.showPrevious();

    }

}
