package iteso.com.tarea2_examen;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.widget.ScrollView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {
    Button btn_s;
    Button btn_m;
    Button btn_l;
    Button btn_x;
    Button btn_cart;

    int whiteColorValue;
    int primaryColorValue;

    Boolean state_btn_s = false;
    Boolean state_btn_m = false;
    Boolean state_btn_l = false;
    Boolean state_btn_x = false;
    Boolean state_btn_cart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whiteColorValue = getResources().getColor(R.color.white);
        primaryColorValue = getResources().getColor(R.color.colorPrimary);

        btn_s = findViewById(R.id.button_small);
        btn_m = findViewById(R.id.button_medium);
        btn_l = findViewById(R.id.button_large);
        btn_x = findViewById(R.id.button_extraLarge);

        btn_cart = findViewById(R.id.activity_main_addToCart);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("state_btn_s", state_btn_s);
        outState.putBoolean("state_btn_m", state_btn_m);
        outState.putBoolean("state_btn_l", state_btn_l);
        outState.putBoolean("state_btn_x", state_btn_x);

        outState.putBoolean("state_btn_cart", state_btn_cart);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getBoolean("state_btn_s"))
            btn_s.callOnClick();
        else if(savedInstanceState.getBoolean("state_btn_m"))
            btn_m.callOnClick();
        else if(savedInstanceState.getBoolean("state_btn_l"))
            btn_l.callOnClick();
        else if(savedInstanceState.getBoolean("state_btn_x"))
            btn_x.callOnClick();
        else
            cleanButtons();

        if(savedInstanceState.getBoolean("state_btn_cart"))
            btn_cart.setText(getResources().getString(R.string.buttonText_added));
        else
            btn_cart.setText(getResources().getString(R.string.buttonText));

    }

    @Override
    public void onClick(View v) {
        if(v.getId() != R.id.activity_main_addToCart)
            cleanButtons();
        switch (v.getId()) {
            case (R.id.button_small):
                state_btn_s = true;
                btn_s.setBackground(getResources().getDrawable(R.drawable.my_button_selected));
                btn_s.setTextColor(whiteColorValue);
                break;
            case (R.id.button_medium):
                state_btn_m = true;
                btn_m.setBackground(getResources().getDrawable(R.drawable.my_button_selected));
                btn_m.setTextColor(whiteColorValue);
                break;
            case (R.id.button_large):
                state_btn_l = true;
                btn_l.setBackground(getResources().getDrawable(R.drawable.my_button_selected));
                btn_l.setTextColor(whiteColorValue);
                break;
            case (R.id.button_extraLarge):
                state_btn_x = true;
                btn_x.setBackground(getResources().getDrawable(R.drawable.my_button_selected));
                btn_x.setTextColor(whiteColorValue);
                break;
            case (R.id.activity_main_addToCart):
                state_btn_cart = true;
                if(btn_cart.getText() == getResources().getString(R.string.buttonText)) {
                    btn_cart.setText(getResources().getString(R.string.buttonText_added));
                    Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snackbarText), Snackbar.LENGTH_LONG)
                            .setAction(getResources().getString(R.string.undoLabel), new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    state_btn_cart = false;
                                    btn_cart.setText(getResources().getString(R.string.buttonText));
                                }
                            }).show();
                }
                else{
                    Snackbar.make(findViewById(android.R.id.content),
                            getResources().getString(R.string.snackbarText_added), Snackbar.LENGTH_LONG).show();
                }
                break;


        }
    }

    public void cleanButtons(){
        state_btn_s = false;
        state_btn_m = false;
        state_btn_l = false;
        state_btn_x = false;
        btn_s.setBackground(getResources().getDrawable(R.drawable.my_button));
        btn_s.setTextColor(primaryColorValue);
        btn_m.setBackground(getResources().getDrawable(R.drawable.my_button));
        btn_m.setTextColor(primaryColorValue);
        btn_l.setBackground(getResources().getDrawable(R.drawable.my_button));
        btn_l.setTextColor(primaryColorValue);
        btn_x.setBackground(getResources().getDrawable(R.drawable.my_button));
        btn_x.setTextColor(primaryColorValue);
    }

    public void favClick(View v){
        Toast.makeText(this, getResources().getText(R.string.toastText), Toast.LENGTH_LONG).show();
    }
}
