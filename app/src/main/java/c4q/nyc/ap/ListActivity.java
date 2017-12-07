package c4q.nyc.ap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;

import c4q.nyc.ap.model.Numbers;

public class ListActivity extends AppCompatActivity {

    private SharedPreferences registerPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        registerEmail();



    }

    /**
     * get user email:
     */
    public void registerEmail(){
        Intent intent = getIntent();
        registerPrefs = getApplicationContext().getSharedPreferences(intent.getStringExtra(""), MODE_PRIVATE);
    }

    public void fragments(){
        ListFragment listFragment = new ListFragment();
    }


}
