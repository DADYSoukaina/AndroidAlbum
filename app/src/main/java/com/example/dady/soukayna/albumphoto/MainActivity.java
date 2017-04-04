package com.example.dady.soukayna.albumphoto;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static ImageView imageV;
    int[] img ={R.drawable.img1,R.drawable.img2,R.drawable.img6};
    private int indexImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(this,"Sauvegarde de l'état!",Toast.LENGTH_LONG).show();

        outState.putString("index",String.valueOf(indexImg));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        imageV=(ImageView)findViewById(R.id.imageView3);
        TextView index = (TextView)findViewById(R.id.index);

        indexImg=Integer.valueOf(savedInstanceState.getString("index"));
        Toast.makeText(this,"Restauration de l'état!",Toast.LENGTH_LONG).show();
    }

    public void Suivant(View v)
    {
        imageV =(ImageView)findViewById(R.id.imageView3);
        TextView index = (TextView)findViewById(R.id.index);

        indexImg++;
        indexImg=indexImg%img.length;
        imageV.setImageResource(img[indexImg]);
        index.setText(String.valueOf(indexImg+1));
    }

    public void precedent(View v)
    {
        imageV =(ImageView)findViewById(R.id.imageView3);
        TextView index = (TextView)findViewById(R.id.index);

        indexImg--;
        if(indexImg==-1) indexImg=img.length-1;
        indexImg=indexImg%img.length;
        imageV.setImageResource(img[indexImg]);
        index.setText(String.valueOf(indexImg+1));
    }

}
