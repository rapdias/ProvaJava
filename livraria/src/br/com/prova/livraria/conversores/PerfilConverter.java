package br.com.prova.livraria.conversores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.persistence.Id;

import br.com.prova.livraria.bean.PerfilBean;
import br.com.prova.livraria.bean.UsuarioBean;
import br.com.prova.livraria.dao.UsuarioDao;
import br.com.prova.livraria.modelo.Perfil;
import java.lang.reflect.Field;

//@FacesConverter(value = "PerfilConverter")
public class PerfilConverter implements Converter {
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		if (value != null) {
			return component.getAttributes().get(value);
		}
		return null;
	}
	public String getAsString(FacesContext ctx, UIComponent component,
			Object obj) {
		if (obj != null && !"".equals(obj)) {
			String id;
			try {
				id = this.getId(getClazz(ctx, component), obj);
				if (id == null){
					id = "";
				}
				id = id.trim();
				component.getAttributes().put(id,
						getClazz(ctx, component).cast(obj));
				return id;
			} catch (SecurityException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); // seu log aqui
			} catch (NoSuchFieldException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalAccessException e) {
				e.printStackTrace(); // seu log aqui
			}
		}
		return null;
	}
	private Class<?> getClazz(FacesContext facesContext, UIComponent component) {
		return component.getValueExpression("value").getType(
				facesContext.getELContext());
	}
	public String getId(Class<?> clazz, Object obj) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		for (Field field : clazz.getDeclaredFields()) {
			if ((field.getAnnotation(Id.class)) != null) {
				Field privateField = clazz.getDeclaredField(field.getName());
				privateField.setAccessible(true);
				if (privateField.get(clazz.cast(obj)) != null) {
					return (String)field.getType()
							.cast(privateField.get(clazz.cast(obj))).toString();
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
//	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//	        if(value != null && value.trim().length() > 0) {
//	            try {
//	            	PerfilBean service = (PerfilBean) fc.getExternalContext().getApplicationMap().get("perfilBean");
//	                return service.getListaPerfil().get(Integer.parseInt(value));
//	            } catch(NumberFormatException e) {
//	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
//	            }
//	        }
//	        else {
//	            return null;
//	        }
//	    }
//	 
//	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//	        if(object != null) {
//	            return String.valueOf(((Perfil) object).getId());
//	        }
//	        else {
//	            return null;
//	        }
//	    }   
	   
//	private int index = -1;  
//	  
//	    /* (non-Javadoc) 
//	     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String) 
//	     */  
//	    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
//	  
//	        SelectItem selectedItem = this.getSelectedItemByIndex(component, Integer.parseInt(value));  
//	        if (selectedItem != null)  
//	            return selectedItem.getValue();  
//	  
//	        return null;  
//	    }  
//	  
//	    /* (non-Javadoc) 
//	     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object) 
//	     */  
//	    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
//	        index++;  
//	        return String.valueOf(index);  
//	    }  
//	  
//	    /** 
//	     * Obtem o SelecItem de acordo com a opção selecionada pelo usuário 
//	     */  
//	    protected SelectItem getSelectedItemByIndex(UIComponent component, int index) {  
//	  
//	        List<SelectItem> items = this.getSelectItems(component);  
//	        int size = items.size();  
//	  
//	        if (index > -1  
//	                && size > index) {  
//	            return items.get(index);  
//	        }  
//	  
//	        return null;  
//	    }  
//	  
//	    protected List<SelectItem> getSelectItems(UIComponent component) {  
//	  
//	        List<SelectItem> items = new ArrayList<SelectItem>();  
//	  
//	        int childCount = component.getChildCount();  
//	        if (childCount == 0)  
//	          return items;  
//	  
//	        List<UIComponent> children = component.getChildren();  
//	        for (UIComponent child : children) {  
//	            if (child instanceof UISelectItem) {  
//	                this.addSelectItem((UISelectItem) child, items);  
//	            } else if (child instanceof UISelectItems) {  
//	                this.addSelectItems((UISelectItems) child, items);  
//	            }  
//	        }  
//	  
//	        return items;  
//	    }  
//	  
//	    protected void addSelectItem(UISelectItem uiItem, List<SelectItem> items) {  
//	  
//	        boolean isRendered = uiItem.isRendered();  
//	        if (!isRendered) {  
//	            items.add(null);  
//	            return;  
//	        }  
//	  
//	        Object value = uiItem.getValue();  
//	        SelectItem item;  
//	  
//	        if (value instanceof SelectItem) {  
//	            item = (SelectItem) value;  
//	        } else {  
//	            Object itemValue = uiItem.getItemValue();  
//	            String itemLabel = uiItem.getItemLabel();  
//	            // JSF throws a null pointer exception for null values and labels,  
//	            // which is a serious problem at design-time.  
//	            item = new SelectItem(itemValue == null ? "" : itemValue,  
//	                    itemLabel == null ? "" : itemLabel, uiItem  
//	                            .getItemDescription(), uiItem.isItemDisabled());  
//	        }  
//	  
//	        items.add(item);  
//	    }  
//	  
//	    @SuppressWarnings("unchecked")  
//	    protected void addSelectItems(UISelectItems uiItems, List<SelectItem> items) {  
//	  
//	        boolean isRendered = uiItems.isRendered();  
//	        if (!isRendered) {  
//	            items.add(null);  
//	            return;  
//	        }  
//	  
//	        Object value = uiItems.getValue();  
//	        if (value instanceof SelectItem) {  
//	            items.add((SelectItem) value);  
//	        } else if (value instanceof Object[]) {  
//	            Object[] array = (Object[]) value;  
//	            for (int i = 0; i < array.length; i++) {  
//	                // TODO test - this section is untested  
//	                if (array[i] instanceof SelectItemGroup) {  
//	                    resolveAndAddItems((SelectItemGroup) array[i], items);  
//	                } else {  
//	                    items.add((SelectItem) array[i]);  
//	                }  
//	            }  
//	        } else if (value instanceof Collection<?>) {  
//	            Iterator<SelectItem> iter = ((Collection<SelectItem>) value)  
//	                    .iterator();  
//	            SelectItem item;  
//	            while (iter.hasNext()) {  
//	                item = iter.next();  
//	                if (item instanceof SelectItemGroup) {  
//	                    resolveAndAddItems((SelectItemGroup) item, items);  
//	                } else {  
//	                    items.add(item);  
//	                }  
//	            }  
//	        } else if (value instanceof Map) {  
//	            for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) value).entrySet()) {  
//	                Object label = entry.getKey();  
//	                SelectItem item = new SelectItem(entry.getValue(),  
//	                        label == null ? (String) null : label.toString());  
//	                // TODO test - this section is untested  
//	                if (item instanceof SelectItemGroup) {  
//	                    resolveAndAddItems((SelectItemGroup) item, items);  
//	                } else {  
//	                    items.add(item);  
//	                }  
//	            }  
//	        }  
//	    }  
//	  
//	    protected void resolveAndAddItems(SelectItemGroup group, List<SelectItem> items) {  
//	        for (SelectItem item : group.getSelectItems()) {  
//	            if (item instanceof SelectItemGroup) {  
//	                resolveAndAddItems((SelectItemGroup) item, items);  
//	            } else {  
//	                items.add(item);  
//	            }  
//	        }  
//	    }  
	  
	} 
	
//	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
//		if (value != null) {
//			return this.getAttributesFrom(component).get(value);
//		}
//		return null;
//	}
//
//	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
//
//		if (value != null && !"".equals(value)) {
//
//			Perfil entity = (Perfil) value;
//
//			// adiciona item como atributo do componente
//			this.addAttribute(component, entity);
//
//			int codigo = entity.getId();
//			if (codigo > 0) {
//				return String.valueOf(codigo);
//			}
//		}
//
//		return (String) value;
//	}
//
//	protected void addAttribute(UIComponent component, Perfil o) {
//		String key = o.getId()+ ""; // codigo da empresa como chave neste
//											// caso
//		this.getAttributesFrom(component).put(key, o);
//	}
//
//	protected Map<String, Object> getAttributesFrom(UIComponent component) {
//		return component.getAttributes();
//	}
	// @Override
	// public Object getAsObject(FacesContext arg0, UIComponent arg1, String
	// key) {
	// FacesContext context = FacesContext.getCurrentInstance();
	// Perfil perfil = (Perfil)
	// context.getELContext().getELResolver().getValue(context.getELContext(),
	// null,
	// "Perfil");
	//
	// return perfil;
	// }
	//
	// @Override
	// public String getAsString(FacesContext arg0, UIComponent arg1, Object
	// arg2) {
	// return arg2.toString();
	// }
	// @Override
	// public Object getAsObject(FacesContext context, UIComponent component,
	// String value) {
	// if (value != null && !value.isEmpty()) {
	// return (Perfil) component.getAttributes().get(value);
	// }
	// return null;
	// }
	//
	// @Override
	// public String getAsString(FacesContext context, UIComponent component,
	// Object value) {
	// Perfil perfil = new Perfil();
	// if (value instanceof Perfil) {
	// perfil = (Perfil) value;
	// if (perfil != null && perfil instanceof Perfil && perfil.getId() > 0) {
	// component.getAttributes().put( perfil.toString(), perfil);
	// return perfil.toString();
	// }
	// }
	// return perfil.toString();
	// }


