package com.adherence.adherence;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by suhon_000 on 10/30/2015.
 */
public class TodayFragment extends Fragment{
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TodayFragment newInstance(int sectionNumber) {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today, container, false);
        ProgressBar progress = (ProgressBar) rootView.findViewById(R.id.progressWheel);
        progress.setSecondaryProgress(80);
        addTimeViews(rootView, inflater);
        return rootView;
    }

    private void addTimeViews(View rootView, LayoutInflater timeViewInflater) {
        LinearLayout containerView = (LinearLayout) rootView.findViewById(R.id.today_container);

        //HARDCODED
        String[] stamps = {"8:00 AM", "1:00 PM", "3:00 PM"};
        String[] pillNames = {"Pill A", "Pill B", "Pill C", "Pill D"};
        String[] pillCounts = {"4", "3", "5", "1"};
        for (int i = 0; i < 3; i++) {
            View timeView = timeViewInflater.inflate(R.layout.time_view, null);
            TextView timeStamp = (TextView) timeView.findViewById(R.id.time_stamp);
            timeStamp.setText(stamps[i]);
            LinearLayout pillListContainer = (LinearLayout) timeView.findViewById(R.id.time_pill_list);
            for (int j = 0; j < 4; j++) {
                View  pillView = timeViewInflater.inflate(R.layout.pill_list_view, null);
                TextView pillName = (TextView) pillView.findViewById(R.id.pill_name);
                pillName.setText(pillNames[j]);
                TextView pillCount = (TextView) pillView.findViewById(R.id.pill_count);
                pillCount.setText(pillCounts[j]);
                pillListContainer.addView(pillView);
            }
            containerView.addView(timeView);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity) context).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
