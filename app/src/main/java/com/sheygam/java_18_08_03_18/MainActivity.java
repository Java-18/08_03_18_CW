package com.sheygam.java_18_08_03_18;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MenuItem settingItem, doneItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        settingItem = menu.findItem(R.id.settings_item);
        doneItem = menu.findItem(R.id.done_item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings_item){
            settingItem.setVisible(false);
            doneItem.setVisible(true);
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.logout_item){
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Logout")
                    .setMessage("You want quit?")
                    .setIcon(R.drawable.ic_settings)
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Was clicked yes!", Toast.LENGTH_SHORT).show();
                        }
                    })
//                    .setNegativeButton("No",null)
                    .create();
            dialog.show();
        }else if(item.getItemId() == R.id.done_item){
            doneItem.setVisible(false);
            settingItem.setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
