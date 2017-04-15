//package com.example.khj.kku_myhome_helper.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.khj.kku_myhome_helper.R;
//
//import java.util.ArrayList;
//
///**
// * Created by KHJ on 2017-04-06.
// */
//
//public class myRoomFm_Ad extends BaseAdapter {
//
//
//    private ArrayList<String> myList;
//    private Context mContext;
//    private LayoutInflater mLiInflater;
//    private int mResource;
//
//    public myRoomFm_Ad(Context context,int viewRe) {
//        this.mContext = context;
//        this.mLiInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.mResource =viewRe;
//        myList = new ArrayList<String>();
//        myList.add("고기");
//        myList.add("냠냠");
//        myList.add("맛있다");
//        myList.add("오구 오구");
//    }
//
//    @Override
//    public int getCount() {
//        return myList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return myList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        viewSetter viewRe;
//        if ( convertView == null ) {
//            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.room_list_item, parent, false);
//
//            convertView = mLiInflater.inflate(mResource,parent, false);
//            viewRe = new viewSetter();
//            viewRe.mImage = (ImageView) convertView.findViewById(R.id.lv_image);
//            viewRe.tvTitle = (TextView) convertView.findViewById(R.id.lv_title);
//            viewRe.tvContentes = (TextView) convertView.findViewById(R.id.lv_contents);
//
//            convertView.setTag(viewRe);
//        } else {
//            viewRe = (viewSetter) convertView.getTag();
//        }
//
//        viewRe.tvTitle.setText(myList.get(position));
//
//        viewRe.tvTitle.setOnClickListener(new TextView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), ((TextView) v).getText() + "선택함.", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        return convertView;
//    }
//    public class viewSetter {
//        public LinearLayout lL;
//        public ImageView mImage;
//        public TextView tvTitle;
//        public TextView tvContentes;
//    }
//}
//
