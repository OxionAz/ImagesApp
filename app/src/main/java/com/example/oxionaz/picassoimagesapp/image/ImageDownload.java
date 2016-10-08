package com.example.oxionaz.picassoimagesapp.image;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.oxionaz.picassoimagesapp.R;
import com.squareup.picasso.Picasso;

public class ImageDownload implements ImageInteractor {

    private Context context;

    public ImageDownload(Context context){
        this.context = context;
    }

    @Override
    public void load(@Flag int flag, String imgUrl, ImageView target) {
        switch (flag){
            case Flag.PICASSO:
                loadWithPicasso(imgUrl, target);
                break;
            case Flag.GLIDE:
                loadWithGlide(imgUrl, target);
                break;
        }
    }

    private void loadWithPicasso(String imgUrl, ImageView target){
        Picasso.with(context)
                .load(imgUrl)
                .resize(600, 600)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(target);
    }

    private void loadWithGlide(String imgUrl, ImageView target){
        Glide.with(context)
                .load(imgUrl)
                .override(600, 600)
                .centerCrop()
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(target);
    }

    public void clearGlideCache(){

    }
}
