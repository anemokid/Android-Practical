package c4q.nyc.ap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ListAdapter;

import c4q.nyc.ap.model.NumberAdapter;
import c4q.nyc.ap.model.Numbers;

/**
 * Created by c4q on 12/6/17.
 */

public class ListActivityFragments extends ListFragment {

    private OnListItemSelectedListener onListItemSelectedListener;


    public interface OnListItemSelectedListener {
        void onListItemSelected(Number selectedNumber);
    }

    @Override
    public void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Numbers[] numbers = new Numbers[]{
                new Numbers(1),
                new Numbers(2),
                new Numbers(3),
                new Numbers(4),
                new Numbers(5),
                new Numbers(6),
                new Numbers(7),
                new Numbers(8),
                new Numbers(9),
                new Numbers(10),
                new Numbers(11)
        };
        setListAdapter((ListAdapter) new NumberAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, numbers));

    }
    @Override
    public void setListAdapter(ListAdapter adapter) {
        super.setListAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity ){
        super.onAttach(activity);
    }

}
