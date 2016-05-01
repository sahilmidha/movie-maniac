package me.sahilmidha.myapps.movie_maniac.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.sahilmidha.myapps.movie_maniac.R;
import me.sahilmidha.myapps.movie_maniac.service.model.Movie;

/**
 * Created by Sahil Midha on 3/2/2016.
 * A customer ArrayAdapter which takes Movies Objects to help populate data in GridView
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {
    private static final String LOG_TAG = MoviesAdapter.class.getSimpleName();
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param movies A List of Movies objects to display in a list
     */
    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     *                    (search online for "android view recycling" to learn more)
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the Movies object from the ArrayAdapter at the appropriate position
        Movie movies = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.image_layout, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.id_image_view_movie_list);
        imageView.setBackgroundColor(Color.rgb(210, 210, 210));
        String poster_url = (String)getContext().getString(R.string.poster_url);
        poster_url = poster_url.concat(movies.getPosterPath());
        Picasso.with(getContext())
                .load(poster_url)
                .resize(185,278)
                .centerCrop()
                .onlyScaleDown()
                .into(imageView);

        return convertView;
    }
}
