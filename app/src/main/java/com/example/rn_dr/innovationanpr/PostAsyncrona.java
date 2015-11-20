package com.example.rn_dr.innovationanpr;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by Sadainer Hernandez on 09/03/2015.
 */
public class PostAsyncrona extends AsyncTask<String, Integer, String> {

    /* private String Url;*/
    private String mData = null;

    public PostAsyncrona(String data) {
        mData = data;
    }

    public void execute() {
        // TODO Auto-generated method stub
    }

   /* public void setUrl(String url) {
        Url = url;
    }*/

    @Override
    protected String doInBackground(String... params) {
        String resul = new String("");
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(params[0]);
        post.setHeader("content-type", "application/json");
        try
        {
            StringEntity entity = new StringEntity(mData);
            post.setEntity(entity);
            HttpResponse resp = httpClient.execute(post);
            String respStr = EntityUtils.toString(resp.getEntity());
            resul= respStr;
        }
        catch(Exception ex)
        {
            resul = "Error";}
        Log.d("Rafael: ",resul);
        return resul;
    }

    public void onPostExecute(String result) {
        Log.d("Rafael: ",result);
        super.onPostExecute(result);

    }
}
