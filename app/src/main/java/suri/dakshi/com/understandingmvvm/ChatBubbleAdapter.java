package suri.dakshi.com.understandingmvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.renderscript.ScriptGroup;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import suri.dakshi.com.understandingmvvm.databinding.ChatBubbleReceiveBinding;


/**
 * Created by root on 16/5/17.
 */

public class ChatBubbleAdapter extends RecyclerView.Adapter<ChatBubbleAdapter.ChatBubbleViewHolder> {

    ArrayList<ChatBubble> arrayList;
    Context context;

    public ChatBubbleAdapter(ArrayList<ChatBubble> arrayList, Context context) {


        this.arrayList=arrayList;
        this.context=context;
    }


    @Override
    public ChatBubbleAdapter.ChatBubbleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ChatBubbleReceiveBinding chatBubbleReceiveBinding=
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.chat_bubble_receive, parent, false);
        return new ChatBubbleViewHolder(chatBubbleReceiveBinding);
    }

    @Override
    public void onBindViewHolder(ChatBubbleViewHolder holder, int position) {

            ChatBubbleReceiveBinding binding=holder.mChatBubbleReceiveBinding;
            binding.setChatbubble(new ChatBubbleViewModel(arrayList.get(position),context));

        }


    @Override
    public int getItemCount()
    {
        return this.arrayList.size();
    }

    class ChatBubbleViewHolder extends RecyclerView.ViewHolder
    {

        ChatBubbleReceiveBinding mChatBubbleReceiveBinding;

        public ChatBubbleViewHolder(ChatBubbleReceiveBinding chatBubbleReceiveBinding)
        {
            super(chatBubbleReceiveBinding.getRoot());
            mChatBubbleReceiveBinding=chatBubbleReceiveBinding;
            mChatBubbleReceiveBinding.setView(chatBubbleReceiveBinding.getView());
        }

        }
    }

