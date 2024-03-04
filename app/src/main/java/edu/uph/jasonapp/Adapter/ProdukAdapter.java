package edu.uph.jasonapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.uph.jasonapp.Model.Produk;
import edu.uph.jasonapp.R;

public class ProdukAdapter extends ArrayAdapter<Produk> {

    private ArrayList<Produk> ProdukArrayList;
    Context context;

    public ProdukAdapter(ArrayList<Produk> produkArrayList, Context context1) {
        super(context1, R.layout.item_list_layout, produkArrayList);
        ProdukArrayList = produkArrayList;
        this.context = context1;
    }

    private static class MyViewHolder{
        ImageView imageProduk;
        TextView txtNamaProduk;
        TextView txtHargaProduk;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produk produk = getItem(position);
        final View result;

        MyViewHolder myViewHolder;
        if (convertView == null) {

            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);

            myViewHolder.imageProduk = (ImageView) convertView.findViewById(R.id.imageProduk);
            myViewHolder.txtNamaProduk = (TextView) convertView.findViewById(R.id.txtNamaProduk);
            myViewHolder.txtHargaProduk = (TextView) convertView.findViewById(R.id.txtHargaProduk);

            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        result = convertView;
        myViewHolder.imageProduk.setImageResource(produk.getGambarProduk());
        myViewHolder.txtHargaProduk.setText("IDR. "+ produk.getHargaProduk());
        myViewHolder.txtNamaProduk.setText(produk.getNamaProduk());
        return result;
    }
}
