package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class Entries
{
    private String content;

    private String author;

    private String title;

    private MediaGroups[] mediaGroups;

    private String link;

    private String contentSnippet;

    private String[] categories;

    private String publishedDate;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public MediaGroups[] getMediaGroups ()
    {
        return mediaGroups;
    }

    public void setMediaGroups (MediaGroups[] mediaGroups)
    {
        this.mediaGroups = mediaGroups;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getContentSnippet ()
    {
        return contentSnippet;
    }

    public void setContentSnippet (String contentSnippet)
    {
        this.contentSnippet = contentSnippet;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    public String getPublishedDate ()
    {
        return publishedDate;
    }

    public void setPublishedDate (String publishedDate)
    {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", author = "+author+", title = "+title+", mediaGroups = "+mediaGroups+", link = "+link+", contentSnippet = "+contentSnippet+", categories = "+categories+", publishedDate = "+publishedDate+"]";
    }
}
