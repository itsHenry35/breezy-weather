package wangdaye.com.geometricweather.db.entity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;

import wangdaye.com.geometricweather.basic.model.option.provider.WeatherSource;
import wangdaye.com.geometricweather.db.propertyConverter.WeatherSourceConverter;

import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Location entity.
 *
 * {@link wangdaye.com.geometricweather.basic.model.location.Location}.
 * */

@Entity
public class LocationEntity {

    @Id public Long id;

    public String cityId;

    public float latitude;
    public float longitude;
    public int GMTOffset;

    public String country;
    public String province;
    public String city;
    public String district;

    @Convert(converter = WeatherSourceConverter.class, columnType = String.class)
    public WeatherSource weatherSource;

    public boolean currentPosition;
    public boolean china;
    @Generated(hash = 495343798)
    public LocationEntity(Long id, String cityId, float latitude, float longitude, int GMTOffset,
            String country, String province, String city, String district, WeatherSource weatherSource,
            boolean currentPosition, boolean china) {
        this.id = id;
        this.cityId = cityId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.GMTOffset = GMTOffset;
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.weatherSource = weatherSource;
        this.currentPosition = currentPosition;
        this.china = china;
    }

    @Generated(hash = 1723987110)
    public LocationEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getGMTOffset() {
        return this.GMTOffset;
    }

    public void setGMTOffset(int GMTOffset) {
        this.GMTOffset = GMTOffset;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public WeatherSource getWeatherSource() {
        return this.weatherSource;
    }

    public void setWeatherSource(WeatherSource weatherSource) {
        this.weatherSource = weatherSource;
    }

    public boolean getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(boolean currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean getChina() {
        return this.china;
    }

    public void setChina(boolean china) {
        this.china = china;
    }
}