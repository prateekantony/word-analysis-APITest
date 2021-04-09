package com.restproject.service.model;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URILink
{
    private String link;
    private String data;

    public URILink() { }

    public URILink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getDataFromURL()
    {
        try {
            URL url = new URL(getLink());
            Scanner s = new Scanner(url.openStream());

            setData(s.useDelimiter("\\A").next());
            s.close();
        }
        catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }

        return getData();
    }
}
