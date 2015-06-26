/**
 *     Copyright (C) 2009-2012  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
 
 package org.xmlportletfactory.portal.example01;

import java.util.Date;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.xmlportletfactory.portal.example01.model.PortletOne;

public class PortletOneComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getPortletOneOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderByPortletOnePortletOneId(orderByAsc);
			} else if(orderByCol.equals("PortletOneId")){
			orderByComparator = new OrderByPortletOnePortletOneId(orderByAsc);
			} else if(orderByCol.equals("PortletOneDescription")){
			orderByComparator = new OrderByPortletOnePortletOneDescription(orderByAsc);
	    }
	    return orderByComparator;
	}
}

class OrderByPortletOnePortletOneId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "PortletOneId";

	public OrderByPortletOnePortletOneId(){
		this(false);
	}

	public OrderByPortletOnePortletOneId(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if(o1!=null) lo1 = (Long)o1;
		if(o2!=null) lo2 = (Long)o2;

		return lo1.compareTo(lo2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return PortletOneComparator.ORDER_BY_ASC;
		else return PortletOneComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByPortletOnePortletOneDescription extends OrderByComparator {
	public static String ORDER_BY_FIELD = "PortletOneDescription";

	public OrderByPortletOnePortletOneDescription(){
		this(false);
	}

	public OrderByPortletOnePortletOneDescription(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return PortletOneComparator.ORDER_BY_ASC;
		else return PortletOneComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}



