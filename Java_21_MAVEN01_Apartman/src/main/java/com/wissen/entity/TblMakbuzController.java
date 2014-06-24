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

@Named("tblMakbuzController")
@SessionScoped
public class TblMakbuzController implements Serializable {

    @EJB
    private com.wissen.entity.TblMakbuzFacade ejbFacade;
    private List<TblMakbuz> items = null;
    private TblMakbuz selected;

    public TblMakbuzController () {
    }

    public TblMakbuz getSelected () {
        return selected;
    }

    public void setSelected (TblMakbuz selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys () {
    }

    protected void initializeEmbeddableKey () {
    }

    private TblMakbuzFacade getFacade () {
        return ejbFacade;
    }

    public TblMakbuz prepareCreate () {
        selected = new TblMakbuz();
        initializeEmbeddableKey();
        return selected;
    }

    public void create () {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblMakbuzCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update () {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblMakbuzUpdated"));
    }

    public void destroy () {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TblMakbuzDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblMakbuz> getItems () {
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

    public TblMakbuz getTblMakbuz (java.lang.String id) {
        return getFacade().find(id);
    }

    public List<TblMakbuz> getItemsAvailableSelectMany () {
        return getFacade().findAll();
    }

    public List<TblMakbuz> getItemsAvailableSelectOne () {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblMakbuz.class)
    public static class TblMakbuzControllerConverter implements Converter {

        @Override
        public Object getAsObject (FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblMakbuzController controller = (TblMakbuzController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblMakbuzController");
            return controller.getTblMakbuz(getKey(value));
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
            if (object instanceof TblMakbuz) {
                TblMakbuz o = (TblMakbuz) object;
                return getStringKey(o.getMakbuzNo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[] {object, object.getClass().getName(), TblMakbuz.class.getName()});
                return null;
            }
        }

    }

}
