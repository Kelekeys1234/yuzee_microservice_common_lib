package com.yuzee.common.lib.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.BeanUtils;

public class BeanUtills {
	
		public static void setEnumConventer (Map<Class, Converter> mapOfConverters) {
			NullAwareBeanUtilsBean nullAwareBeanUtilsBean =	NullAwareBeanUtilsBean.getInstance();
			mapOfConverters.forEach((k,v) -> {
				nullAwareBeanUtilsBean.getConvertUtils().register(v, k);
			});
		}
	
	    public static void copyPropertiesNotNull(Object dest, Object orig) throws InvocationTargetException, IllegalAccessException {
	        NullAwareBeanUtilsBean.getInstance().copyProperties(dest, orig);
	    }

	    private static class NullAwareBeanUtilsBean extends BeanUtilsBean {

	        private static NullAwareBeanUtilsBean nullAwareBeanUtilsBean;

	        NullAwareBeanUtilsBean() {
	            super(new ConvertUtilsBean(), new PropertyUtilsBean() {
	                @Override
	                public PropertyDescriptor[] getPropertyDescriptors(Class<?> beanClass) {
	                    return BeanUtils.getPropertyDescriptors(beanClass);
	                }

	                @Override
	                public PropertyDescriptor getPropertyDescriptor(Object bean, String name) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	                    return BeanUtils.getPropertyDescriptor(bean.getClass(), name);
	                }
	            });
	        }

	        public static NullAwareBeanUtilsBean getInstance() {
	            if (nullAwareBeanUtilsBean == null) {
	                nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
	            }
	            return nullAwareBeanUtilsBean;
	        }

	        @Override
	        public void copyProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {
	            if (value == null) return;
	            super.copyProperty(bean, name, value);
	        }
	        
	    }
}
