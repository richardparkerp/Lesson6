package com.example.lesson6;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class SecondPage extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = findViewById(R.id.ListView);
        bookList = new ArrayList<>();

        String jsonStr = loadFromJSON();

        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject book = jsonArray.getJSONObject(i);

                    String title = book.getString("title");
                    String author = book.getString("author");
                    int year = book.getInt("year");

                    bookList.add(title + " by " + author + " (" + year + ")");
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        bookList
                );
                listView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


//           ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,data);
//           listView.setAdapter(arrayAdapter);
    }

    public String loadFromJSON(){
        String json = null;
        try{
            File file = new File(getFilesDir(),"info.json");

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            fis.read(buffer);
            fis.close();

            json = new String(buffer,"UTF-8");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}