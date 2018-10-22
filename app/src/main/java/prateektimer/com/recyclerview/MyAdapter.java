package prateektimer.com.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ImageViewHolder> {
    List<Integer> images;
    List<String> textemtion;
    private Context mContext;

    public MyAdapter(Context context, List<Integer> img, List<String> emotion) {
        images = img;
        textemtion = emotion;
        mContext = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.linear, viewGroup, false);
        ImageViewHolder imageholder = new ImageViewHolder(view);


        return imageholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, final int i) {
        int id = images.get(i);
        String text = textemtion.get(i);
        imageViewHolder.smileys.setImageResource(id);
        imageViewHolder.ids.setText(text);
        imageViewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    images.remove(i);
                    notifyItemRangeChanged(i, images.size());
                    notifyItemRemoved(i);

                    textemtion.remove(i);
                    notifyItemRangeChanged(i, textemtion.size());
                    notifyItemRemoved(i);
                } catch (Exception e) {
                } finally {
                    int count = getItemCount();
                    if (count == 0) {
                        MainActivity.i.setVisibility(ImageView.VISIBLE);
                    }
                }


            }
        });


    }


    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView smileys, remove, add;
        public TextView ids;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            smileys = itemView.findViewById(R.id.imageView1);
            ids = itemView.findViewById(R.id.textView1);
            remove = itemView.findViewById(R.id.remove);


        }


    }

}
