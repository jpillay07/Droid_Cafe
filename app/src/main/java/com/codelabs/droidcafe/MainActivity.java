package com.codelabs.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DONUT_PRODUCT = "Donut";
    private static final String ICE_CREAM_SANDWICH_PRODUCT = "Ice Cream Sandwich";
    private static final String FROYO_PRODUCT = "Froyo";
    public String mSelectedProduct;
    public static final String SELECTED_PRODUCT = "Selected Dessert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSelectedProduct != null){
                    Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                    intent.putExtra(SELECTED_PRODUCT, mSelectedProduct);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please select a product",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_contact:
                Toast.makeText(this, R.string.action_contact_message, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_order:
                if(mSelectedProduct != null){
                    Intent intent = new Intent(this, OrderActivity.class);
                    intent.putExtra(SELECTED_PRODUCT, mSelectedProduct);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Please select a product", Toast.LENGTH_SHORT).show();
                }

                return true;
            case R.id.action_status:
                Toast.makeText(this, R.string.action_status_message, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_favourites:
                Toast.makeText(this, R.string.action_favorites_message, Toast.LENGTH_SHORT).show();
                return true;
                default:
                    break;
        }



        return super.onOptionsItemSelected(item);
    }

    /**
     * Shows a toast message with the string passed to it.
     */
    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
        mSelectedProduct = DONUT_PRODUCT;

    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamSandwichOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        mSelectedProduct = ICE_CREAM_SANDWICH_PRODUCT;
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
        mSelectedProduct = FROYO_PRODUCT;
    }
}
