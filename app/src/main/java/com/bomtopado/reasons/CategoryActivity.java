package com.bomtopado.reasons;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bomtopado.reasons.model.Categoria;

/**
 * Activity das categorias
 */
public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        verificaExtra();
    }

    /**
     * Verifica se o activity tem extra do tipo categoria e preenche com o objeto serializado
     */
    private void verificaExtra() {
        TextView titulo_text_view = (TextView)findViewById(R.id.category_title_text_view);
        TextView texto_text_view = (TextView)findViewById(R.id.category_text_text_view);
        ImageView icon_image_view = (ImageView)findViewById(R.id.category_icon_image_view);
        ImageView background_image_view = (ImageView)findViewById(R.id.category_background_image_view);
        Categoria c = (Categoria)getIntent().getSerializableExtra("CATEGORIA");
        titulo_text_view.setText(c.getTitulo());
        texto_text_view.setText(c.getTexto());
        icon_image_view.setImageDrawable(getDrawable(c.getImagem()));
        try {
            background_image_view.setImageDrawable(getDrawable(c.getFoto()));
        }catch(Exception e){

        }
    }

    public void closeActivity(View view) {
        super.onBackPressed();
    }
}
