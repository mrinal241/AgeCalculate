package com.example.hasi.agecalculate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText day, month, year;
    Button cal, reset;
    TextView textView;
    int i=0, j=0, k=1, l=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker=findViewById(R.id.date_pick);
        textView=findViewById(R.id.text_view);

        day=findViewById(R.id.day_edit);
        month=findViewById(R.id.month_edit);
        year=findViewById(R.id.year_edit);

        cal=findViewById(R.id.cal_btn);
        reset=findViewById(R.id.reset_btn);


        cal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String age;
                int a=0,b=0,c = 0, cday, iday, cmonth, imonth, cyear, iyear;

                iday= Integer.parseInt(day.getText().toString());
                imonth=Integer.parseInt(month.getText().toString());
                iyear=Integer.parseInt(year.getText().toString());

                cday=datePicker.getDayOfMonth();
                cmonth=datePicker.getMonth()+1;
                cyear=datePicker.getYear();


                if (day !=null && month!=null && year!=null && iday<32 && imonth<13 && iyear <9999 && iyear < cyear){
                    if (cday>=iday){
                        a=1+cday-iday;
                        if (cmonth>=imonth){
                            b=cmonth-imonth;
                            c=cyear-iyear;

                        }
                        else{
                            b=cmonth+12-imonth;
                            c=cyear-1-iyear;
                        }

                    }
                    else {
                        a=cday+30-iday;
                        if (cmonth>=(imonth+1)){
                            b=cmonth-1-imonth;
                            c=cyear-iyear;

                        }
                        else{
                            b=cmonth+11-imonth;
                            c=cyear-1-iyear;
                        }
                    }

                    String value= "Your age= "+c+" Year, "+b+" Month, "+a+" day.";
                    textView.setText(value);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                }





            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Your age: ");
                day.setText(null);
                month.setText(null);
                year.setText(null);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_dev :
                Intent intent=new Intent(getApplicationContext(), DeveloperActivity.class);
                startActivity(intent);
                break;
                default:
                    Intent intet=new Intent(getApplicationContext(), DeveloperActivity.class);
                    startActivity(intet);
                    break;

        }
        return super.onOptionsItemSelected(item);
    }
}
