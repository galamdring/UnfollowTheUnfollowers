package com.galamdring.android.unfollowtheunfollowers;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by LMCKECHNIE on 1/13/2018.
 */

public class UnfollowerAdapter extends RecyclerView.Adapter<UnfollowerAdapter.UnfollowerAdapterViewHolder> {
    String[] unfollowers;
    final private UnfollowerOnClickHandler unfollowerClickHandler;

    @Override
    public UnfollowerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.unfollower_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem,parent,shouldAttachToParentImmediately);
        return new UnfollowerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UnfollowerAdapterViewHolder holder, int position) {
        String unfollower = unfollowers[position];
        holder.tvUnfollower.setText(unfollower);
    }

    @Override
    public int getItemCount() {
        if(unfollowers == null){
            return 0;
        }
        return unfollowers.length;
    }

    public void setData(String[] unfollowersData) {
        unfollowers=unfollowersData;
        notifyDataSetChanged();
    }
    public void clearData(){
        unfollowers=new String[]{};
        notifyDataSetChanged();
    }

    public interface UnfollowerOnClickHandler{
        void onClicked(String unfollowerClicked);
    }

    public UnfollowerAdapter(UnfollowerOnClickHandler handler){
        unfollowerClickHandler = handler;
    }
    public class UnfollowerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView tvUnfollower;
        public UnfollowerAdapterViewHolder(View view){
            super(view);
            tvUnfollower = (TextView) view.findViewById(R.id.tv_unfollower_item);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            unfollowerClickHandler.onClicked(unfollowers[clickedPosition]);
        }
    }
}
