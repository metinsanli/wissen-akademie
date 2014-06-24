
import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean()
@SessionScoped
public class UserNumberBean implements Serializable {

    Integer randomInt = null;
    Integer userNumber = null;
    String reponse = null;
    int sayac = 1;
    private long maximum = 4;
    private long minimum = 0;

    public int getSayac () {
        return sayac;
    }

    public void setSayac (int sayac) {
        this.sayac = sayac;
    }

    public UserNumberBean () {
        Random randomGR = new Random();
        randomInt = new Integer(randomGR.nextInt(4));
    }

    public void setUserNumber (Integer user_number) {
        userNumber = user_number;
    }

    public Integer getUserNumber () {
        return userNumber;
    }

    public String getResponse () {
        if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {
            //Doğru cevap verildiğinde kullanıcının oturumunu sil.
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "Yay! You got it!";
        } else {
            sayac++;
            return "Sorry, " + userNumber + " is incorrect.";
        }
    }

    public long getMaximum () {
        return (this.maximum);
    }

    public void setMaximum (long maximum) {
        this.maximum = maximum;
    }

    public long getMinimum () {
        return (this.minimum);
    }

    public void setMinimum (long minimum) {
        this.minimum = minimum;
    }

}
