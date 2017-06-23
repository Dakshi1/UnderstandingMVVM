package suri.dakshi.com.understandingmvvm;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by dakshi on 12/6/17.
 */

public class ChatBubbleViewModel extends BaseObservable {

    private ChatBubble chatBubble;
    private Context context;

    public ChatBubbleViewModel(ChatBubble chatBubble, Context context) {
        this.chatBubble = chatBubble;
        this.context = context;
    }

    @Bindable
    public String getMessage()
    {
        return chatBubble.getMessage();
    }

    public void setMessage(String message)
    {
        chatBubble.setMessage(message);
        notifyPropertyChanged(BR.message);
    }
    @Bindable
    public String getImgPath()
    {
        return chatBubble.getImgPath();
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String imgPath) {
        Toast.makeText(view.getContext(), ""+imgPath+view.getHeight(), Toast.LENGTH_SHORT).show();
        Glide.with(view.getContext()).load(imgPath).centerCrop().into(view);
    }
}
