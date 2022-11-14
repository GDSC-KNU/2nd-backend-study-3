package com.backend3rd.BOGUdanyo.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Component
public class KakaoRestApiHelper {
    @Value("${KAKAO_API_KEY}")
    String apiKey;
    public float [] getKakaoApiFromAddress(String roadFullAddr) throws ParseException {
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        String jsonString = null;
        float [] coordi;

        try {
            roadFullAddr = URLEncoder.encode(roadFullAddr, "UTF-8");

            String addr = apiUrl + "?query=" + roadFullAddr;

            URL url = new URL(addr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer docJson = new StringBuffer();

            String line;

            while ((line=rd.readLine()) != null) {
                docJson.append(line);
            }

            jsonString = docJson.toString();
            rd.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        coordi = changeToJSON(jsonString);
        return coordi;
    }

    private float[] changeToJSON(String jsonString) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject document = (JSONObject) parser.parse(jsonString);
        JSONArray jsonArray = (JSONArray) document.get("documents");
        JSONObject position = (JSONObject) jsonArray.get(0);
        float x = Float.parseFloat((String) position.get("x"));
        float y = Float.parseFloat((String) position.get("y"));

        return new float[]{x, y};

    }

}
