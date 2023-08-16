package com.hfad.thestarbuckcoffe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetailsActivity extends AppCompatActivity {
    public static String Type = "type", Position = "position";
    private int pos;
    private FloatingActionButton floatingActionButton;
    private EditText quanityText, noteText;
    private FoodAndDrink foodAndDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar_id);
        ImageView imageView = findViewById(R.id.image_id);
        TextView textView = findViewById(R.id.text_view_description_id);
        floatingActionButton = findViewById(R.id.fab_id);
        quanityText = findViewById(R.id.quanity_id);
        noteText = findViewById(R.id.note_id);
        if(getIntent().getStringExtra(Type).equals("Food"))
        {
            foodAndDrink = Food.foods[getIntent().getIntExtra(Position, 0)];
            imageView.setImageResource(foodAndDrink.getIdImage());
            textView.setText(foodAndDrink.getDescription());
            toolbar.setTitle(foodAndDrink.getName());
        }
        else
        {
            foodAndDrink = Drink.drinks[getIntent().getIntExtra(Position, 0)];
            imageView.setImageResource(foodAndDrink.getIdImage());
            textView.setText(foodAndDrink.getDescription());
            toolbar.setTitle(foodAndDrink.getName());
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClickAdd(View view)
    {
        if(quanityText.getText().equals(null))
        {
            quanityText.setError("It must not blank!");
        }
        else {
            int quanity = 0;
            boolean check = true;
            try {
                quanity = Integer.parseInt(String.valueOf(quanityText.getText()));
            } catch (Exception e) {
                quanityText.setError("It must be a number!");
                check = false;
            }
            if (quanity != 0) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator_id), "You have just ordered!", Snackbar.LENGTH_SHORT);
                floatingActionButton.setImageResource(R.drawable.baseline_done_24);
                Drawable snackbarBackground = ContextCompat.getDrawable(DetailsActivity.this, R.drawable.snackbar_bg_custom);
                snackbar.getView().setBackground(snackbarBackground);
                snackbar.setActionTextColor(Color.WHITE);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DetailsActivity.this, "You have undo your order!", Toast.LENGTH_SHORT).show();
                        floatingActionButton.setImageResource(R.drawable.baseline_add_24);
                    }
                });
                snackbar.show();
            } else if(check)
                quanityText.setError("It must be different from 0!");
        }
    }
}