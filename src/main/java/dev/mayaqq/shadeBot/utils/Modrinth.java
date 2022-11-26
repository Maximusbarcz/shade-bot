package dev.mayaqq.shadeBot.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Modrinth {
    public static OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    public static HashMap<String, String>  usrDat(String userId) {
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/user/" + userId)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject json = new JSONObject(response.body().string());
            HashMap<String, String> data = new HashMap<>();
            data.put("username", json.getString("username"));
            data.put("avatar", json.getString("avatar_url"));
            data.put("bio", json.getString("bio"));
            data.put("id", json.getString("id"));
            data.put("name", json.getString("name"));
            data.put("role", json.getString("role"));
            data.put("downloads", getDownloads(userId).toString());
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Integer getDownloads(String userId) {
        //returns users total downloads
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/user/" + userId + "/projects")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());
            int downloads = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                downloads += jsonObject.getInt("downloads");
            }
            return(downloads);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static ArrayList<String> getProjects(String userId) {
        //returns array of users projects
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/user/" + userId + "/projects")
                .method("GET", null)
                .build();
        ArrayList<String> projects = new ArrayList<>();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                projects.add(jsonObject.getString("title"));
            }
            return projects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projects;
    }
    public static HashMap<String, String> getRandomProject() {
        //returns random project
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/search?index=newest&limit=100&facets=[[\"project_type:mod\"]]")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            Random rand = new Random();
            ArrayList<String> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("hits");
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getJSONObject(i).getString("slug"));
            }
            return getProjectInfo(list.get(rand.nextInt(list.size())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static HashMap<String, String> getProjectInfo(String slug) {
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/project/" + slug)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            HashMap<String, String> map = new HashMap<>();
            map.put("title", jsonObject.getString("title"));
            map.put("description", jsonObject.getString("description"));
            map.put("downloads", String.valueOf(jsonObject.getInt("downloads")));
            map.put("slug", jsonObject.getString("slug"));
            if (jsonObject.getString("icon_url") != null) {
                map.put("icon", jsonObject.getString("icon_url"));
            } else {
                map.put("icon", "null");
            }
            map.put("followers", String.valueOf(jsonObject.getInt("followers")));
            map.put("license", jsonObject.getJSONObject("license").getString("name"));
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList getTeamMembers(String project) {
        Request request = new Request.Builder()
                .url("https://api.modrinth.com/v2/project/" + project + "/members")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            ArrayList<String> list = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response.body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(jsonObject.getJSONObject("user").getString("username"));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
    }
        return null;
    }
}