package com.example.KylePad;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    GridView gridView;
    SoundAdapter listAdapter;
    ArrayList nameList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView);
        listAdapter = new SoundAdapter(this);
        gridView.setMinimumHeight(listAdapter.minimumCellSide);
        gridView.setMinimumWidth(listAdapter.minimumCellSide);
        gridView.setAdapter(listAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MediaPlayer) listAdapter.getItem(position)).start();
            }
        });


    }
}
