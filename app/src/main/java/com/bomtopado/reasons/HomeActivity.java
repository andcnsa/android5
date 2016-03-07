package com.bomtopado.reasons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bomtopado.reasons.model.Categoria;

import java.io.Serializable;
import java.util.ArrayList;
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
        List<Categoria> categories = new ArrayList<Categoria>();

        categories.add(new Categoria(this, R.string.health, R.string.health_description, R.string.health_text, R.drawable.ic_health, R.drawable.photo_health));
        categories.add(new Categoria(this, R.string.opponent, R.string.opponent_description, R.string.opponent_text, R.drawable.ic_opponent, R.drawable.photo_opponent));
        categories.add(new Categoria(this, R.string.evolution, R.string.evolution_description, R.string.evolution_text, R.drawable.ic_evolution, R.drawable.photo_evolution));
        categories.add(new Categoria(this, R.string.training_partners, R.string.training_partners_description, R.string.opponent_text, R.drawable.ic_training_partner, R.drawable.photo_training_partner));
        categories.add(new Categoria(this, R.string.master, R.string.master_description, R.string.master_text, R.drawable.ic_master, R.drawable.background));

        //Definindo layout
        int layout = R.layout.categories;

        listViewHome.setAdapter(new CategoriaAdapter(this, categories));
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Categoria c = (Categoria)listViewHome.getAdapter().getItem(position);
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                intent.putExtra("CATEGORIA", c);
                startActivity(intent);
            }
        });
    }



    /**
     * @author Anderson
     */
    private class CategoriaAdapter extends BaseAdapter{
        private Context context;
        private List<Categoria> categorias;

        private LayoutInflater inflater;
        public CategoriaAdapter(Context context, List<Categoria> categorias){
            this.categorias = categorias;
            this.context = context;
        }

        @Override
        public int getCount() {
            return categorias.size();
        }

        @Override
        public Object getItem(int position) {
            return categorias.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Categoria categoria = categorias.get(position);
            View row;
            if(convertView == null) {
                inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.categories, parent, false);
            }
            else {
                row = convertView;
            }

            TextView title = (TextView)row.findViewById(R.id.categories_title);
            title.setText(categoria.getTitulo());
            TextView description = (TextView)row.findViewById(R.id.categories_description);
            description.setText(categoria.getDescricao());

            ImageView imagem = (ImageView)row.findViewById(R.id.categories_image);

            if(categoria.getImagem() >= 0)
                imagem.setImageDrawable(getDrawable(categoria.getImagem()));

            return row;
        }
    }
}
