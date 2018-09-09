package com.analyze.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.print.Doc;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hod on 07.09.18.
 */
public class PageConsuption {

//    private List<Document> documents = new ArrayList<Document>();
    private List<Elements> elements = new ArrayList<Elements>();

    public void loadDocument(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        String paginationUrl = "";

        int pages = Integer.parseInt(document
                .select("span.m-pagination__text").get(0).text());

        List<Double> prices = new ArrayList<Double>();

        for (int count = 1; count <= pages; count++) {
            document = Jsoup.connect(url + "&p=" + count).get();
            paginationUrl += document.select("span.ecb7eff");
            prices.addAll(getDocumentPrices(document));
        }
        System.out.println("WWWWWWWWWWWWWW: " + prices);
    }

    public List<Double> getDocumentPrices(Document document) {
        String price = "";
        List<Double> prices = new ArrayList<Double>();
        int priceCount = document.select("span.ecb7eff").size();
        for(int count = 0; count < priceCount; count++) {
            price = document.select("span.ecb7eff").get(count).text();
            price = price.replace(",", ".");
            price = price.replace(" zł", "");
            price = price.replace(" ", "");
            prices.add(Double.parseDouble(price));

        }
        return prices;
    }

//    public void loadElements(Document document) {
//        String[] elements = document.select("span.ecb7eff").text().toString().split(" zł");
//        int prices = 0;
//
//    }
}

