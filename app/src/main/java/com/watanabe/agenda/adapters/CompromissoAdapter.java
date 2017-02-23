package com.watanabe.agenda.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.watanabe.agenda.R;
import com.watanabe.agenda.model.Compromisso;
import com.watanabe.agenda.model.StatusCompromisso;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompromissoAdapter extends ArrayAdapter<Compromisso> {

    private static class ViewHolder{
        ImageView status;
        TextView titulo;
        TextView hora;
    }

    public CompromissoAdapter(Context context, List objects) {
        super(context, R.layout.compromisso_item, objects);
    }

    public CompromissoAdapter(Context context, Compromisso[] objects) {
        super(context,  R.layout.compromisso_item, objects);
    }

    private static Map<StatusCompromisso, Integer> MAP_STATUS = getMapStatus();

    private static Map<StatusCompromisso,Integer> getMapStatus() {
        Map<StatusCompromisso,Integer> map = new HashMap<StatusCompromisso, Integer>();
        map.put(StatusCompromisso.LONGE, R.drawable.status_longe);
        map.put(StatusCompromisso.PERTO, R.drawable.status_perto);
        map.put(StatusCompromisso.ATRASADO, R.drawable.status_atrasado);
        return map;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Compromisso compromisso = (Compromisso) getItem(position);

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.compromisso_item, parent, false);

            viewHolder.status = (ImageView) convertView.findViewById(R.id.status_compromisso);
            viewHolder.titulo = (TextView) convertView.findViewById(R.id.titulo_compromisso);
            viewHolder.hora = (TextView) convertView.findViewById(R.id.hora_compromisso);


            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titulo.setText(compromisso.titulo);
        viewHolder.hora.setText(String.format("às: %1s",new SimpleDateFormat("HH:mm").format(compromisso.data)));
        viewHolder.status = compromisso.status != null ?
                getStatusImage(compromisso.status, viewHolder.status, getContext()) :
                getStatusImage(StatusCompromisso.LONGE, viewHolder.status, getContext());

        return convertView;
    }

    private ImageView getStatusImage(StatusCompromisso status, ImageView imageView, Context context) {
        imageView.setImageDrawable(ContextCompat.getDrawable(context, MAP_STATUS.get(status)));
        return imageView;
    }
}
