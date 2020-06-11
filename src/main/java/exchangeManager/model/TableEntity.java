package exchangeManager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TableEntity {

    @Id
    private Integer id;
    private String secid;
    private String regnumber;
    private String name;
    private String emitent_title;
    private String trade_date;
    private Double numtrades;
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


    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public Double getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(Double numtrades) {
        this.numtrades = numtrades;
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
                ", tradeDate='" + trade_date + '\'' +
                ", numTrades=" + numtrades +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
