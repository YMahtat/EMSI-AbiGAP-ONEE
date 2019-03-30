package org.hachimi.gapAnalysis.utilities;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RESTfulJSON 
{

    public static JSONObject getPostRequest(String body) throws IOException, ParseException
    {
        URL API_url = new URL("https://ussouthcentral.services.azureml.net/workspaces/3bcd00c03c1640e99c32bc8ccb345214/services/bb364fa877a049898ac598acecd307ef/execute?api-version=2.0&format=swagger");
        HttpURLConnection API_conn = (HttpURLConnection)API_url.openConnection();
        API_conn.setDoOutput(true);
        API_conn.setRequestMethod("POST");
        API_conn.addRequestProperty("Authorization", "Bearer O8Sblh2tfGbm6St7jUcu+eHQOn9fOtoOkwDd2AMX5SRK2GmN2urOxKP/i+vaeJ911QF9HIG0OJ/aFy7O17ywKQ==");
        API_conn.addRequestProperty("Accept", "application/json");
        API_conn.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
        String requestBody = body;
        OutputStream os = API_conn.getOutputStream();
        os.write(requestBody.getBytes("UTF-8"));
        os.close();
        API_conn.connect();
        int API_responseCode = API_conn.getResponseCode();
        if(API_responseCode == 200)
        {
            // read the response
            InputStream in = new BufferedInputStream(API_conn.getInputStream());
            String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            JSONParser parseRequest = new JSONParser();
            JSONObject jsonRequest = (JSONObject)parseRequest.parse(result);
            return jsonRequest;
        }
        else
        {
            return null;
        }

    }
}