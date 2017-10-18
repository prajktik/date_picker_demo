package android.example.com.datepicker;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.OnDateSetListener{

    private static final String DIALOG_TAG = "datePicker";
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String date = sdf.format(time);
        displayDate(date);
    }

    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), DIALOG_TAG);
    }

    private void displayDate(String date){
        textView.setText(date);
    }

    @Override
    public void onDateSet(String date){
        displayDate(date);
    }
}
