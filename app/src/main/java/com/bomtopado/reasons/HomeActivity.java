package com.bomtopado.reasons;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anderson on 06/03/2016.
 */
public class HomeActivity extends AppCompatActivity {
    private ListView listViewHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listViewHome = (ListView)findViewById(R.id.listViewHome);
        loadTop5Things();
    }

    private void loadTop5Things() {
        //String[] categories = new String[]{getString(R.string.health), getString(R.string.opponent), getString(R.string.evolution), getString(R.string.master), getString(R.string.trainig_partners)};
        List<HashMap<String, Object>> categories = new ArrayList<HashMap<String, Object>>();

        adicionaCategoria(R.string.health, R.string.health_description, categories);
        adicionaCategoria(R.string.opponent, R.string.opponent_description, categories);
        adicionaCategoria(R.string.evolution, R.string.evolution_description, categories);
        adicionaCategoria(R.string.master, R.string.master_description, categories);
        adicionaCategoria(R.string.trainig_partners, R.string.trainig_partners_description, categories);

        //Definindo os campos que serão utilizados
        String[] camposHashmap = new String[]{"titulo", "descricao"};

        //Definindo layout
        int layout = R.layout.categories;

        //Definindo os campos que serão utilizados
        int[] camposLayout = new int[]{R.id.categories_title, R.id.categories_description};

        SimpleAdapter adapter = new SimpleAdapter(this, categories, layout, camposHashmap, camposLayout);

        listViewHome.setAdapter(adapter);
    }

    private void adicionaCategoria(int titulo_resource, int descricao_resource, List<HashMap<String, Object>> categories) {
        adicionaCategoria(getString(titulo_resource), getString(descricao_resource), categories);
    }

    public void adicionaCategoria(String titulo, String descricao, List<HashMap<String, Object>> categories){
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("titulo", titulo);
        hashMap.put("descricao", descricao);
        categories.add(hashMap);
    }

    private class Categoria{

    }
}
