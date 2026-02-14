package com.example.cake_shopping;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    Button uploadButton, submitButton, button2;
    ImageView screenshotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
           final int PICK_IMAGE = 1; // Request code for image picker

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
// Find views by their IDs
        uploadButton = findViewById(R.id.uploadButton);
        submitButton = findViewById(R.id.submitButton);
        screenshotImage = findViewById(R.id.upload_btn);
        button2 = findViewById(R.id.button2);

        // ✅ Keep the Submit button always enabled
        submitButton.setEnabled(true);

        // Handle upload button click
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open gallery to pick an image
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*"); // Correct MIME type for images
                startActivityForResult(intent, PICK_IMAGE); // Start activity for result
            }
        });

        // Handle submit button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ✅ Check if an image was uploaded
                if (screenshotImage.getDrawable() == null) {
                    Toast.makeText(MainActivity6.this, "Kindly upload payment screenshot", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity6.this, "Thank you for the payment!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Home button click
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    // This method is called when the user picks an image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the image was selected successfully
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null)
        {
            Uri imageUri = data.getData(); // Get image URI

            if (imageUri != null)
            {
                // Display the image in the ImageView
                screenshotImage.setImageURI(imageUri);
                screenshotImage.setVisibility(View.VISIBLE);
            }
        }
    }
}
