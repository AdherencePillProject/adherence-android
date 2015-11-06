package com.adherence.adherence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by suhon_000 on 10/29/2015.
 */
public class MedicationListAdapter extends RecyclerView.Adapter<MedicationListAdapter.ViewHolder>{

    private String[] medicineListHardcode;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View listRootView;

        public TextView getMedicineName() {
            return medicineName;
        }

        private TextView medicineName;
        public ViewHolder(View v) {
            super(v);
            listRootView = v;
            medicineName = (TextView) v.findViewById(R.id.medicine_name);
        }
    }

    public MedicationListAdapter(String[] hardCode) {
        medicineListHardcode = hardCode;
    }

    @Override
    public MedicationListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.medication_listitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MedicationListAdapter.ViewHolder vh, int position) {
        vh.getMedicineName().setText(medicineListHardcode[position]);
    }

    @Override
    public int getItemCount() {
        return medicineListHardcode.length;
    }
}
