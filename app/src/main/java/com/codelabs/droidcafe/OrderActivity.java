package com.codelabs.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }

        Intent intent = getIntent();
        String mChosenProduct = intent.getStringExtra(MainActivity.SELECTED_PRODUCT);

        TextView mOrderNameTextView = findViewById(R.id.textView_order);
        mOrderNameTextView.setText("Your Ordered A " + mChosenProduct);

    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.sameday:
                if(checked){
                    Toast.makeText(this, R.string.message_same_day_delivery,
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nextday:
                if(checked){
                    Toast.makeText(this, R.string.message_next_day_delivery,
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pickup:
                if(checked){
                    Toast.makeText(this, R.string.message_pickup,
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
