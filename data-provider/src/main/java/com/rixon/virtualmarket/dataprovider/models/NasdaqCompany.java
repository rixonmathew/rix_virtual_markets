package com.rixon.virtualmarket.dataprovider.models;

public class NasdaqCompany {
    /**
     * "Symbol","Name","LastSale","MarketCap","IPOyear","Sector","industry","Summary Quote",
     "TFSC","1347 Capital Corp.","9.8","$58.29M","2014","Finance","Business Services","http://www.nasdaq.com/symbol/tfsc",
     */

    private String symbol;
    private String name;
    private String lastSale;
    private String marketCap;
    private String ipoYear;
    private String sector;
    private String industry;
    private String summaryQuoteURL;

    public NasdaqCompany(String csvRecord) {
        String[] components = csvRecord.split("\",\"");
        if (components.length!=8) {
            throw new IllegalArgumentException("Invalid record received. expected 8 elements "+csvRecord);
        }
        this.symbol = components[0].replaceAll("\"","");
        this.name = components[1].replaceAll("\"","");
        this.lastSale = components[2].replaceAll("\"","");
        this.marketCap = components[3].replaceAll("\"","");
        this.ipoYear = components[4].replaceAll("\"","");
        this.sector = components[5].replaceAll("\"","");
        this.industry = components[6].replaceAll("\"","");
        this.summaryQuoteURL = components[7].replaceAll("\"","").replaceAll(",","");
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getLastSale() {
        return lastSale;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public String getIpoYear() {
        return ipoYear;
    }

    public String getSector() {
        return sector;
    }

    public String getIndustry() {
        return industry;
    }

    public String getSummaryQuoteURL() {
        return summaryQuoteURL;
    }

    @Override
    public String toString() {
        return "NasdaqCompany{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", lastSale='" + lastSale + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", ipoYear='" + ipoYear + '\'' +
                ", sector='" + sector + '\'' +
                ", industry='" + industry + '\'' +
                ", summaryQuoteURL='" + summaryQuoteURL + '\'' +
                '}';
    }
}
