package com.abhaychaudhary.airway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<messages> messagesArrayList;

    int ITEM_SEND=1;
    int ITEM_RECEIVE =2;


    public MessagesAdapter(Context context, ArrayList<messages> messagesArrayList) {
        this.context = context;
        this.messagesArrayList = messagesArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType== ITEM_RECEIVE)
       {

           View view = LayoutInflater.from(context).inflate(R.layout.recieverchatlayout,parent,false);
           return new ReceiverViewHolder(view);
       }
       else
       {
           View view = LayoutInflater.from(context).inflate(R.layout.senderchatlayout,parent,false);
           return new SenderViewHolder(view);
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        messages messages=messagesArrayList.get(position);
        if(holder.getClass()==SenderViewHolder.class)
        {
            SenderViewHolder viewHolder=(SenderViewHolder)holder;
            viewHolder.textViewmessage.setText(messages.getMessage());
            viewHolder.timeofmessage.setText(messages.getCurrenttime());

        }
        else
        {
            ReceiverViewHolder viewHolder=(ReceiverViewHolder)holder;
            viewHolder.textViewmessage.setText(messages.getMessage());
            viewHolder.timeofmessage.setText(messages.getCurrenttime());
        }













    }


    @Override
    public int getItemViewType(int position) {
        messages messages=messagesArrayList.get(position);
        if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(messages.getSenderId()))
        {
            return ITEM_SEND;
        }
        else
        {
            return ITEM_RECEIVE;
        }
    }

    @Override
    public int getItemCount() {

        return messagesArrayList.size();
    }


    class SenderViewHolder extends RecyclerView.ViewHolder
    {

        TextView textViewmessage;
        TextView timeofmessage;


        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewmessage=itemView.findViewById(R.id.sendermessage);
            timeofmessage=itemView.findViewById(R.id.timeofmessage);


        }
    }


    class ReceiverViewHolder extends RecyclerView.ViewHolder
    {

        TextView textViewmessage;
        TextView timeofmessage;


        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewmessage=itemView.findViewById(R.id.sendermessage);
            timeofmessage=itemView.findViewById(R.id.timeofmessage);


        }
    }





}
