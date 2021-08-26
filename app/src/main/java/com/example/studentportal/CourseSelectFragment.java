package com.example.studentportal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseSelectFragment extends Fragment {

    TextView instructions, show;
    EditText IDNO;
    CheckBox apt3040, apt3050, apt3060, apt3080, ist3040, ist3050, ist3060;
    int numberOfCheckboxesChecked = 0;
    String course1, course2, course3, course4, course5, enteredID;
    Button save, display;

    DatabaseReference databaseReference;

    public CourseSelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_select, container, false);


        instructions = (TextView) view.findViewById(R.id.courseInstructions);
        show = (TextView) view.findViewById(R.id.showCourses);
        IDNO = (EditText) view.findViewById(R.id.idNumber);
        apt3040 = (CheckBox) view.findViewById(R.id.apt3040);
        apt3050 = (CheckBox) view.findViewById(R.id.apt3050);
        apt3060 = (CheckBox) view.findViewById(R.id.apt3060);
        apt3080 = (CheckBox) view.findViewById(R.id.apt3080);
        ist3040 = (CheckBox) view.findViewById(R.id.ist3040);
        ist3050 = (CheckBox) view.findViewById(R.id.ist3050);
        ist3060 = (CheckBox) view.findViewById(R.id.ist3060);
        save = (Button) view.findViewById(R.id.save);
        display = (Button) view.findViewById(R.id.display);

        databaseReference = FirebaseDatabase.getInstance().getReference();


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredID = IDNO.getText().toString();
                show.setText("Course1: " + course1 + " \n " + "Course2: " + course2 + " \n " + "Course3: " + course3 + " \n " + "Course4: " + course4 + " \n " + "Course5: " + course5 + "\n" + "ID is " + enteredID);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enteredID = IDNO.getText().toString();
                String idNO = enteredID;

                String c1 = course1;
                String c2 = course2;
                String c3 = course3;
                String c4 = course4;
                String c5 = course5;

                //pass the data from the interface through the user class interface
                Courses courses = new Courses(c1, c2, c3, c4, c5);

                //push the values into the database using the database reference
                databaseReference.child("Student Courses").child(idNO).setValue(courses);

            }
        });

        apt3040.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    apt3040.setChecked(false);
                } else {
                    // the checkbox either got unchecked
                    // or there are less than 2 other checkboxes checked
                    // change your counter accordingly
                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    // now everything is fine and you can do whatever
                    // checking the checkbox should do here

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = apt3040.getText().toString();
                            break;
                        case 2:
                            course2 = apt3040.getText().toString();
                            break;
                        case 3:
                            course3 = apt3040.getText().toString();
                            break;
                        case 4:
                            course4 = apt3040.getText().toString();
                            break;
                        case 5:
                            course5 = apt3040.getText().toString();
                            break;
                    }
                }
            }
        });

        apt3050.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    apt3050.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = apt3050.getText().toString();
                            break;
                        case 2:
                            course2 = apt3050.getText().toString();
                            break;
                        case 3:
                            course3 = apt3050.getText().toString();
                            break;
                        case 4:
                            course4 = apt3050.getText().toString();
                            break;
                        case 5:
                            course5 = apt3050.getText().toString();
                            break;
                    }
                }
            }
        });

        apt3060.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    apt3060.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = apt3060.getText().toString();
                            break;
                        case 2:
                            course2 = apt3060.getText().toString();
                            break;
                        case 3:
                            course3 = apt3060.getText().toString();
                            break;
                        case 4:
                            course4 = apt3060.getText().toString();
                            break;
                        case 5:
                            course5 = apt3060.getText().toString();
                            break;
                    }
                }
            }
        });

        apt3080.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    apt3080.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = apt3080.getText().toString();
                            break;
                        case 2:
                            course2 = apt3080.getText().toString();
                            break;
                        case 3:
                            course3 = apt3080.getText().toString();
                            break;
                        case 4:
                            course4 = apt3080.getText().toString();
                            break;
                        case 5:
                            course5 = apt3080.getText().toString();
                            break;
                    }
                }
            }
        });

        ist3040.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    ist3040.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = ist3040.getText().toString();
                            break;
                        case 2:
                            course2 = ist3040.getText().toString();
                            break;
                        case 3:
                            course3 = ist3040.getText().toString();
                            break;
                        case 4:
                            course4 = ist3040.getText().toString();
                            break;
                        case 5:
                            course5 = ist3040.getText().toString();
                            break;
                    }
                }
            }
        });

        ist3050.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    ist3050.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = ist3050.getText().toString();
                            break;
                        case 2:
                            course2 = ist3050.getText().toString();
                            break;
                        case 3:
                            course3 = ist3050.getText().toString();
                            break;
                        case 4:
                            course4 = ist3050.getText().toString();
                            break;
                        case 5:
                            course5 = ist3050.getText().toString();
                            break;
                    }
                }
            }
        });

        ist3060.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && numberOfCheckboxesChecked >= 5) {
                    ist3060.setChecked(false);
                } else {

                    if (isChecked) {
                        numberOfCheckboxesChecked++;
                    } else {
                        numberOfCheckboxesChecked--;
                    }

                    switch (numberOfCheckboxesChecked) {
                        case 1:
                            course1 = ist3060.getText().toString();
                            break;
                        case 2:
                            course2 = ist3060.getText().toString();
                            break;
                        case 3:
                            course3 = ist3060.getText().toString();
                            break;
                        case 4:
                            course4 = ist3060.getText().toString();
                            break;
                        case 5:
                            course5 = ist3060.getText().toString();
                            break;
                    }
                }
            }
        });

        return view;
    }
}