package API;

import org.junit.Test;

import java.io.IOException;

public class FlickrApiTest {
    @Test
    public void getPopularTest() throws IOException {
        FlickrApi flickrApi = new FlickrApi();
        flickrApi.getPopular();
    }

    @Test
    public void serchByTagTest() throws IOException {
        FlickrApi flickrApi = new FlickrApi();
        flickrApi.serchByTag("feb23");
    }

    @Test
    public void serchTagByUserIdTest() throws IOException {
        FlickrApi flickrApi = new FlickrApi();
        flickrApi.serchTagByUserId("139125195@N04");
    }

    @Test
    public void downloadPhotoByIdTest() throws IOException {
        FlickrApi flickrApi = new FlickrApi();
        flickrApi.downloadPhotoById("25318909031", "b9cef2709a", 2, "1580" );
    }
}
