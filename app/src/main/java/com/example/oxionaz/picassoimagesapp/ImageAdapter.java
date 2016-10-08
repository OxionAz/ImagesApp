package com.example.oxionaz.picassoimagesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.oxionaz.picassoimagesapp.image.ImageDownload;
import com.example.oxionaz.picassoimagesapp.image.ImageInteractor;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    private List<String> images_list;
    private ImageDownload imageDownload;

    public ImageAdapter(Context context, List<String> images_list){
        this.images_list = images_list;
        this.imageDownload = new ImageDownload(context);
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ImageHolder(item_view);
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        String image = images_list.get(position);
        imageDownload.load(ImageInteractor.Flag.GLIDE, image, holder.image);
    }

    @Override
    public int getItemCount() {
        return images_list.size();
    }

    static class ImageHolder extends RecyclerView.ViewHolder {

        protected ImageView image;

        public ImageHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_item);
        }
    }
}
