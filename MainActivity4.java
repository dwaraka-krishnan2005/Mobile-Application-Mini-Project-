
package com.example.cake_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    TextView billText, bill_txt;
    EditText q_etxt;
    Button bt,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        billText = findViewById(R.id.billText);
        q_etxt = findViewById(R.id.quan);
        bill_txt = findViewById(R.id.bill_txt);
        bt = findViewById(R.id.btn);
        bt2 = findViewById(R.id.bt2);

        // Get data from previous activity
        String cake = getIntent().getStringExtra("cake");
        int price = getIntent().getIntExtra("price", 0);
        int offer = getIntent().getIntExtra("offer", 0);

        // Initial info display
        billText.setText("Price of the Cake:\n\nCake: " + cake +
                "\nOriginal Price: ₹" + price +
                "\nOffer Discount: ₹" + offer);

        // Calculate bill on button click
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityStr = q_etxt.getText().toString().trim();

                if (quantityStr.isEmpty()) {
                    bill_txt.setText(" ⚠\uFE0FPlease Enter the Quantity to generate bill");
                    return;
                }

                int quantity = Integer.parseInt(quantityStr);
                int finalUnitPrice = price - offer;
                int total = finalUnitPrice * quantity;

                bill_txt.setText("\uD83E\uDDFEThe Bill Generated\uD83D\uDE0A \n\n"
                        + "\uD83C\uDF82Cake: " + cake + "\n"
                        + "\uD83D\uDCB0Unit Price: ₹" + price + "\n"
                        + "\uD83D\uDCB8Offer: ₹" + offer + "\n"
                        + "\uD83D\uDD22Quantity: " + quantity + "\n"
                        + "-----------------------------\n"
                        + "Total Amount: ₹" + total + "\n\n"
                        + "\uD83D\uDE4F Thank you for coming! \uD83C\uDF70");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this,MainActivity5.class);
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
