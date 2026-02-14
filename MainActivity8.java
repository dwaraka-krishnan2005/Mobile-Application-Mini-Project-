package com.example.cake_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {

    Button btn;
    RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);
        btn = findViewById(R.id.btn);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String selected_item = "";
                int price = 0;
                if(rb1.isChecked())
                {
                   selected_item = "Sugar biscooti";
                   price = 780;
                }
                else if (rb2.isChecked())
                {
                  selected_item = "Oreo Choclate Cake";
                  price = 1100;
                }
                else if(rb3.isChecked())
                {
                    selected_item="Mango Mithai";
                    price = 1200;
                }
                if (selected_item.isEmpty())
                {
                    Toast.makeText(MainActivity8.this,"Please select the item",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(MainActivity8.this, MainActivity9.class);
                i.putExtra("Selected cake:", selected_item);
                i.putExtra("Price", price);
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
