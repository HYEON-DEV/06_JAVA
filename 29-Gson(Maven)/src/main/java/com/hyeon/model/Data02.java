package com.hyeon.model;

public class Data02 {
    private String title;
    private String description;
    private String pubDate;
    

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Data02 [title=" + title + ", description=" + description + ", pubDate=" + pubDate + "]";
    }

}
