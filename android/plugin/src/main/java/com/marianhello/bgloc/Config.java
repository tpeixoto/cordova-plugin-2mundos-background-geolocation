/*
According to apache license

This is fork of christocracy cordova-plugin-background-geolocation plugin
https://github.com/christocracy/cordova-plugin-background-geolocation

This is a new class
*/

package com.marianhello.bgloc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;

import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Config class
 */
public class Config implements Parcelable
{
    public static final int ANDROID_DISTANCE_FILTER_PROVIDER = 0;
    public static final int ANDROID_ACTIVITY_PROVIDER = 1;

    // actual values should be read from strings.xml
    public static final String ACCOUNT_NAME_RESOURCE = "account_name";
    public static final String ACCOUNT_TYPE_RESOURCE = "account_type";
    public static final String CONTENT_AUTHORITY_RESOURCE = "content_authority";

    private float originLatitude = 0;
    private float originLongitude = 0;
    private float perimeterRadius = 100;

    private float stationaryRadius = 50;
    private Integer distanceFilter = 500;
    private Integer desiredAccuracy = 100;
    private Boolean debug = false;
    private String insideNotificationTitle = "Background tracking";
    private String insideNotificationText = "ENABLED";
    private String outsideNotificationTitle = "Background tracking";
    private String outsideNotificationText = "ENABLED";
    private String notificationIconLarge;
    private String notificationIconSmall;
    private String notificationIconColor;
    private Integer locationProvider = ANDROID_DISTANCE_FILTER_PROVIDER;
    private Integer interval = 600000; //milliseconds
    private Integer fastestInterval = 120000; //milliseconds
    private Integer activitiesInterval = 10000; //milliseconds
    private Boolean stopOnTerminate = true;
    private Boolean startOnBoot = false;
    private Boolean startForeground = true;
    private Boolean stopOnStillActivity = true;
    private String url;
    private String syncUrl;
    private Integer syncThreshold = 100;
    private HashMap httpHeaders = new HashMap<String, String>();
    private Integer maxLocations = 10000;

    public Config () {
    }

    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(getOriginLatitude());
        out.writeFloat(getOriginLongitude());
        out.writeFloat(getPerimeterRadius());
        out.writeFloat(getStationaryRadius());
        out.writeInt(getDistanceFilter());
        out.writeInt(getDesiredAccuracy());
        out.writeValue(isDebugging());
        out.writeString(getInsideNotificationTitle());
        out.writeString(getInsideNotificationText());
        out.writeString(getOutsideNotificationTitle());
        out.writeString(getOutsideNotificationText());
        out.writeString(getLargeNotificationIcon());
        out.writeString(getSmallNotificationIcon());
        out.writeString(getNotificationIconColor());
        out.writeValue(getStopOnTerminate());
        out.writeValue(getStartOnBoot());
        out.writeValue(getStartForeground());
        out.writeInt(getLocationProvider());
        out.writeInt(getInterval());
        out.writeInt(getFastestInterval());
        out.writeInt(getActivitiesInterval());
        out.writeValue(getStopOnStillActivity());
        out.writeString(getUrl());
        out.writeString(getSyncUrl());
        out.writeInt(getSyncThreshold());
        out.writeInt(getMaxLocations());
        Bundle bundle = new Bundle();
        bundle.putSerializable("httpHeaders", getHttpHeaders());
        out.writeBundle(bundle);
    }

    public static final Parcelable.Creator<Config> CREATOR
            = new Parcelable.Creator<Config>() {
        public Config createFromParcel(Parcel in) {
            return new Config(in);
        }

        public Config[] newArray(int size) {
            return new Config[size];
        }
    };

    private Config(Parcel in) {
        setOriginLatitude(in.readFloat());
        setOriginLongitude(in.readFloat());
        setPerimeterRadius(in.readFloat());
        setStationaryRadius(in.readFloat());
        setDistanceFilter(in.readInt());
        setDesiredAccuracy(in.readInt());
        setDebugging((Boolean) in.readValue(null));
        setInsideNotificationTitle(in.readString());
        setInsideNotificationText(in.readString());
        setOutsideNotificationTitle(in.readString());
        setOutsideNotificationText(in.readString());
        setLargeNotificationIcon(in.readString());
        setSmallNotificationIcon(in.readString());
        setNotificationIconColor(in.readString());
        setStopOnTerminate((Boolean) in.readValue(null));
        setStartOnBoot((Boolean) in.readValue(null));
        setStartForeground((Boolean) in.readValue(null));
        setLocationProvider(in.readInt());
        setInterval(in.readInt());
        setFastestInterval(in.readInt());
        setActivitiesInterval(in.readInt());
        setStopOnStillActivity((Boolean) in.readValue(null));
        setUrl(in.readString());
        setSyncUrl(in.readString());
        setSyncThreshold(in.readInt());
        setMaxLocations(in.readInt());
        Bundle bundle = in.readBundle();
        setHttpHeaders((HashMap<String, String>) bundle.getSerializable("httpHeaders"));
    }

    public float getOriginLatitude() {
        return originLatitude;
    }

    public float getOriginLongitude() {
        return originLongitude;
    }

    public float getPerimeterRadius() {
        return perimeterRadius;
    }

    public float getStationaryRadius() {
        return stationaryRadius;
    }

    public void setOriginLatitude(float originLatitude) {
        this.originLatitude = originLatitude;
    }

    public void setOriginLongitude(float originLongitude) {
        this.originLongitude = originLongitude;
    }

    public void setPerimeterRadius(float perimeterRadius) {
        this.perimeterRadius = perimeterRadius;
    }

    public void setStationaryRadius(float stationaryRadius) {
        this.stationaryRadius = stationaryRadius;
    }

    public Integer getDesiredAccuracy() {
        return desiredAccuracy;
    }

    public void setDesiredAccuracy(Integer desiredAccuracy) {
        this.desiredAccuracy = desiredAccuracy;
    }

    public Integer getDistanceFilter() {
        return distanceFilter;
    }

    public void setDistanceFilter(Integer distanceFilter) {
        this.distanceFilter = distanceFilter;
    }

    public Boolean isDebugging() {
        return debug;
    }

    public void setDebugging(Boolean debug) {
        this.debug = debug;
    }

    public String getNotificationIconColor() {
        return notificationIconColor;
    }

    public void setNotificationIconColor(String notificationIconColor) {
        if (!"null".equals(notificationIconColor)) {
            this.notificationIconColor = notificationIconColor;
        }
    }

    public String getInsideNotificationTitle() {
        return insideNotificationTitle;
    }

    public void setInsideNotificationTitle(String notificationTitle) {
        this.insideNotificationTitle = notificationTitle;
    }

    public String getInsideNotificationText() {
        return insideNotificationText;
    }

    public void setInsideNotificationText(String notificationText) {
        this.insideNotificationText = notificationText;
    }

    public String getOutsideNotificationTitle() {
        return outsideNotificationTitle;
    }

    public void setOutsideNotificationTitle(String notificationTitle) {
        this.outsideNotificationTitle = notificationTitle;
    }

    public String getOutsideNotificationText() {
        return outsideNotificationText;
    }

    public void setOutsideNotificationText(String notificationText) {
        this.outsideNotificationText = notificationText;
    }

    public String getLargeNotificationIcon () {
        return notificationIconLarge;
    }

    public void setLargeNotificationIcon (String icon) {
        this.notificationIconLarge = icon;
    }

    public String getSmallNotificationIcon () {
        return notificationIconSmall;
    }

    public void setSmallNotificationIcon (String icon) {
        this.notificationIconSmall = icon;
    }

    public Boolean getStopOnTerminate() {
        return stopOnTerminate;
    }

    public void setStopOnTerminate(Boolean stopOnTerminate) {
        this.stopOnTerminate = stopOnTerminate;
    }

    public Boolean getStartOnBoot() {
        return startOnBoot;
    }

    public void setStartOnBoot(Boolean startOnBoot) {
        this.startOnBoot = startOnBoot;
    }

    public Boolean getStartForeground() {
        return this.startForeground;
    }

    public void setStartForeground(Boolean startForeground) {
        this.startForeground = startForeground;
    }

    public Integer getLocationProvider() {
        return this.locationProvider;
    }

    public void setLocationProvider(Integer locationProvider) {
        this.locationProvider = locationProvider;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getFastestInterval() {
        return fastestInterval;
    }

    public void setFastestInterval(Integer fastestInterval) {
        this.fastestInterval = fastestInterval;
    }

    public Integer getActivitiesInterval() {
        return activitiesInterval;
    }

    public void setActivitiesInterval(Integer activitiesInterval) {
        this.activitiesInterval = activitiesInterval;
    }

    public Boolean getStopOnStillActivity() {
        return stopOnStillActivity;
    }

    public void setStopOnStillActivity(Boolean stopOnStillActivity) {
        this.stopOnStillActivity = stopOnStillActivity;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean hasUrl() {
        return this.url != null && !this.url.isEmpty();
    }

    public String getSyncUrl() {
        return syncUrl;
    }

    public void setSyncUrl(String syncUrl) {
        this.syncUrl = syncUrl;
    }

    public Boolean hasSyncUrl() {
        return this.syncUrl != null && !this.syncUrl.isEmpty();
    }

    public Integer getSyncThreshold() {
        return syncThreshold;
    }

    public void setSyncThreshold(Integer syncThreshold) {
        this.syncThreshold = syncThreshold;
    }

    public HashMap<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public void setHttpHeaders(HashMap httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public void setHttpHeaders(JSONObject httpHeaders) throws JSONException {
        // intentionally set httpHeaders to empty hash map
        // this allows to reset headers in .fromJSONArray providing empty httpHeaders JSONObject
        this.httpHeaders = new HashMap<String, String>();
        if (httpHeaders == null) {
            return;
        }
        Iterator<?> it = httpHeaders.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            this.httpHeaders.put(key, httpHeaders.getString(key));
        }
    }

    public Integer getMaxLocations() {
        return maxLocations;
    }

    public void setMaxLocations(Integer maxLocations) {
        this.maxLocations = maxLocations;
    }

    @Override
    public String toString () {
        return new StringBuffer()
                .append("Config[distanceFilter=").append(getDistanceFilter())
                .append(" originLatitude=").append(getOriginLatitude())
                .append(" originLongitude=").append(getOriginLongitude())
                .append(" perimeterRadius=").append(getPerimeterRadius())
                .append(" stationaryRadius=").append(getStationaryRadius())
                .append(" desiredAccuracy=").append(getDesiredAccuracy())
                .append(" interval=").append(getInterval())
                .append(" fastestInterval=").append(getFastestInterval())
                .append(" activitiesInterval=").append(getActivitiesInterval())
                .append(" isDebugging=").append(isDebugging())
                .append(" stopOnTerminate=" ).append(getStopOnTerminate())
                .append(" stopOnStillActivity=").append(getStopOnStillActivity())
                .append(" startOnBoot=").append(getStartOnBoot())
                .append(" startForeground=").append(getStartForeground())
                .append(" locationProvider=").append(getLocationProvider())
                .append(" nInsideTitle=").append(getInsideNotificationTitle())
                .append(" nInsideText=").append(getInsideNotificationText())
                .append(" nOutsideTitle=").append(getOutsideNotificationTitle())
                .append(" nOutsideText=").append(getOutsideNotificationText())
                .append(" nIconLarge=").append(getLargeNotificationIcon())
                .append(" nIconSmall=").append(getSmallNotificationIcon())
                .append(" nIconColor=").append(getNotificationIconColor())
                .append(" url=").append(getUrl())
                .append(" syncUrl=").append(getSyncUrl())
                .append(" syncThreshold=").append(getSyncThreshold())
                .append(" httpHeaders=").append(getHttpHeaders().toString())
                .append(" maxLocations=").append(getMaxLocations())
                .append("]")
                .toString();
    }

    public Parcel toParcel () {
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        return parcel;
    }

    public static Config fromByteArray (byte[] byteArray) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(byteArray, 0, byteArray.length);
        parcel.setDataPosition(0);
        return Config.CREATOR.createFromParcel(parcel);
    }

    public static Config fromJSONObject (JSONObject jObject) throws JSONException {
        Config config = new Config();
        config.setOriginLatitude((float) jObject.optDouble("originLatitude", config.getOriginLatitude()));
        config.setOriginLongitude((float) jObject.optDouble("originLongitude", config.getOriginLongitude()));
        config.setPerimeterRadius((float) jObject.optDouble("perimeterRadius", config.getPerimeterRadius()));
        config.setStationaryRadius((float) jObject.optDouble("stationaryRadius", config.getStationaryRadius()));
        config.setDistanceFilter(jObject.optInt("distanceFilter", config.getDistanceFilter()));
        config.setDesiredAccuracy(jObject.optInt("desiredAccuracy", config.getDesiredAccuracy()));
        config.setDebugging(jObject.optBoolean("debug", config.isDebugging()));
        config.setInsideNotificationTitle(jObject.optString("insideNotificationTitle", config.getInsideNotificationTitle()));
        config.setInsideNotificationText(jObject.optString("insideNotificationText", config.getInsideNotificationText()));
        config.setOutsideNotificationTitle(jObject.optString("outsideNotificationTitle", config.getOutsideNotificationTitle()));
        config.setOutsideNotificationText(jObject.optString("outsideNotificationText", config.getOutsideNotificationText()));
        config.setStopOnTerminate(jObject.optBoolean("stopOnTerminate", config.getStopOnTerminate()));
        config.setStartOnBoot(jObject.optBoolean("startOnBoot", config.getStartOnBoot()));
        config.setLocationProvider(jObject.optInt("locationProvider", config.getLocationProvider()));
        config.setInterval(jObject.optInt("interval", config.getInterval()));
        config.setFastestInterval(jObject.optInt("fastestInterval", config.getFastestInterval()));
        config.setActivitiesInterval(jObject.optInt("activitiesInterval", config.getActivitiesInterval()));
        config.setNotificationIconColor(jObject.optString("notificationIconColor", config.getNotificationIconColor()));
        config.setLargeNotificationIcon(jObject.optString("notificationIconLarge", config.getLargeNotificationIcon()));
        config.setSmallNotificationIcon(jObject.optString("notificationIconSmall", config.getSmallNotificationIcon()));
        config.setStartForeground(jObject.optBoolean("startForeground", config.getStartForeground()));
        config.setStopOnStillActivity(jObject.optBoolean("stopOnStillActivity", config.getStopOnStillActivity()));
        config.setUrl(jObject.optString("url"));
        config.setSyncUrl(jObject.optString("syncUrl"));
        config.setSyncThreshold(jObject.optInt("syncThreshold", config.getSyncThreshold()));
        config.setHttpHeaders(jObject.optJSONObject("httpHeaders"));
        config.setMaxLocations(jObject.optInt("maxLocations", config.getMaxLocations()));

        return config;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("originLatitude", getOriginLatitude());
        json.put("originLongitude", getOriginLongitude());
        json.put("perimeterRadius", getPerimeterRadius());
        json.put("stationaryRadius", getStationaryRadius());
        json.put("distanceFilter", getDistanceFilter());
        json.put("desiredAccuracy", getDesiredAccuracy());
        json.put("debug", isDebugging());
        json.put("insideNotificationTitle", getInsideNotificationTitle());
        json.put("insideNotificationText", getInsideNotificationText());
        json.put("outsideNotificationTitle", getOutsideNotificationTitle());
        json.put("outsideNotificationText", getOutsideNotificationText());
        json.put("notificationIconLarge", getLargeNotificationIcon());
        json.put("notificationIconSmall", getSmallNotificationIcon());
        json.put("notificationIconColor", getNotificationIconColor());
        json.put("stopOnTerminate", getStopOnTerminate());
        json.put("startOnBoot", getStartOnBoot());
        json.put("startForeground", getStartForeground());
        json.put("locationProvider", getLocationProvider());
        json.put("interval", getInterval());
        json.put("fastestInterval", getFastestInterval());
        json.put("activitiesInterval", getActivitiesInterval());
        json.put("stopOnStillActivity", getStopOnStillActivity());
        json.put("url", getUrl());
        json.put("syncUrl", getSyncUrl());
        json.put("syncThreshold", getSyncThreshold());
        json.put("httpHeaders", new JSONObject(getHttpHeaders()));
        json.put("maxLocations", getMaxLocations());

        return json;
  	}
}
