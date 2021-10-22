package com.example.vjezba2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    EditText Number1,Number2;
    Button button;
    TextView rezultat;
    Spinner spinner;
    String operator ;

    double ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Number1 = (EditText) findViewById(R.id.Number1);
        Number2 = (EditText) findViewById(R.id.Number2);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button);
        rezultat = (TextView) findViewById(R.id.rezultat);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.spinnerItems, android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                operator = spinner.getSelectedItem().toString();;
                Toast.makeText(getBaseContext(), operator, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Niste odabrali operator", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        });

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if( Number1.getText().toString().isEmpty() || Number2.getText().toString().isEmpty()){

                    Toast toast = Toast.makeText(getApplicationContext(), "Niste upisali brojeve", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                Double a = Double.parseDouble(Number1.getText().toString());
                Double b = Double.parseDouble(Number2.getText().toString());

                if(operator == null){
                    Toast toast = Toast.makeText(getApplicationContext(), "Operator nije odabran", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                if(a==0 || b==0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Djelite s nulom ", Toast.LENGTH_SHORT);
                    toast.show();

                }
                ans = 0;

                switch(operator){
                    case "+":
                        ans = a+b;
                        break;
                    case "-":
                        ans = a-b;
                        break;
                    case "*":
                        ans = a*b;
                        break;
                    case "/":
                        ans = a/b;
                        break;
                }
                rezultat.setText(String.valueOf(ans));

            }



        });
    }
}