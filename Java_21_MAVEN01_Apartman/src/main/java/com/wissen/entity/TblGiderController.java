package com.wissen.entity;

import com.wissen.entity.util.JsfUtil;
import com.wissen.entity.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named("tblGiderController")
@SessionScoped
public class TblGiderController implements Serializable {

    @EJB
    private com.wissen.entity.TblGiderFacade ejbFacade;
    private List<TblGider> items = null;
    private TblGider selected;

    public TblGiderController () {
    }

    public TblGider getSelected () {
        return selected;
    }

    public void setSelected (TblGider selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys () {
    }

    protected void initializeEmbeddableKey () {
    }

    private TblGiderFacade getFacade () {
        return ejbFacade;
    }

    public TblGider prepareCreate () {
        selected = new TblGider();
        initializeEmbeddableKey();
        return selected;
    }

    public void create () {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblGiderCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update () {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblGiderUpdated"));
    }

    public void destroy () {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TblGiderDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblGider> getItems () {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist (PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TblGider getTblGider (java.lang.String id) {
        return getFacade().find(id);
    }

    public List<TblGider> getItemsAvailableSelectMany () {
        return getFacade().findAll();
    }

    public List<TblGider> getItemsAvailableSelectOne () {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblGider.class)
    public static class TblGiderControllerConverter implements Converter {

        @Override
        public Object getAsObject (FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblGiderController controller = (TblGiderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblGiderController");
            return controller.getTblGider(getKey(value));
        }

        java.lang.String getKey (String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey (java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString (FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TblGider) {
                TblGider o = (TblGider) object;
                return getStringKey(o.getGiderKod());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] {object, object.getClass().getName(), TblGider.class.getName()});
                return null;
            }
        }

    }

}
