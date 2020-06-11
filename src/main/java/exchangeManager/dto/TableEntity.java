package exchangeManager.dto;

import javax.persistence.Entity;

@Entity
public class TableEntity {

    private Integer id;
    private String secid;
    private String regnumber;
    private String name;
    private String emitent_title;
    private String tradeDate;
    private Double numTrades;
    private Double open;
    private Double close;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent_title() {
        return emitent_title;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Double getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(Double numTrades) {
        this.numTrades = numTrades;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "id=" + id +
                ", secid='" + secid + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", emitent_title='" + emitent_title + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", numTrades=" + numTrades +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
