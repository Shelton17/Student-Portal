package com.example.studentportal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.

 */
public class RegisterFragment extends Fragment {

        String attemptPicked, genderPicked;
        Button save,clear;
        EditText firstname, lastname, idNumber, yearStudy;
        RadioGroup gender,attempt;
        RadioButton radioButton;
        DatabaseReference databaseReference;

        public RegisterFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_register, container, false);

            save = (Button) view.findViewById(R.id.save);
            clear = (Button) view.findViewById(R.id.clear);
            firstname = (EditText) view.findViewById(R.id.fName);
            lastname = (EditText) view.findViewById(R.id.lName);
            idNumber = (EditText) view.findViewById(R.id.idNo);
            yearStudy = (EditText) view.findViewById(R.id.studyYear);
            gender = (RadioGroup) view.findViewById(R.id.genderChoices);
            attempt = (RadioGroup) view.findViewById(R.id.attemptChoices);

            databaseReference = FirebaseDatabase.getInstance().getReference();

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String fname = firstname.getText().toString();
                    String lname = lastname.getText().toString();
                    String idNO = idNumber.getText().toString();
                    String sYear = yearStudy.getText().toString();
                    String genderChosen = genderPicked;
                    String attemptChosen = attemptPicked;


                    //pass the data from the interface through the user class interface
                    HelperClass student = new HelperClass(fname, lname, idNO, sYear, genderChosen, attemptChosen);

                    //push the values into the database using the database reference
                    databaseReference.child("Students").child(idNO).setValue(student);



                }
            });
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firstname.setText("");
                    lastname.setText("");
                    idNumber.setText("");
                    yearStudy.setText("");
                }
            });

            gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case R.id.radio_male:
                            genderPicked = "Male";
                            break;
                        case R.id.radio_female:
                            genderPicked = "Female";
                            break;
                        default:
                    }
                }
            });

            attempt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case R.id.radio_first:
                            attemptPicked = "First Attempt";
                            break;
                        case R.id.radio_second:
                            attemptPicked = "Second Attempt";
                            break;
                        default:
                    }
                }
            });

            return view;
        }

    }
