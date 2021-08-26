package com.example.studentportal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClearanceFragment extends Fragment {

    TextView Paid, Expected, Verdict;
    EditText idNO;
    Button submit,calculate;


    DatabaseReference databaseReference;

    public ClearanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clearance, container, false);


        idNO = (EditText) view.findViewById(R.id.IDNO);
        Expected = (TextView) view.findViewById(R.id.expected);
        Paid = (TextView) view.findViewById(R.id.paid);
        Verdict = (TextView) view.findViewById(R.id.verdict);
        submit = (Button) view.findViewById(R.id.submit);
        calculate = (Button) view.findViewById(R.id.calculate);

        databaseReference = FirebaseDatabase.getInstance().getReference();



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Bundle bundle = getArguments();
//                String IDNO = bundle.getString("ID");
                String amountPaid = Paid.getText().toString();
                int paid = Integer.parseInt(amountPaid);

                if (paid >= 125000) {
                    Verdict.setText("You have paid Kshs. " + (paid - 125000) + " in excess.");
                }
                else if (paid < 125000) {
                    Verdict.setText("Amount to pay: Kshs. " + (125000 - paid));
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getArguments();
                String IDNO = idNO.getText().toString();

                String amountPaid = Paid.getText().toString();
                int paid = Integer.parseInt(amountPaid);

                if (paid >= 125000) {
                    databaseReference.child("Fees").child(IDNO).child("Fees status").setValue("Cleared");
                }
                else if (paid < 125000) {
                    databaseReference.child("Fees").child(IDNO).child("Fees status").setValue("Not cleared");
                }

            }
        });

        return view;
    }
}
