package API.Models.SearchPhoto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoObj {
    @SerializedName("photo")
    public List<Photo> photos;
}
