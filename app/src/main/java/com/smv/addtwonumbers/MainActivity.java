package com.smv.addtwonumbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private TextView result;
    private EditText no1;
    private EditText no2;
    private ConstraintLayout activity;

    View.OnLongClickListener longClick = new View.OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View v)
        {
            Toast.makeText(MainActivity.this, "Enter both numbers and click the button for the result", Toast.LENGTH_SHORT).show();
            //če vrnemo false, se sproži tudi dogodek click
            return true;
        }
    };

    private View.OnClickListener click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            double number1, number2;

            //program se brez dodatne kontrole sesuje v primeru, ko vsaj eno število ni vpisano
            //verzija z if
            //            if(no1.getText().toString().equals("") || no2.getText().length() == 0)
            //            {
            //                Toast.makeText(MainActivity.this, "At least one number missing", Toast.LENGTH_SHORT).show();
            //            }
            //            else
            //            {
            //                number1 = Double.parseDouble(no1.getText().toString());
            //                number2 = Double.parseDouble(no2.getText().toString());
            //
            //                result.setText(Double.toString(number1 + number2));
            //            }

            //verzija z lovljenjem izjem
            try
            {
                number1 = Double.parseDouble(no1.getText().toString());
                number2 = Double.parseDouble(no2.getText().toString());

                result.setText(Double.toString(number1 + number2));
            }
            catch (Exception ex)
            {
                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    };

    //za text changed v EditViewijih
    TextWatcher no1no2TextChanged = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            result.setText("");
        }

        @Override
        public void afterTextChanged(Editable s)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        result = findViewById(R.id.textViewResult);
        no1 = findViewById(R.id.editTextNo1);
        no2 = findViewById(R.id.editTextNo2);
        activity = findViewById(R.id.activity);

        //nastavimo onClickListener
        button.setOnClickListener(click);

        //nastavimo onLongClickListener-je
        button.setOnLongClickListener(longClick);
        no1.setOnLongClickListener(longClick);
        no2.setOnLongClickListener(longClick);
        result.setOnLongClickListener(longClick);
        activity.setOnLongClickListener(longClick);

        //nastavimo TextWatcerje
        no1.addTextChangedListener(no1no2TextChanged);
        no2.addTextChangedListener(no1no2TextChanged);
    }
}