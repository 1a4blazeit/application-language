package fdsa.application_language;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    private ArrayAdapter mArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mArrayAdapter = new ArrayAdapter(this, R.layout.listitem);
        //ListView list = (ListView)findViewById(R.id.list);
        //list.setAdapter(mArrayAdapter);

    }

    public void translate(View v) {
        TextView tv = (TextView)findViewById(R.id.edittext);
        String input = tv.getText().toString();
        request(v, input);

    }

    public void request(View v, String input) {
        final TextView mTextView = (TextView) findViewById(R.id.text);
        final String requestInput = input;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://translate.yandex.net/api/v1.5/tr/translate";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        }) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("key", "trnsl.1.1.20170902T070403Z.e466c5aac4f89eb0.3a3e5bd9db494e6d1838f1b672e8bea5c94fb35b");
                params.put("text", requestInput);
                params.put("lang", "en-fr");
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    }



