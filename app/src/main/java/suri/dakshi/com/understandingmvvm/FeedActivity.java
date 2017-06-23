package suri.dakshi.com.understandingmvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;

import suri.dakshi.com.understandingmvvm.databinding.ActivityFeedBinding;


public class FeedActivity extends AppCompatActivity {

    ArrayList<ChatBubble> arrayList;
    ChatBubbleAdapter mChatBubbleAdapter;
    ActivityFeedBinding activityFeedBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFeedBinding= DataBindingUtil.setContentView(this,R.layout.activity_feed);

        activityFeedBinding.setChatwindow(this);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        activityFeedBinding.chatBubbleRecycleView.setLayoutManager(mLayoutManager);

        arrayList = new ArrayList<>();
        mChatBubbleAdapter = new ChatBubbleAdapter(arrayList, this);
        activityFeedBinding.chatBubbleRecycleView.setAdapter(mChatBubbleAdapter);
        updateChatData();
    }

    public void updateChatData() {

        for(int i=0;i<10;i++)
        {
            arrayList.add(new ChatBubble("", "https://cdn.pixabay.com/photo/2014/09/14/20/24/guitar-445387_960_720.jpg", 0, 1));
            arrayList.add(new ChatBubble("Hello! How was your day?", "", 0, 1));
        }
        //mRecyclerView.getAdapter().notifyItemInserted(arrayList.size()-1);
        activityFeedBinding.chatBubbleRecycleView.scrollToPosition(activityFeedBinding.chatBubbleRecycleView.getAdapter().getItemCount() - 1);
    }

    public void showList()
    {
        arrayList.add(new ChatBubble(activityFeedBinding.messageBox.getText().toString(),"",0,1));
        activityFeedBinding.chatBubbleRecycleView.scrollToPosition(activityFeedBinding.chatBubbleRecycleView.getAdapter().getItemCount() - 1);
    }
}
