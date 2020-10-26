package com.css.customizeadapter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.customizeadapter.R;
import com.css.customizeadapter.entity.Dog;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {
    private Context context;
    private int itemLayout;
    private Dog[] dogList;
    private RecycleViewItemListener onItemClickListener;

    public DogAdapter(Context context, int itemLayout, Dog[] dogList, RecycleViewItemListener recycleViewItemListener) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.dogList = dogList;
        this.onItemClickListener = recycleViewItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.dog_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Dog dog = dogList[i];
        viewHolder.dogImage.setImageResource(dog.getImageResId());
        viewHolder.dogName.setText(dog.getName());
        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(viewHolder.itemView, i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dogList.length;
    }

//    @Override
//    public int getCount() {
//        return dogList.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return "";
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = null;
//        ViewHolder viewHolder = null;
//        //判断是否有溢出屏幕的view
//        if (convertView == null) {
//            //将布局文件转换为View
//            LayoutInflater layoutInflater = LayoutInflater.from(context);
//            view = layoutInflater.inflate(itemLayout, parent, false);
//            //创建缓存对象
//            ImageView imageView = view.findViewById(R.id.dogImage);
//            TextView textView = view.findViewById(R.id.dogName);
//            viewHolder = new ViewHolder(imageView, textView);
//            //将缓存对象与条目绑定起来
//            view.setTag(viewHolder);
//        } else {
//            view = convertView;
//            //取出缓存的控件
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        //获取数据源中的一个数据
//        Dog dog = dogList[position];
//        //把数据绑定到对应的控件上
//        viewHolder.imageView.setImageResource(dog.getImageResId());
//        viewHolder.textView.setText(dog.getName());
//        return view;
//    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public ImageView dogImage;
        public TextView dogName;
        public ViewHolder(View view) {
            super(view);
            this.itemView = view.findViewById(R.id.itemView);
            this.dogImage = view.findViewById(R.id.dogImage);
            this.dogName = view.findViewById(R.id.dogName);
        }
    }
}
