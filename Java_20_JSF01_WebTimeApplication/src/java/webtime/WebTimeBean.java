package webtime;

import java.text.DateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "webTimeBean")
public class WebTimeBean {

    public String zamanDilimi = "Istanbul, Atina, Kahire";

    public String getZamanDilimi () {
        return zamanDilimi;
    }

    public void setZamanDilimi (String zamanDilimi) {
        this.zamanDilimi = zamanDilimi;
    }

    public String getZaman () {
        return DateFormat.getTimeInstance(DateFormat.LONG).format(new Date());
    }
 // annotation eklenmis siniflar bean denir
    // getter ve setter iceren siniflar pojo dur.
}
