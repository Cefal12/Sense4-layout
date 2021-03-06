package com.example.cecil.database2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by cecil on 07-05-2018.
 */


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day);
        return dpd;

    }

    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        TextView date = (TextView) getActivity().findViewById(R.id.date);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day, 0, 0, 0);
        Date chosenDate = cal.getTime();

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMANY);
        String formattedDate = df.format(chosenDate);

        date.setText(formattedDate);

    }
}

