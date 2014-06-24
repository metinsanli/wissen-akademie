
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "selectionsBean")
@SessionScoped
public class SelectionsBean implements Serializable {

    // map of topics to book titles
    private static final HashMap< String, String> booksMap = new HashMap< String, String>();

    // initialize booksMap
    static {
        booksMap.put("java", "Java How to Program");
        booksMap.put("cpp", "C++ How to Program");
        booksMap.put("iphone", "iPhone for Programmers: An App-Driven Approach");
        booksMap.put("android", "Android for Programmers: An App-Driven Approach");
    } // end static initializer block

    // stores individual user's selections
    private Set< String> selections = new TreeSet< String>();
    private String selection; // stores the current selection
    // return number of selections

    public int getNumberOfSelections () {
        return selections.size();
    } // end method getNumberOfSelections

    public String getSelection () // returns the current selection
    {
        return selection;
    } // end method getSelection

    public void setSelection (String topic) // store user's selection
    {
        selection = booksMap.get(topic);
        selections.add(selection);
    } // end method setSelection

    public String[] getSelections () // return the Set of selections
    {
        return selections.toArray(new String[selections.size()]);
    } // end method getSelections

}
