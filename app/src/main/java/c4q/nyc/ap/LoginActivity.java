package c4q.nyc.ap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/*
Write code using SharedPreferences so that when the checkbox is ticked,
and the button is clicked, it will store the values in the two EditTexts
and the status of the checkbox, and load that data the next time that activity is opened. */

public class LoginActivity extends AppCompatActivity {

    // a constant variable that exists for the whole activity that we'll be using several times
    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";

    private SharedPreferences login;
    private EditText userEmailEditText;
    private EditText userPasswordEditText;
    private CheckBox saveDataCheckBox;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createViews();

        // this gives us access to shared preferences using the key:
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

    }

    /**
     * createsViews:
     */
    public void createViews(){
        userEmailEditText = (EditText)findViewById(R.id.user_email_edit_text);
        userPasswordEditText = (EditText)findViewById(R.id.user_password_edit_text);
        saveDataCheckBox = (CheckBox)findViewById(R.id.save_data_checkbox);
        sendButton = (Button)findViewById(R.id.sendButton);

        sendButton();
        forgetMeNot();
    }

    /**
     * forgetMeNot(): method that checks if a user has clicked the checkbox in order to remember
     * to store and reshow thier data
     */
    public void forgetMeNot(){

        // If user clicks remember me box : they expect their information to be autofilled in once they return to the app
        if (login.getBoolean("isChecked", false)) {
            userEmailEditText.setText(login.getString("username", null));
            userPasswordEditText.setText(login.getString("password", null));
            saveDataCheckBox.setChecked(login.getBoolean("isChecked", false));
        }

        // to store username + password into the edit texts for future reference:
        SharedPreferences.Editor editor = login.edit();

        if(saveDataCheckBox.isChecked()){
            // to store the values into the editor:
            editor.putString("username", userEmailEditText.getText().toString());
            editor.putString("password", userPasswordEditText.getText().toString());
            editor.putBoolean("isChecked", saveDataCheckBox.isChecked());
            editor.commit(); // stores these values immediately
        } else {
            editor.putBoolean("isChecked", saveDataCheckBox.isChecked());
            editor.commit();
        }

    }

    /**
     * sendButton(): Write logic in the onClick for the button that checks if the user has an
     * email address of “user@aol.com”, and a password of “password1234”.
     * If both values match, write an intent that sends the value of the email address
     * entered (with an extra) to another activity called “ListActivity”.
     */
    public void sendButton(){
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to store user input :
                String checkUser = "user" + userEmailEditText.getText().toString();
                String checkPass = "password" + userPasswordEditText.getText().toString();

                String email = "user@aol.com";
                String password = "password1234";

                if( email.equalsIgnoreCase(login.getString(checkUser, null)) && password.equalsIgnoreCase(login.getString(checkPass, null))){
                    Toast.makeText(getApplicationContext(), "Authentication Successful!", Toast.LENGTH_SHORT).show();

                    Intent startListActivity = new Intent(LoginActivity.this, ListActivity.class);
                    startListActivity.putExtra("currentUser", userEmailEditText.getText().toString());
                    startActivity(startListActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Authentication Unsuccesful .. Please ee-enter username and password", Toast.LENGTH_SHORT).show();
                }
            } // ends onlick method.
        }); // ends set on click method
    } // ends log in activity
}
