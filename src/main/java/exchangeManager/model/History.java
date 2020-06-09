package exchangeManager.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
@NamedQueries({
        @NamedQuery(name = History.DELETE, query = "DELETE FROM History h WHERE h.secId=:secid"),
})
public class History {

    public static final String DELETE = "History.delete";

    @Id
    @Column(name = "secid")
    private String secId;

    @Column(name = "trade_date")
    private String tradeDate;

    @Column(name = "numtrades")
    private Double numTrades;

    @Column(name = "open")
    private Double open;

    @Column(name = "close")
    private Double close;

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
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

    public boolean isNew() {
        return this.secId == null;
    }

    @Override
    public String toString() {
        return "History{" +
                "secId='" + secId + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", numTrades=" + numTrades +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
