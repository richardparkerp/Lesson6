package com.example.lesson6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.img,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       final EditText login = findViewById(R.id.login);
       final EditText password = findViewById(R.id.password);



//
//       ListView listView = findViewById(R.id.ListView);
//
//       String [] data = {"Who" ,"are","you","?"};
//       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);
//       listView.setAdapter(arrayAdapter);


//        GridView gridView = findViewById(R.id.gridView);
//        ImageAdapter imageAdapter = new ImageAdapter(this,images);
//        gridView.setAdapter(imageAdapter);


//        Gallery gallery = findViewById(R.id.gallery);
//        gallery.setAdapter(new ImageAdapter(this,images));



    }

    public void loginButton(View view){
        Intent intent =new Intent(MainActivity.this,SecondPage.class);
        startActivity(intent);
    }



}