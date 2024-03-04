package edu.uph.jasonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.uph.jasonapp.Adapter.ProdukAdapter;
import edu.uph.jasonapp.Model.Produk;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Produk> produkArrayList;
    private static ProdukAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        produkArrayList = new ArrayList<>();

        Produk produk1 = new Produk("Kacang Garuda 375g", 37000, R.drawable.garuda);
        Produk produk2 = new Produk("Aqua 150g", 7000, R.drawable.aqua);
        Produk produk3 = new Produk("Hit 100g", 35000, R.drawable.hit);
        Produk produk4 = new Produk("Indomie 150g", 2000, R.drawable.indomie);
        Produk produk5 = new Produk("Pocari 350g", 10000, R.drawable.pocari);
        Produk produk6 = new Produk("Sania 500g", 50000, R.drawable.sania);
        Produk produk7 = new Produk("Tropical 250g", 55000, R.drawable.tropical);
        Produk produk8 = new Produk("Ultra 120g", 37000, R.drawable.ultra);

        produkArrayList.add(produk1);
        produkArrayList.add(produk2);
        produkArrayList.add(produk3);
        produkArrayList.add(produk4);
        produkArrayList.add(produk5);
        produkArrayList.add(produk6);
        produkArrayList.add(produk7);
        produkArrayList.add(produk8);

        adapter = new ProdukAdapter(produkArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Use the 'position' parameter to get the item from the adapter
                Produk selectedProduk = (Produk) adapter.getItem(position);

                // Now you can access the properties of the selected item
                Toast.makeText(MainActivity.this, "Nama produk yang dipilih: " + selectedProduk.getNamaProduk(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
};