package com.css.gameattack.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.gameattack.R;
import com.css.gameattack.entity.Role;

import java.util.List;

/**
 * @author chenshanshan
 * @time 2019/6/28 10:10
 */
public class RoleAdapter extends RecyclerView.Adapter<RoleAdapter.RoleViewHolder> {
    private Context context;
    private int itemLayout;
    private List<Role> roles;
    private OnItemListener onItemListener;

    public RoleAdapter(Context applicationContext, int itemLayout, List<Role> roles,
                       OnItemListener onItemListener) {
        this.context = applicationContext;
        this.itemLayout = itemLayout;
        this.roles = roles;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RoleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.role_item, viewGroup, false);
        RoleViewHolder viewHolder = new RoleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RoleViewHolder viewHolder, final int i) {
        final Role role = roles.get(i);
        viewHolder.roleName.setText(role.getName());
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
        return roles.size();
    }

    class RoleViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView roleName;

        public RoleViewHolder(View view) {
            super(view);
            this.itemView = view.findViewById(R.id.roleItem);
            this.roleName = view.findViewById(R.id.roleName);
        }
    }
}
