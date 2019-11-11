package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:43

 *@Description:${adapter}
 **/public class MyAdapterc extends RecyclerView.Adapter<MyAdapterc.Holder> {
    List<Shop.DataBean.GridDataBean> list;
    Context context;

    public MyAdapterc(List<Shop.DataBean.GridDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.citem_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Glide.with(context)
                    .load(list.get(i).getImageurl())
                    .placeholder(R.drawable.ic_launcher_background)//占位图
                    .error(R.drawable.ic_launcher_foreground)//错误图
                    .priority(Priority.HIGH)//优先级
                    .into(((Holder)holder).imageView);
        holder.textc1.setText(list.get(i).getPrice());
        holder.textc2.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textc1,textc2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgge_c);
            textc1=itemView.findViewById(R.id.text_c1);
            textc2=itemView.findViewById(R.id.text_c2);

        }
    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        RecyclerView.ViewHolder viewHolder=null;
//        switch (i){
//            case 0:
//                View viewa=LayoutInflater.from(context).inflate(R.layout.aitem_layout,null);
//                viewHolder=new aHolder(viewa);
//                break;
//            case 1:
//                View viewb=LayoutInflater.from(context).inflate(R.layout.bitem_layout,null);
//                viewHolder=new bHolder(viewb);
//                break;
//            case 2:
//                View viewc=LayoutInflater.from(context).inflate(R.layout.citem_layout,null);
//                viewHolder=new aHolder(viewc);
//                break;
//        }
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        if (viewHolder instanceof aHolder){
//            Glide.with(context)
//                    .load(list.get(i).getHorizontalListData().get(i).getImageurl())
//                    .placeholder(R.drawable.ic_launcher_background)//占位图
//                    .error(R.drawable.ic_launcher_foreground)//错误图
//                    .priority(Priority.HIGH)//优先级
//                    .into(((aHolder)viewHolder).imageViea);
//        }else if (viewHolder instanceof bHolder){
//            Glide.with(context)
//                    .load(list.get(i).getVerticalListData().get(i).getImageurl())
//                    .placeholder(R.drawable.ic_launcher_background)//占位图
//                    .error(R.drawable.ic_launcher_foreground)//错误图
//                    .priority(Priority.NORMAL)//优先级
//                    .into(((bHolder)viewHolder).imageVieb);
//            ((bHolder)viewHolder).textb1.setText(list.get(i).getVerticalListData().get(i).getPrice());
//            ((bHolder)viewHolder).textb2.setText(list.get(i).getVerticalListData().get(i).getTitle());
//
//        }else if (viewHolder instanceof cHolder){
//            Glide.with(context)
//                    .load(list.get(i).getGridData().get(i).getImageurl())
//                    .placeholder(R.drawable.ic_launcher_background)//占位图
//                    .error(R.drawable.ic_launcher_foreground)//错误图
//                    .priority(Priority.NORMAL)//优先级
//                    .into(((cHolder)viewHolder).imageViec);
//            ((cHolder)viewHolder).textc1.setText(list.get(i).getVerticalListData().get(i).getPrice());
//            ((cHolder)viewHolder).textc2.setText(list.get(i).getVerticalListData().get(i).getTitle());
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//    class aHolder extends RecyclerView.ViewHolder {
//        ImageView imageViea;
//        public aHolder(@NonNull View itemView) {
//            super(itemView);
//            imageViea=itemView.findViewById(R.id.RecyclerView_a);
//        }
//    }
//    class bHolder extends RecyclerView.ViewHolder {
//        ImageView imageVieb;
//        TextView textb1,textb2;
//        public bHolder(@NonNull View itemView) {
//            super(itemView);
//            imageVieb=itemView.findViewById(R.id.RecyclerView_b);
//            textb1=itemView.findViewById(R.id.text_b1);
//            textb2=itemView.findViewById(R.id.text_b2);
//        }
//    }
//    class cHolder extends RecyclerView.ViewHolder {
//        ImageView imageViec;
//        TextView textc1,textc2;
//        public cHolder(@NonNull View itemView) {
//            super(itemView);
//            imageViec=itemView.findViewById(R.id.RecyclerView_c);
//            textc1=itemView.findViewById(R.id.text_c1);
//            textc2=itemView.findViewById(R.id.text_c2);
//        }
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (position==0){
//            return 0;
//        }else if (position==1){
//            return 1;
//        }else if (position==2){
//            return 2;
//        }
//        return -1;
//    }
}
