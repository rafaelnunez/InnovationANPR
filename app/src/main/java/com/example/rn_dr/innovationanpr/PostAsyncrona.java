package com.example.rn_dr.innovationanpr;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Sadainer Hernandez on 09/03/2015.
 */
public class PostAsyncrona extends AsyncTask<String, Integer, Boolean> {

    private String mData = null;
    /*private Context cnt = null;*/
   /* private ProgressDialog progressDialog;*/

    public PostAsyncrona(String data) {
        mData = data;
    }
   /* public void SetContext(Context data) {
        cnt = data;
    }*/

    public void execute() {
        // TODO Auto-generated method stub
    }

    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {

        InputStream in = entity.getContent();
        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n > 0) {
            byte[] b = new byte[4096];
            n = in.read(b);
            if (n > 0) out.append(new String(b, 0, n));
        }
        return out.toString();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

       /* progressDialog = new ProgressDialog(cnt);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Enviando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.show();*/
    }
    @Override
    protected Boolean doInBackground(String... params) {

        boolean resul = true;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(params[0]);
        post.setHeader("content-type", "application/json");

        try
        {
            StringEntity entity = new StringEntity(mData);
            post.setEntity(entity);
            HttpResponse resp = httpClient.execute(post);
            String respStr = EntityUtils.toString(resp.getEntity());
        }
        catch(Exception ex)
        {resul = false;}

        return resul;
    }

    public void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        /*progressDialog.dismiss();*/
    }
}
