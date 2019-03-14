package com.harrijefria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;
import com.harrijefria.belajar.R;

public class MainActivity extends AppCompatActivity {

    private Flashbar flashbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = findViewById(R.id.show);
        Button dismis = findViewById(R.id.dismiss);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flashbar == null) {
                    flashbar = enterExitAnimation();
                }
                flashbar.show();
            }
        });

        dismis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flashbar != null) {
                    flashbar.dismiss();
                    flashbar = null;
                }
            }
        });

    }

    private Flashbar progressAdvanced() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .message(
                        "You can customize the look-and-fell of the progress bar.")
                .backgroundColorRes(R.color.slate_black)
                .showIcon()
                .showProgress(Flashbar.ProgressPosition.RIGHT)
                .progressTintRes(R.color.colorAccent)
                .build();
    }

    private Flashbar gravityTop() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.TOP)
                .message(
                        "Flashbar is shown at the top. You can also have more than one line in "
                                + "the flashbar. The bar will dynamically adjust its size.")
                .build();
    }

    private Flashbar overlay() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.TOP)
                .title("Hello World!")
                .message("You can show a modal overlay to give a dim effect in the entire screen.")
                .backgroundColorRes(R.color.colorPrimaryDark)
                .showOverlay()
                .build();
    }

    private Flashbar overlayAdvanced() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.TOP)
                .title("Hello World!")
                .message("You can show a modal overlay to give a dim effect in the entire screen.")
                .backgroundColorRes(R.color.colorPrimaryDark)
                .showOverlay()
                .overlayColorRes(R.color.modal)
                .build();
    }

    private Flashbar enterExitAnimation() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.TOP)
                .title("Hello World!")
                .message("You can change the enter/exit animation of the flashbar.")
                .backgroundColorRes(R.color.colorAccent)
                .enterAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(550)
                        .alpha()
                        .overshoot())
                .exitAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(500)
                        .alpha()
                        .overshoot())
                .build();
    }
}
