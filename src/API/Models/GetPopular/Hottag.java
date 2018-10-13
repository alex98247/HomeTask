package API.Models.GetPopular;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hottag {
    @SerializedName("tag")
    public List<Tag> tags;
}
