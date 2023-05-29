package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;
    String wordClicked = "";
    int langCheck = 0;

    boolean favcheck = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.textViewDBS);
        OCBC = findViewById(R.id.textViewOCBC);
        UOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText(getString(R.string.bank1));
            OCBC.setText(getString(R.string.bank2));
            UOB.setText(getString(R.string.bank3));
            langCheck = 0;
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBS.setText(getString(R.string.CB1));
            OCBC.setText(getString(R.string.CB2));
            UOB.setText(getString(R.string.CB3));
            langCheck = 1;
            return true;
        } else {
            DBS.setText(getString(R.string.error));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(langCheck == 0) {
            if (v == DBS) {
                wordClicked = getString(R.string.bank1);
            }
            if (v == OCBC) {
                wordClicked = getString(R.string.bank2);
            }
            if (v == UOB) {
                wordClicked = getString(R.string.bank3);
            }

            menu.add(0, 0, 0, getString(R.string.Emenu1));
            menu.add(0, 1, 1, getString(R.string.Emenu2));
            menu.add(0, 2, 2, getString(R.string.Emenu3));
        }
        if(langCheck == 1) {
            if (v == DBS) {
                wordClicked = getString(R.string.bank1);
            }
            if (v == OCBC) {
                wordClicked = getString(R.string.bank2);
            }
            if (v == UOB) {
                wordClicked = getString(R.string.bank3);
            }

            menu.add(0, 0, 0, getString(R.string.Cmenu1));
            menu.add(0, 1, 1, getString(R.string.Cmenu2));
            menu.add(0, 1, 1, getString(R.string.Cmenu3));
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase(getString(R.string.bank1))) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.wb1)));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +getString(R.string.pN1) ));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 2) { //check whether the selected menu item ID is 0
                //code for action

                    DBS.setTextColor(Color.RED);
                    OCBC.setTextColor(Color.BLACK);
                    UOB.setTextColor(Color.BLACK);

                return true; //menu item successfully handled
            }
        }
        if(wordClicked.equalsIgnoreCase(getString(R.string.bank2))) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.wb2)));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.pN2)));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 2) { //check whether the selected menu item ID is 0
                //code for action

                    DBS.setTextColor(Color.BLACK);
                    OCBC.setTextColor(Color.RED);
                    UOB.setTextColor(Color.BLACK);


                return true; //menu item successfully handled
            }
        }
        if(wordClicked.equalsIgnoreCase(getString(R.string.bank3))) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.wb3)));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +getString(R.string.pN3) ));
                startActivity(intentCall);

                return true; //menu item successfully handled
            }
            if (item.getItemId() == 2) { //check whether the selected menu item ID is 0
                //code for action

                    DBS.setTextColor(Color.BLACK);
                    OCBC.setTextColor(Color.BLACK);
                    UOB.setTextColor(Color.RED);


                return true; //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }





}