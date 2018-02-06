package t.test.dogs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Owner on 2/2/2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>{

    private List<String> mImages;
    private int mLayout;
    private Context mContext;

    public ImagesAdapter(List<String> mImages, int mLayout, Context mContext) {
        this.mImages = mImages;
        this.mLayout = mLayout;
        this.mContext = mContext;
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;

        public ImagesViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.imageView_images);
        }
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        return new ImagesAdapter.ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mImages.get(position))
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }



}
