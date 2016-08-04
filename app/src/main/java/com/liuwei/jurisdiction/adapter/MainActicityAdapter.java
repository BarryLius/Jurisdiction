package com.liuwei.jurisdiction.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.liuwei.jurisdiction.R;
import com.liuwei.jurisdiction.utils.JurisdictionUtils;
import com.liuwei.jurisdiction.utils.SystemActivityUtils;
import com.liuwei.jurisdiction.utils.ToastUtil;

import java.util.List;

/**
 * Created by lw on 2016/8/4.
 */
public class MainActicityAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> list;

    public MainActicityAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_list_main, null);
            mViewHolder = new ViewHolder();
            mViewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            mViewHolder.scChoice = (SwitchCompat) convertView.findViewById(R.id.sc_choice);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tvContent.setText(list.get(position));
        mViewHolder.scChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (position) {
                    case 0:
                        if (isChecked) {
                            JurisdictionUtils.applySDCardStorage(activity);
                        }
                        break;
                    case 1:
                        if (isChecked) {
                            if (JurisdictionUtils.applyCamera(activity)) {
                                SystemActivityUtils.camera(activity);
                            } else {
                                ToastUtil.toast(activity, "请允许使用相机权限");
                            }
                        }
                        break;
                    case 2:
                        ToastUtil.toast(activity, "2");
                        if (isChecked) {
                            if (JurisdictionUtils.applyCallPhone(activity)) {
                                SystemActivityUtils.callPhone(activity, "10000");
                            } else {
                                ToastUtil.toast(activity, "请允许使用拨号权限");
                            }
                        }
                        break;
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView tvContent;
        SwitchCompat scChoice;
    }
}
