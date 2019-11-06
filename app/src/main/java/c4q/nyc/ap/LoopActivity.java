package c4q.nyc.ap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);


        createViews();
    }

    public void createViews(){
        textView = (TextView)findViewById(R.id.loop_textview);
    }

    private class NewClass extends AsyncTask<Integer, Integer, Integer> {

        private int starting;

        public NewClass(int n){
            this.starting = n;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Start");

        }

        /**
         * write a loop that starts at the value passed into the AsyncTask after running
         * execute(0) and ends at 100,000
         * - for every loop run publishProcess()
         * @param value
         * @return
         */
        @Override
        protected Integer doInBackground(Integer[] value) {
            int count = value.length;
            Integer[] data = new Integer[value.length];
            //int values = value[]
            // / value.length = 100000;
            // int tValue = value.length;
            for(int i=0 ;i <= 100000;i++){
                try {
                    Thread.sleep(1000);
                    publishProgress(i); // Invokes onProgressUpdate()
                } catch (InterruptedException e) {
                }
            }
            return null;

           // publishProgress(Integer value);


        }
        /**
         * set the text of the text - view to "Loops completed: " ,
         * followed by the number recieved from doInBackGround()
         * @param progress
         */
        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);

            //int prog = pt

            textView.setText("Loops completed: " + progress);

        }

        /**
         * - set the text of the text - view to "Loops completed: " ,
         * followed by the number recieved from doInBackGround()
         * @param integer
         */
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            textView.setText("Loops completed: " + integer);
            // then create a new intent to an activity: LoginActivity
            Intent startLoginActivity = new Intent(LoopActivity.this, LoginActivity.class);
            startActivity(startLoginActivity);
        }

        public void main(String[] args) {
            NewClass loop = new NewClass(0);

            loop.execute(0);
        }
    }
}
