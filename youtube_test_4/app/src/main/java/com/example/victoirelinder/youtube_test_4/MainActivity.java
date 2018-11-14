package com.example.victoirelinder.youtube_test_4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {
    private Button searchButton;
    public boolean videoplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        showsearch();
    }


    private void showsearch() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Search_Fragment search_fragment = new Search_Fragment();
        fragmentTransaction.replace( R.id.contentFrame, search_fragment ).addToBackStack( "search" );
        fragmentTransaction.commit();
    }
}
