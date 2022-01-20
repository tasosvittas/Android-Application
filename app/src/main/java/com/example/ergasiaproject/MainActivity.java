package com.example.ergasiaproject;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


//arxikes dhlwseis
public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button activity launch inside the app
        Button secondActivityBtn= (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent= new Intent(getApplicationContext(), SecondActivity.class);
                //passing information to another activity
                startIntent.putExtra("com.example.ergasiaproject.SOMETHING","Hello New Activity!");
                startActivity(startIntent);
            }
        });

        //Google Button
        Button googleBtn=(Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google ="http://www.google.com";
                Uri webaddress =Uri.parse(google);

                Intent gotoGoogle=new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);
                }
            }
        });

        //University Button
        Button UBtn=(Button) findViewById(R.id.Ubutton);
        UBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String University ="https://www.dit.uoi.gr";
                Uri webaddress = Uri.parse(University);

                Intent gotoUni= new Intent(Intent.ACTION_VIEW,webaddress);
                if (gotoUni.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoUni);
                }
            }
        });


        Button btOpen;
        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.bt_open);


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]
                            {
                                    Manifest.permission.CAMERA
                            },
                    100);
        }
            btOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 100);

                }
            });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100)
        {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captureImage);
        }
    }

}
