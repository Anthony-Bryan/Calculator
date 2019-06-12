package com.example.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    TextView text1;
    TextView text2;
    TextView textRes;
    TextView button;
    String Add = "Add";
    String Sub = "Substraction";
    String Mul = "Multiply";
    String Div = "Divide";
    int angka1;
    int angka2;
    String result;
    long Hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.OPR);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        text1 = findViewById(R.id.INP1);
        text2 = findViewById(R.id.INP2);
        textRes = findViewById(R.id.ANS);
        button = findViewById(R.id.CLC);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().contains("Add")) {
                    Hasil = (long) Integer.parseInt(text1.getText().toString()) + Integer.parseInt(text2.getText().toString());
                    Toast.makeText(getBaseContext(), Add, Toast.LENGTH_SHORT).show();
                } else if (spinner.getSelectedItem().toString().contains("Subtract")) {
                    Hasil = (long) Integer.parseInt(text1.getText().toString()) - Integer.parseInt(text2.getText().toString());
                    Toast.makeText(getBaseContext(), Sub, Toast.LENGTH_SHORT).show();
                } else if (spinner.getSelectedItem().toString().contains("Multiply")) {
                    Hasil = (long) Integer.parseInt(text1.getText().toString()) * Integer.parseInt(text2.getText().toString());
                    Toast.makeText(getBaseContext(), Mul, Toast.LENGTH_SHORT).show();
                } else if (spinner.getSelectedItem().toString().contains("Divide")) {
                    Hasil = (long) Integer.parseInt(text1.getText().toString()) / Integer.parseInt(text2.getText().toString());
                    Toast.makeText(getBaseContext(), Div, Toast.LENGTH_SHORT).show();
                }

                result = String.valueOf(Hasil);
                textRes.setText(result);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
