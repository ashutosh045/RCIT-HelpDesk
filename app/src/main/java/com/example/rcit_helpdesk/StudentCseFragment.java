package com.example.rcit_helpdesk;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentCseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentCseFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CardView syllabusCardBtn,notesBtn;
    Spinner spinner;
    ArrayList<String> semesterList= new ArrayList<>();
    Boolean flag = true;
    Boolean flag1 = true;

    Dialog notesDialog,dialog;
    Button submitBtn;
    String dept;
    Toolbar toolbar;

    public StudentCseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentCseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentCseFragment newInstance(String param1, String param2) {
        StudentCseFragment fragment = new StudentCseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dept = ((CseActivity)getActivity()).Department;
        System.out.println("xyz - "+dept);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_cse, container, false);
        if (((CseActivity)getActivity()).Department.equals("cse")) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Computer Science");
        }
        if (((CseActivity)getActivity()).Department.equals("civil")) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Civil Engg");
        }
        if (((CseActivity)getActivity()).Department.equals("electrical")) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Electrical Engg");
        }
        if (((CseActivity)getActivity()).Department.equals("electronics")) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Electronics Engg");
        }
        if (((CseActivity)getActivity()).Department.equals("mechanical")) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Mechanical Engg");
        }
        syllabusCardBtn = view.findViewById(R.id.syllabusCseCard);
        notesBtn = view.findViewById(R.id.notesCseCard);

        syllabusCardBtn.setOnClickListener(this);
        notesBtn.setOnClickListener(this);
        return view;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.syllabusCseCard:

                dialog = new Dialog(getActivity());

                dialog.setContentView(R.layout.syllabus_dialog_lay);

                    spinner = dialog.findViewById(R.id.semesterSpinnerList);
                    semesterList.add("Semester 1");
                    semesterList.add("Semester 2");
                    semesterList.add("Semester 3");
                    semesterList.add("Semester 4");
                    semesterList.add("Semester 5");
                    semesterList.add("Semester 6");
                    semesterList.add("Semester 7");
                    semesterList.add("Semester 8");
                    ArrayAdapter<String> semListAdapter  = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,semesterList);
                    spinner.setAdapter(semListAdapter);

                submitBtn = dialog.findViewById(R.id.submitDialogBtn);
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (((CseActivity)getActivity()).Department.equals("cse")) {
                            ((CseActivity) getActivity()).showCseActivity();
                            dialog.dismiss();
                        }
                        else if (((CseActivity)getActivity()).Department.equals("civil")) {
                            ((CseActivity) getActivity()).showCivilActivity();
                            dialog.dismiss();
                        }
                        else if (((CseActivity)getActivity()).Department.equals("electrical")) {
                            ((CseActivity) getActivity()).showElectricalActivity();
                            dialog.dismiss();
                        }
                        else if (((CseActivity)getActivity()).Department.equals("electronics")) {
                            ((CseActivity) getActivity()).showElectronicsActivity();
                            dialog.dismiss();
                        }
                        else {
                            ((CseActivity) getActivity()).showMechanicalActivity();
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();

                break;
            case R.id.notesCseCard:

                notesDialog = new Dialog(getActivity());

                notesDialog.setContentView(R.layout.syllabus_dialog_lay);

                    spinner = notesDialog.findViewById(R.id.semesterSpinnerList);
                    semesterList.add("Semester 1");
                    semesterList.add("Semester 2");
                    semesterList.add("Semester 3");
                    semesterList.add("Semester 4");
                    semesterList.add("Semester 5");
                    semesterList.add("Semester 6");
                    semesterList.add("Semester 7");
                    semesterList.add("Semester 8");
                    ArrayAdapter<String> semNotesListAdapter  = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,semesterList);
                    spinner.setAdapter(semNotesListAdapter);
                    flag1 =  false;
                submitBtn = notesDialog.findViewById(R.id.submitDialogBtn);
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        notesDialog.dismiss();
                    }
                });
                notesDialog.show();

                break;
        }
    }

}