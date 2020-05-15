package com.example.newshub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends FirestoreRecyclerAdapter<Superheros, RecyclerAdapter.SuperherosHolder> {

    private Context context;
    FirestoreRecyclerOptions<Superheros> mOptions;

    public RecyclerAdapter(@NonNull FirestoreRecyclerOptions<Superheros> options,Context context) {
        super(options);
        this.mOptions=options;
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull SuperherosHolder holder, int position, @NonNull Superheros model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());
        Glide.with(context)
                .asBitmap()
                .load(model.getPhoto())
                .into(holder.imageView);
    }

    @NonNull
    @Override
    public SuperherosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.superhero_card,parent,false);

        return new SuperherosHolder(v);
    }

    class SuperherosHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle,textViewDescription;
        ImageView imageView;
        public SuperherosHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDescription=itemView.findViewById(R.id.textViewDescription);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
