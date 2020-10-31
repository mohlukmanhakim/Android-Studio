package com.example.appbiodata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbiodata.R;
import com.example.appbiodata.helper.DataHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class BuatBiodataActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    ExtendedFloatingActionButton fabCreate;
    EditText text1, text2, text3, text4,text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dataHelper = new DataHelper(this);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        fabCreate = findViewById(R.id.fabCreate);

        fabCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
                sqLiteDatabase.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                AboutActivity.aboutActivity.RefreshList();
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}