package com.example.mufee;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePICKER extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int date,year,month;
        year=c.get(Calendar.YEAR);
        date=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,date);
    }
}
