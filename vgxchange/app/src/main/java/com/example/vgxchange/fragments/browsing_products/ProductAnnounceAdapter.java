package com.example.vgxchange.fragments.browsing_products;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vgxchange.MainActivity;
import com.example.vgxchange.R;
import com.example.vgxchange.api.dto.ProductAnnounce;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductAnnounceAdapter extends RecyclerView.Adapter<ProductAnnounceAdapter.ProductViewHolder> {

    List<ProductAnnounce> products = new ArrayList<>();
    Context context;


    public ProductAnnounceAdapter(Context context, List<ProductAnnounce> products) {

        this.products = products;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_product, parent, false);
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductAnnounce product = products.get(position);
        holder.bind(product);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CLICK CLICK sur le jeu : " + product.getGame().getName(), Toast.LENGTH_SHORT).show();
                fragmentJump(product);

            }
        });
    }

    private void fragmentJump(ProductAnnounce selectedProduct) {
        DetailProductFragment detProdFrag= new DetailProductFragment(selectedProduct);


        switchContent(R.id.detailProductAnnounce, detProdFrag);
    }

    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            Fragment frag = fragment;
            mainActivity.switchContent(id, frag);
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView name, description, price, announcerLogin, parutionDate;
        ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            name = itemView.findViewById(R.id.product_name_txt);
            price = itemView.findViewById(R.id.product_price_txt);
            description = itemView.findViewById(R.id.product_description_txt);
            announcerLogin = itemView.findViewById(R.id.product_announcer_login_txt);
            parutionDate = itemView.findViewById(R.id.product_parution_date_txt);
            productImage = itemView.findViewById(R.id.productImage);
        }


        public void bind(ProductAnnounce product) {
            if (product.getGame() != null) {
                name.setText(product.getGame().getName());
            }
            price.setText(String.valueOf(product.getPrice()));
            announcerLogin.setText(product.getAnnouncer().getLogin());
            parutionDate.setText(product.getParution());
            setProductImage(product.getPhotoLink());
        }


        public void setProductImage(String url) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = (InputStream) new URL(url).getContent();
                        Drawable d = Drawable.createFromStream(is, url);
                        productImage.setImageDrawable(d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
