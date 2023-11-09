package br.fatec.linhasitapirarest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "onibusLocalizacao")
public class OnibusLocalizacao {

    private Integer _id;
    private Integer linhaId;
    private String latitude;
    private String longitude;

    public OnibusLocalizacao(Integer linhaId, String latitude, String longitude) {
        this.linhaId = linhaId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(Integer linhaId) {
        this.linhaId = linhaId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "OnibusLocalizacao [linhaId=" + linhaId + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
