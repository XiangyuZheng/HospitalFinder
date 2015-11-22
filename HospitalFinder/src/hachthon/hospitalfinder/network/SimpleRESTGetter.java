
package hachthon.hospitalfinder.network;

import hachthon.hospitalfinder.util.JsonHospitalParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SimpleRESTGetter {
    public static void queryHospitalInfo(final String url, final OnRESTCallbackListener listener) {
        final StringBuilder sb = new StringBuilder();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet(url);
                    HttpResponse response = null;
                    BufferedReader rd = null;
                    String line = null;
                    response = client.execute(request);
                    rd = new BufferedReader(new InputStreamReader(response.getEntity()
                            .getContent()));
                    while ((line = rd.readLine()) != null) {
                        sb.append(line);
                    }
                    // constructs hospital info list using data in response.
                    listener.onSuccess(JsonHospitalParser.parseJsonToHospitalList(sb.toString()));
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
    }
}
