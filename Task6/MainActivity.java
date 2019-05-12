package com.example.task6;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Draw2D draw2D;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw2D = new Draw2D(this);
        image = findViewById(R.id.imageView);
    }

    public void onClick(View view) {
        Bitmap bmp = draw2D.CreateImage(image);
        bmp = draw2D.MyDraw(bmp, image);
        image.setImageBitmap(bmp);
    }
}
