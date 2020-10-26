package com.css.gameattack.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.gameattack.R;
import com.css.gameattack.entity.Weapon;

import java.util.List;

/**
 * @author chenshanshan
 * @time 2019/6/28 10:06
 */
public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder> {
    private Context context;
    private int itemLayout;
    private List<Weapon> weaponList;
    private OnItemListener onItemListener;

    public WeaponAdapter(Context context, int itemLayout, List<Weapon> weaponList, OnItemListener onItemListener) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.weaponList = weaponList;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public WeaponAdapter.WeaponViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.weapon_item, viewGroup, false);
        WeaponViewHolder viewHolder = new WeaponViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final WeaponAdapter.WeaponViewHolder viewHolder, final int i) {
        final Weapon weapon = weaponList.get(i);
        viewHolder.weaponIcon.setImageResource(weapon.getIcon());
        viewHolder.weaponName.setText(weapon.getName());
        viewHolder.weaponDesc.setText(weapon.getDesc());
        if (onItemListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListener.onItemClick(viewHolder.itemView, i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return weaponList.size();
    }

    class WeaponViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public ImageView weaponIcon;
        public TextView weaponName;
        public TextView weaponDesc;
        public WeaponViewHolder(View view) {
            super(view);
            this.itemView = view.findViewById(R.id.weaponItem);
            this.weaponIcon = view.findViewById(R.id.weaponIcon);
            this.weaponName = view.findViewById(R.id.weaponName);
            this.weaponDesc = view.findViewById(R.id.weaponDesc);
        }
    }
}
