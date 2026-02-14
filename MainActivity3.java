package com.example.cake_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
        Button bt;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);
        bt = findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String selectedCake = "";
                int price = 0;
                int offer = 0;

                if (rb1.isChecked()) {
                    selectedCake = "Truffle cake";
                    price = 1000;
                    offer = 80;
                } else if (rb2.isChecked()) {
                    selectedCake = "Butterscotch Choclate Cake";
                    price = 4500;
                    offer = 50;
                } else if (rb3.isChecked()) {
                    selectedCake = "German Cake";
                    price = 4500;
                    offer = 70;
                } else if (rb4.isChecked()) {
                    selectedCake = "Lava Truffle Cake";
                    price = 3550;
                    offer = 25;
                } else if (rb5.isChecked())
                {
                    selectedCake = "Belgium Choclate Cake";
                    price = 7800;
                    offer = 59;
                } else if (rb6.isChecked())
                {
                    selectedCake = "Black Truffle";
                    price = 600;
                    offer = 58;
                }

                if (selectedCake.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Please select a cake!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putExtra("cake", selectedCake);
                i.putExtra("price", price);
                i.putExtra("offer",offer);
                startActivity(i);
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
