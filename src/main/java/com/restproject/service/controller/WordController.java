package com.restproject.service.controller;

import com.restproject.service.analyser.WordAnalyser;
import com.restproject.service.model.URILink;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WordController
{
    private URILink urlLink;
    private WordAnalyser wa;

    @GetMapping("/link")
    public String getLink(@RequestParam(value = "url", defaultValue = "500") String linkPath)
    {
        if (linkPath.equals("500"))
        {
            return "add txt file link API query to end of URL. " +
                    "Example: ?url=https://sete.com/path/to/file.txt";
        }
        else
        {
            urlLink  = new URILink(linkPath);
            wa = new WordAnalyser(urlLink.getDataFromURL());

            return wa.FinalResultGenerator();
        }
    }
}
