package com.example.contract;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContractAdapter extends RecyclerView.Adapter<ContractAdapter.ViewHolder> {

    private ArrayList<Contact> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView rowItemName;
        private ImageView rowItemImage;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            rowItemName = (TextView) view.findViewById(R.id.rowItemName);
            rowItemImage = (ImageView) view.findViewById(R.id.rowItemImage);
        }

        public TextView getRowItemName() {
            return rowItemName;
        }
        public ImageView getRowItemImage() {return rowItemImage ;}
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ContractAdapter(ArrayList<Contact> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false);

        return new ViewHolder(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getRowItemName().setText(localDataSet.get(position).getName()  + localDataSet.get(position).getEmail());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
