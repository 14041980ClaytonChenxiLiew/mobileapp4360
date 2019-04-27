package com.mobileapp.newappt;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.com.mobileapp.dB.dBInitialize;


import com.example.calendar_view.MainCalendarActivity;
import com.example.calendar_view.R;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class newAppt extends AppCompatActivity {


    private String setname;
    public static String setphone;
    private String setday;
    private String setmonth;
    private  String setyear;
    private int setstartTime;
    private int setendTime;
    private String setstartTimeamPm;
    private String setendTimeamPm;
    private String setnotes;
    private String StylistKey;
    private String customerKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] year = new String[]{
                "Year",
                "2019",
                "2020"
        };
        String[] month = new String[]{
                "Month", "01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10", "11", "12"
        };
        String [] day = new String[]{
          "Day", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28", "29", "30", "31"
        };

        String [] StartTime = new String[]{
                "Start Time", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12"
        };

        String [] EndTime = new String[]{
                "End Time", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12"
        };

        String [] am_pm = new String[]{
                "AM/PM", "AM", "PM"
        };



        final Spinner yearspinner = (Spinner) findViewById(R.id.spinner);

        final List<String> yearList = new ArrayList<>(Arrays.asList(year));
        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinneritem, yearList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritem);
        yearspinner.setAdapter(spinnerArrayAdapter);

        yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
                setyear = selectedItemText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner monthspinner = (Spinner) findViewById(R.id.spinner4);
          final List<String> monthList = new ArrayList<>(Arrays.asList(month));

        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, monthList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinneritem);
        monthspinner.setAdapter(spinnerArrayAdapter2);

        monthspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
                setmonth = selectedItemText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner dayspinner = (Spinner) findViewById(R.id.spinner5);
        final List<String> dayList = new ArrayList<>(Arrays.asList(day));

        final ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, dayList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter3.setDropDownViewResource(R.layout.spinneritem);
        dayspinner.setAdapter(spinnerArrayAdapter3);

        dayspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
                setday  = selectedItemText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner startTimespinner = (Spinner) findViewById(R.id.spinner6);
        final List<String> StartTimeList = new ArrayList<>(Arrays.asList(StartTime));

        final ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, StartTimeList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter4.setDropDownViewResource(R.layout.spinneritem);
        startTimespinner.setAdapter(spinnerArrayAdapter4);

        startTimespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                    setstartTime = Integer.parseInt(selectedItemText);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner endTimespinner = (Spinner) findViewById(R.id.spinner8);
        final List<String> endTimeList = new ArrayList<>(Arrays.asList(EndTime));

        final ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, endTimeList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter5.setDropDownViewResource(R.layout.spinneritem);
        endTimespinner.setAdapter(spinnerArrayAdapter5);

        endTimespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();

                    setendTime = Integer.parseInt(selectedItemText);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner amPmspinner = (Spinner) findViewById(R.id.spinner7);
        final List<String> amPmList = new ArrayList<>(Arrays.asList(am_pm));

        final ArrayAdapter<String> spinnerArrayAdapter6 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, amPmList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter6.setDropDownViewResource(R.layout.spinneritem);
        amPmspinner.setAdapter(spinnerArrayAdapter6);


        amPmspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
                setstartTimeamPm = selectedItemText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner amPm2spinner = (Spinner) findViewById(R.id.spinner9);

        final List<String> amPmList2 = new ArrayList<>(Arrays.asList(am_pm));

        final ArrayAdapter<String> spinnerArrayAdapter7 = new ArrayAdapter<String>(
                this, R.layout.spinneritem, amPmList2) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter7.setDropDownViewResource(R.layout.spinneritem);
        amPm2spinner.setAdapter(spinnerArrayAdapter7);


        amPm2spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
                setendTimeamPm = selectedItemText;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void goBack (View v ){
        Intent intent = new Intent(this, MainCalendarActivity.class);
        startActivity(intent);
    }


public void sendNewApptQuery(View v){
    EditText nametxt = findViewById(R.id.editText);
    EditText phone = findViewById(R.id.editText2);
    EditText apptnotes = findViewById(R.id.editText5);

    setname = nametxt.getText().toString();
    setphone = phone.getText().toString();
    setnotes = apptnotes.getText().toString();
    StylistKey = "6"; //passed from login
    //customerKey = dBInitialize.custKey;


    dBInitialize newAppointmentQuery = new dBInitialize();
    newAppointmentQuery.phoneexists();
    newAppointmentQuery.getCustomerName("customer1");


   // newAppointmentQuery.setAppointment(setday,setmonth,setyear,setstartTime,setendTime,setstartTimeamPm,setendTimeamPm,customerKey,setnotes,StylistKey);


    }








}











