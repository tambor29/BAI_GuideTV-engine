package com.bai.models;

import org.jsoup.nodes.Element;

public class RawData {

    private Element dataSnippet;

    public RawData(){}
    public RawData(Element dataSnippet){
        this.dataSnippet = dataSnippet;
    }

    public Element getDataSnippet() {
        return dataSnippet;
    }

    public void setDataSnippet(Element dataSnippet) {
        this.dataSnippet = dataSnippet;
    }
}
