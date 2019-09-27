package com.tutorial.read_data_from_content_provider_ex;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ContentResolver contentResolver = getContentResolver();
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.tutorial.content_provider_ex.UserProvider/users"),
                null, null, null, null);
        if (cursor.moveToFirst()) {
            StringBuilder strBuild = new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n" + cursor.getString(cursor.getColumnIndex("id")) + "-" + cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
//            resultView.setText(strBuild);
            Log.i("Test Demo", strBuild.toString());
        } else {
            //resultView.setText("No Records Found");
            Log.i("Test Demo", "No Records Found");
        }
    }
}
