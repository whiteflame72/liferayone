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

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import org.xmlportletfactory.portal.example01.model.PortletOne;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;

public class PortletOneValidator {

	public static ArrayList<String> validatePortletOne(PortletOne portletOne, ActionRequest request) throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		Properties props = new Properties();
		ClassLoader classLoader = PortletOneValidator.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("regexp.properties");
		props.load(is);


	//Field PortletOneDescription
	
	
		if(!validatePortletOneDescription(props, ParamUtil.getString(request, "PortletOneDescription"))){
		    errors.add("error");
		}
		if (Validator.isNull(portletOne.getPortletOneDescription())) {
			errors.add("PortletOne-PortletOneDescription-required");
		}
		return errors;
	}

	public static boolean validateEditPortletOne(
		String rowsPerPage, String dateFormat, String datetimeFormat, List errors) {
		boolean valid = true;
		if (Validator.isNull(rowsPerPage)) {
			errors.add("PortletOne-rows-per-page-required");
			valid = false;
		} else if (!Validator.isNumber(rowsPerPage)) {
			errors.add("PortletOne-rows-per-page-invalid");
			valid = false;
		} else if (Validator.isNull(dateFormat)) {
			errors.add("PortletOne-date-format-required");
			valid = false;
		} else if (Validator.isNull(datetimeFormat)) {
			errors.add("PortletOne-datetime_format.required");
			valid = false;
		}
		return valid;
	}

	//Field PortletOneId
	private static boolean validatePortletOneId(Properties props,String field) {
		boolean valid = true;
		try {
			Double.parseDouble(field);
		} catch (NumberFormatException nfe) {
		    valid = false;
		}
		return valid;
	}
	//Field PortletOneDescription
	private static boolean validatePortletOneDescription(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
}
