package com.nastya.cimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nastya.androidcontrollibriary.ControllClass;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;
    private  final int Pick_image = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.imageView);
        Button imagebutton = (Button) findViewById(R.id.button);

        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent ImageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, ImageReturnedIntent);
        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = ImageReturnedIntent.getData();
                        String mimetype = getContentResolver().getType(imageUri);
                         if (ControllClass.CheckMimetype(mimetype, "jpeg")) {
                             final InputStream imageinputStream = getContentResolver().openInputStream(imageUri);
                             Bitmap selectBitmap = BitmapFactory.decodeStream(imageinputStream);
                             final Bitmap finalSelectBitmap = ControllClass.BitmapSize(selectBitmap, 50, 50);
                             imageview.setImageBitmap(finalSelectBitmap);
                         }

                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
        }
    }
}
