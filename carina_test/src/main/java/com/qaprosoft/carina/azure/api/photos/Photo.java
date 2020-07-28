package com.qaprosoft.carina.azure.api.photos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Photo {
    @JsonProperty(value = "ID")
    private int id;
    @JsonProperty(value = "IDBook")
    private int idBook;
    @JsonProperty(value = "Url")
    private String url;

    public Photo() {}

    public Photo(int id, int idBook, String url){
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", url='" + url + '\'' +
                '}';
    }
}
