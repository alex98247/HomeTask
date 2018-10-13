package API;

import API.Models.GetPopular.GetPopularJson;
import API.Models.SearchPhoto.Search;
import API.Models.SearchTag.Content;
import com.google.gson.Gson;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlickrApi {

    private static final String url = "https://api.flickr.com/services/rest/";
    private static final String apiKey = "8e447c4d7b55fd1464df7f62065171fe";

    //flickr.tags.getHotList
    public void getPopular() throws IOException {
        String method = "flickr.tags.getHotList";
        String result = send(method, null);

        final GetPopularJson popularJson = new Gson().fromJson(result, GetPopularJson.class);
        popularJson.hottags.tags.forEach(x -> System.out.println("Score: " + x.score + " Tag: " + x._content));

    }

    //flickr.photos.search
    public void serchByTag(String tag) throws IOException {
        String method = "flickr.photos.search";
        Pair<String, String>[] params = new Pair[]{new Pair("tags", tag)};
        String result = send(method, params);
        final Search photoInfo = new Gson().fromJson(result, Search.class);
        photoInfo.photos.photos.forEach(x -> System.out.println("Id: " + x.id +
                " Owner: " + x.owner + " Server: " + x.server + " Secret: " + x.secret
                + " Farm: " + x.farm));

    }

    //flickr.tags.getListUser
    public void serchTagByUserId(String userId) throws IOException {
        String method = "flickr.tags.getListUser";
        Pair<String, String>[] params = new Pair[]{new Pair("user_id", userId)};
        String result = send(method, params);
        final Content tags = new Gson().fromJson(result, Content.class);
        tags.who.tags.tag.forEach(x -> System.out.println("Tag: " + x._content));

    }

    //flickr.photos.getInfo
    public void downloadPhotoById(String photoId, String secret, int farm, String server) throws IOException {
        URL url = new URL("http://farm"+farm+".staticflickr.com/"+server+"/"+photoId+"_"+secret+".jpg");
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
            File outputfile = new File("saved.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
        }

    }

    private String send(String method, Pair<String, String>[] params) throws IOException {
        URL obj = new URL(url + "?method=" + method + makeParams(params) + "&api_key=" + apiKey + "&format=json&nojsoncallback=1");
        System.out.print(obj);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    private String makeParams(Pair<String, String>[] params) {
        String result = "";
        if (params == null) {
            return result;
        }
        for (Pair<String, String> pair :
                params) {
            result += "&" + pair.getKey() + "=" + pair.getValue();
        }
        return result;
    }
}
