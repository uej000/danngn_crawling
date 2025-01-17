package com.cmsoft.crawling.controller;

import com.cmsoft.crawling.dto.CrawlDto;
import com.cmsoft.crawling.service.CrawlService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CrawlController {

    private final CrawlService crawlService;

    @Autowired
    public CrawlController(CrawlService crawlService) {
        this.crawlService = crawlService;
    }

    @GetMapping("/data")
    public String getData(Model model) {
        List<CrawlDto> crawlDtoList = crawlService.getCrawlList();
        model.addAttribute("crawlDtoList", crawlDtoList);
        return "datalist";
    }

    @GetMapping("/crawl")
    public String crawlPage() {

        return "crawl";
    }


    @PostMapping("/insert")
    public void insert() {
        ArrayList<CrawlDto> crawlDtoList = crawlService.crawling();
        crawlService.insertData(crawlDtoList);

    }


}
