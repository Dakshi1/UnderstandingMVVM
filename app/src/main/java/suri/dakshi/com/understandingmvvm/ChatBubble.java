package suri.dakshi.com.understandingmvvm;


public class ChatBubble{

    String message;
    String imgPath;
    int mode =-1;
    int content_type=0;
    public ChatBubble(String message, String imgPath, int mode, int content_type) {
        this.imgPath=imgPath;
        this.message = message;
        this.mode = mode;
        this.content_type=content_type;

    }
    public ChatBubble()
    {

    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {


        this.content_type = content_type;

    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

//    @BindingAdapter("android:src")
//    public static void loadImage(ImageView view, String imgPath) {
//        Glide.with(view.getContext()).load(imgPath).centerCrop().into(view);
//
//    }
}
