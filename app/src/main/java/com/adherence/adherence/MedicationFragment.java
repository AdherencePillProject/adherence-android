package com.adherence.adherence;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by suhon_000 on 10/29/2015.
 */
public class MedicationFragment extends Fragment {

    private static final String ARG_MEDICINE_LIST = "medicine list";
    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] medicineListHardcode;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MedicationFragment newInstance(String[] medicineList, int sectionNumber) {
        MedicationFragment fragment = new MedicationFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_MEDICINE_LIST, medicineList);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        medicineListHardcode = getArguments().getStringArray(ARG_MEDICINE_LIST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medication, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.medication_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MedicationListAdapter(medicineListHardcode);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            ((MainActivity) context).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


}
