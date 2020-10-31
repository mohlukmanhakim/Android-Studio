package com.example.appbiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbiodata.activities.AboutActivity;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent= new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void cellphone(View view){
        Uri uri=Uri.parse("tel:081358893502");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public void showMaps(View view){
        Uri uri=Uri.parse("geo:-6.9019187,110.8024143,17z");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public void email (View view){
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"m.lukmanhaki3@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Email dari aplikasi android");

        try{
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
        }catch (android.content.ActivityNotFoundException ex){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, AboutActivity.class));
        }else if (item.getItemId()==R.id.help){
            startActivity(new Intent(this, HelpActivity.class));
        }else if(item.getItemId()==R.id.exit){
            finish();
        }
        return true;
    }
}