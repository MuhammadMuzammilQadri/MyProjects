package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */


public class QueryEntries
{
    private String title;

    private String link;

    private String contentSnippet;

    private String url;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
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

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", link = "+link+", contentSnippet = "+contentSnippet+", url = "+url+"]";
    }
}

