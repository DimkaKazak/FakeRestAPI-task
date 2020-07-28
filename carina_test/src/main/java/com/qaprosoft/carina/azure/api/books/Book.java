package com.qaprosoft.carina.azure.api.books;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonAutoDetect
public class Book {
    @JsonProperty(value = "ID")
    private int id;
    @JsonProperty(value = "Title")
    private String title;
    @JsonProperty(value = "Description")
    private String description;
    @JsonProperty(value = "PageCount")
    private int pageCount;
    @JsonProperty(value = "Excerpt")
    private String excerpt;
    @JsonProperty(value = "PublishDate")
    private Date publishDate;

    public Book() {}

    public Book(int id, String title, String description, int pageCount, String excerpt, Date publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", excerpt='" + excerpt + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
