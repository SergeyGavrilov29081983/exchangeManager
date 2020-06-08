package exchangeManager.model;


import javax.persistence.*;

@Entity
@Table(name = "securities")
@NamedQueries({
        @NamedQuery(name = Securities.DELETE, query = "DELETE FROM Securities s WHERE s.id=:id"),
        @NamedQuery(name = Securities.GET_ALL, query = "SELECT s FROM Securities s ORDER BY s.name"),
        @NamedQuery(name = Securities.SECIDLIST, query = "SELECT secid FROM Securities"),
})
public class Securities {

    public static final String DELETE = "Securities.delete";
    public static final String GET_ALL = "Securities.get_all";
    public static final String SECIDLIST = "Securities.secidlist";

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "secid")
    private String secid;

    @Column(name = "regnumber")
    private String regnumber;

    @Column(name = "name")
    private String name;

    @Column(name = "emitent_title")
    private String emitent_title;

   public boolean isNew() {
        return this.id == null;
    }


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

    @Override
    public String toString() {
        return "Securities{" +
                "id=" + id +
                ", secid='" + secid + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", emitent_title='" + emitent_title + '\'' +
                '}';
    }
}
