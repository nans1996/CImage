package com.nastya.androidcontrollibriary;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.ContextWrapper;

import java.io.IOException;

public class ControllClass {

//    public static ImageView ImageSize(ImageView image, int heigth, int width) {
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) image.getLayoutParams();
//        params.height = heigth;
//        params.weight = width;
//        image.setLayoutParams(params);
//        return image;
//    }

    public static Bitmap BitmapSize(Bitmap originalBitmal, int heigth, int width) {
        return   Bitmap.createScaledBitmap(originalBitmal, width, heigth, true);
    }

    public  static Boolean CheckMimetype(String uritype, String type) {
        boolean flag = false;
        switch (uritype) {
            case "image/jpeg": {
                if (type.toLowerCase() == "jpeg") {
                    flag = true;
                }
                break;
            }
            case "image/png": {
                if (type.toLowerCase() == "png") {
                    flag = true;
                }
                break;
            }
            case "image/gif": {
                if (type.toLowerCase() == "gif") {
                    flag = true;
                }
                break;
            }

        }
        return  flag;
    }
//    public static int ImageOrientation(String path) {
//        int orientation = -1;
//        try {
//            ExifInterface exif = new ExifInterface(path);
//            String attr = exif.getAttribute(ExifInterface.TAG_ORIENTATION);
//            if (attr != null) orientation = Integer.valueOf(attr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return orientation;
//    }
}
