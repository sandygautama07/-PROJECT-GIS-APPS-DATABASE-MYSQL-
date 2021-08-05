package ac.id.atmaluhur.mahasiswa_1811500030.model;

import com.google.gson.annotations.SerializedName;

public class LocationModel {
    public String getImageLocationName() { return imageLocationName;}

    public  void setImageLocationName(String imageLocationName){
        this.imageLocationName = imageLocationName;
    }
    public String getLatitude() { return latitude;}

    public void setLatitude(String latitude) {this.latitude = latitude;}

    public String getLongitude() { return longitude;}

    public void setLongitude(String longitude) {this.longitude = longitude;}

    @SerializedName("nama")
    private String imageLocationName;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public LocationModel (String imageLocationName, String latitude, String longitude){
        this.imageLocationName = imageLocationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
