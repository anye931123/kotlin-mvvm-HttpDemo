package com.example.anye.photogallery.utils;

import android.net.Uri;
import android.util.Log;

import com.example.anye.photogallery.data.GalleryItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HttpUtils {

    public static byte[] buffer=new byte[1024];
    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " + urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }
    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<GalleryItem> fetchItems(){
        List<GalleryItem> items=new ArrayList();
        try {
            String url= Uri.parse("http://image.baidu.com/channel/listjson")
                    .buildUpon()
                    .appendQueryParameter("pn","0")
                    .appendQueryParameter("rn","30")
                    .appendQueryParameter("tag1","明星")
                    .appendQueryParameter("tag2","全部")
                    .appendQueryParameter("ie","utf8")
                    .build().toString();

            String jsonString=getUrlString(url);

            JSONObject jsonBody=new JSONObject(jsonString);
            parseItems(items,jsonBody);
        }catch (IOException ioe){
            Log.e(TAG,"Failed to fetch items$ioe");
        }catch (JSONException je){
            Log.e(TAG,"Failed to parse JSON $je");
        }

        return items;
    }

    private void parseItems(List<GalleryItem> items,JSONObject jsonBody) {
        JSONArray photosArray= null;
        try {
            photosArray = jsonBody.getJSONArray("data");

            for (int i=0;i<photosArray.length();i++){
                JSONObject photoJsonObject=photosArray.getJSONObject(i);
                Log.e("hahahahahhhheh",photoJsonObject.toString());
                if(photoJsonObject.isNull("id")){
                    continue;
                }
                GalleryItem item=new GalleryItem();
                item.setMId(photoJsonObject.getString("id"));
                item.setMCaption(photoJsonObject.getString("desc"));
                item.setMUrl(photoJsonObject.getString("image_url"));
                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }



}
