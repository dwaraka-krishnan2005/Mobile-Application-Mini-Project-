package com.example.cake_shopping;

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

public class MainActivity9 extends AppCompatActivity {

    EditText quan;
    Button btn;
    TextView bill_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main9);

        quan = findViewById(R.id.quan);
        btn = findViewById(R.id.btn);
        bill_txt = findViewById(R.id.bill_txt);

        // ✅ Get data from activity 8 using correct keys
        String selected_item = getIntent().getStringExtra("selected cake");
        int price = getIntent().getIntExtra("Price", 0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantitystr = quan.getText().toString().trim();

                if (quantitystr.isEmpty()) {
                    bill_txt.setText(" ⚠️ Please Enter the Quantity to generate bill");
                    return;
                }

                int quantity = Integer.parseInt(quantitystr);
                int final_price = price * quantity;

                bill_txt.setText("\uD83E\uDDFEThe Bill Generated\uD83D\uDE0A \n\n"
                        + "\uD83C\uDF82Cake: " + selected_item + "\n"
                        + "\uD83D\uDCB0Unit Price: ₹" + price + "\n"
                        + "\uD83D\uDD22Quantity: " + quantity + "\n"
                        + "-----------------------------\n"
                        + "\uD83D\uDCB8Final Bill: ₹" + final_price + "\n"
                        + "\uD83D\uDE4F Thank you for coming! \uD83C\uDF70");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
