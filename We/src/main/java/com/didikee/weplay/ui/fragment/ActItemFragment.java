package com.didikee.weplay.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.didikee.uilibs.utils.DisplayUtil;
import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

public class ActItemFragment extends BaseFragment {

    private ListView mListview;

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_act_item;
    }

    @Override
    protected void initView() {
        mListview = (ListView) content.findViewById(R.id.listView);
    }

    @Override
    protected void startFlow() {
        mListview.setAdapter(adapter);
    }

    private BaseAdapter adapter=new BaseAdapter() {
        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, final ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null){
                holder=new ViewHolder();
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_act,null);
                holder.tv_1= (TextView) convertView.findViewById(R.id.tv_1);
                holder.tv_2= (TextView) convertView.findViewById(R.id.tv_2);
                convertView.setTag(holder);
            }
            holder= (ViewHolder) convertView.getTag();
            holder.tv_1.setText("item 1 :"+position);
            holder.tv_2.setText("item 2 :"+position);
            holder.tv_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                    layoutParams.height= DisplayUtil.dp2px(parent.getContext(),80);
                    v.setLayoutParams(layoutParams);
                }
            });
            return convertView;
        }



    };
    private class ViewHolder{
        public TextView tv_1;
        public TextView tv_2;
    }


}
