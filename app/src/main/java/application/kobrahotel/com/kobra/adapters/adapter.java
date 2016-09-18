package application.kobrahotel.com.kobra.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import application.kobrahotel.com.kobra.Models.Services;
import application.kobrahotel.com.kobra.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class adapter extends ArrayAdapter<Services> {

    private Context context;
    private List<Services> servicesList;

    @Bind(R.id.name) TextView name;
    @Bind(R.id.price) TextView price;
    @Bind(R.id.img) ImageView img;

    public adapter(Context context, int resource, List<Services> objects) {
        super(context, resource, objects);
        this.context = context;
        this.servicesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_file, parent, false);
        Services services = servicesList.get(position);

        ButterKnife.bind(this, view);

        name.setText(services.getName());
        name.setTextColor(Color.parseColor("#000000"));

        price.setText("R$" +services.getPrice());
        price.setTextColor(Color.parseColor("#000000"));

        Picasso.with(getContext()).load(services.getImage()).resize(80,70).into(img);

        return view;
    }

}