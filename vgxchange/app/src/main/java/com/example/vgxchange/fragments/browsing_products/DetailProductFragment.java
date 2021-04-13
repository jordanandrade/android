package com.example.vgxchange.fragments.browsing_products;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.example.vgxchange.R;
import com.example.vgxchange.api.dto.ProductAnnounce;

public class DetailProductFragment extends Fragment implements View.OnClickListener{


    ProductAnnounce productToShow;
    public DetailProductFragment(ProductAnnounce selectedProduct)
    {
        productToShow = selectedProduct;
    }

    public static DetailProductFragment newInstance(ProductAnnounce selectedProduct) {
        DetailProductFragment fragment = new DetailProductFragment(selectedProduct);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.detail_product_announce, container, false);
        return view;

    }


    @Override
    public void onClick(View v) {

    }




}
