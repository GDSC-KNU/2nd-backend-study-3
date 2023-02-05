package com.backend3rd.BOGUdanyoKT.api

import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

@Component
class KakaoRestApiHelper (
        @Value("\${kakao_api_key}")
        val apiKey: String
        ){

    fun getKakaoApiFromAddress(roadFullAddr: String): Array<Float> {
        val apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query="
        var jsonString = ""
        var cordi: Array<Float> = arrayOf(0F, 0F)
        try {
            val address = URLEncoder.encode(roadFullAddr, "UTF-8")

            val obj = URL(apiUrl + address)

            val con: HttpURLConnection = obj.openConnection() as HttpURLConnection

            con.requestMethod = "GET"
            con.setRequestProperty("Authorization", "KakaoAK " + apiKey)
            con.setRequestProperty("content-type", "application/json")
            con.doOutput = true
            con.useCaches = false
            con.defaultUseCaches = false

            val rd = con.inputStream.bufferedReader()
            var docJson = StringBuffer()

            while(true){
                var line = rd.readLine()
                if(line == null) break
                docJson.append(line)
            }

            jsonString = docJson.toString()
            rd.close()
        }
        catch (e : UnsupportedEncodingException){
            e.printStackTrace()
        }
        catch (e: MalformedURLException){
            e.printStackTrace()
        }
        catch (e: IOException){
            e.printStackTrace()
        }
        catch (e: Exception){
            e.printStackTrace()
        }

        cordi = changeToJSON(jsonString)
        return cordi
    }

    fun changeToJSON(jsonString: String): Array<Float>{
        val parser = JSONParser()
        val document = parser.parse(jsonString) as JSONObject
        val jsonArray = document["documents"] as JSONArray
        val position = jsonArray[0] as JSONObject
        val x = position["x"].toString().toFloat()
        val y = position["y"].toString().toFloat()

        return arrayOf(x, y)
    }
}