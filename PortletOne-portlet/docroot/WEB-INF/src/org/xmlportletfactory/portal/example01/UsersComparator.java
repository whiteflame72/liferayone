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
import org.xmlportletfactory.portal.example01.model.Users;

public class UsersComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getUsersOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderByUsersUsersId(orderByAsc);
			} else if(orderByCol.equals("usersId")){
			orderByComparator = new OrderByUsersUsersId(orderByAsc);
			} else if(orderByCol.equals("userName")){
			orderByComparator = new OrderByUsersUserName(orderByAsc);
		    }
	    return orderByComparator;
	}
}

class OrderByUsersUsersId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "usersId";

	public OrderByUsersUsersId(){
		this(false);
	}

	public OrderByUsersUsersId(boolean asc){
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
		if(_asc) return UsersComparator.ORDER_BY_ASC;
		else return UsersComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderByUsersUserName extends OrderByComparator {
	public static String ORDER_BY_FIELD = "userName";

	public OrderByUsersUserName(){
		this(false);
	}

	public OrderByUsersUserName(boolean asc){
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
		if(_asc) return UsersComparator.ORDER_BY_ASC;
		else return UsersComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}



