package android.example.com.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog
        .OnDateSetListener{

    private static Calendar calender;

    private OnDateSetListener mListener;

    public static interface OnDateSetListener{
        public abstract void onDateSet(String date);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof MainActivity){
            MainActivity activity = (MainActivity) context;
            mListener = activity;
        }

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Use the current date as the default date in the picker
        if(calender == null){
            calender = Calendar.getInstance();
        }
        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH);
        int day = calender.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        DatePicker picker = dialog.getDatePicker();
        picker.setMinDate(System.currentTimeMillis());
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth){

        savePrevDate(year, month, dayOfMonth);

        String newDate = (month + 1) + " - " + dayOfMonth + " - " + year;
        mListener.onDateSet(newDate);

    }


    public void savePrevDate(int year, int month, int dayOfMonth){

        calender = Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.MONTH, month);
        calender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

    }
}
