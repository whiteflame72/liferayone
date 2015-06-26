package com.test;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;

/**
 * Portlet implementation class NewPortlet
 */
public class NewPortlet extends MVCPortlet {

	public void init() throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		// helpJSP = getInitParameter("help-jsp");
		//
		// // View Mode Pages
		viewJSP = getInitParameter("view-jsp");
		//
		// // View Mode Edit PortletOne
		// editPortletOneJSP = getInitParameter("edit-PortletOne-jsp");
	}

	// protected String editPortletOneJSP;
	protected String editJSP;
	// protected String helpJSP;
	protected String viewJSP;

	private void saveAttributes(RenderRequest renderRequest) {
		renderRequest.getPortletSession().setAttribute("viewJSP", viewJSP);
		renderRequest.getPortletSession().setAttribute("editJSP", editJSP);
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		saveAttributes(renderRequest);

		// String jsp = (String) renderRequest.getParameter("view");
		// if (jsp == null || jsp.equals("")) {
		showViewDefault(renderRequest, renderResponse);
		// } else if (jsp.equalsIgnoreCase("editPortletOne")) {
		// try {
		// showViewEditPortletOne(renderRequest, renderResponse);
		// } catch (Exception ex) {
		// _log.debug(ex);
		// try {
		// showViewDefault(renderRequest, renderResponse);
		// } catch (Exception ex1) {
		// _log.debug(ex1);
		// }
		// }
		// }

		System.out.println("doView called viewJSP '" + viewJSP + "'");
	}

	@SuppressWarnings("unchecked")
	public void showViewDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

//		boolean hasAddPermission = permissionChecker.hasPermission(groupId,
//				"org.xmlportletfactory.portal.example01.model", groupId,
//				"ADD_PORTLETONE");

		// List<PortletOne> tempResults = Collections.EMPTY_LIST;
		// try {
		// String orderByType = renderRequest.getParameter("orderByType");
		// String orderByCol = renderRequest.getParameter("orderByCol");
		// OrderByComparator comparator =
		// PortletOneComparator.getPortletOneOrderByComparator(orderByCol,orderByType);
		// MultiVMPoolUtil.clear();
		//
		// tempResults = PortletOneLocalServiceUtil.findAllInGroup(groupId,
		// comparator);
		//
		// } catch (Exception e) {
		// _log.debug(e);
		// }
		renderRequest.setAttribute("highlightRowWithKey",
				renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart",
				renderRequest.getParameter("containerStart"));
		renderRequest.setAttribute("containerEnd",
				renderRequest.getParameter("containerEnd"));
		// renderRequest.setAttribute("tempResults", tempResults);
//		renderRequest.setAttribute("hasAddPermission", hasAddPermission);

		PortletURL addPortletOneURL = renderResponse.createActionURL();
		addPortletOneURL.setParameter("javax.portlet.action", "newPortletOne");
		renderRequest.setAttribute("addPortletOneURL",
				addPortletOneURL.toString());

		PortletURL PortletOneFilterURL = renderResponse.createRenderURL();
		PortletOneFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("PortletOneFilterURL",
				PortletOneFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		saveAttributes(renderRequest);

		showEditDefault(renderRequest, renderResponse);
		System.out.println("doEdit called editJSP '" + editJSP + "'");
	}

	public void showEditDefault(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		include(editJSP, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			// do nothing
			// _log.error(path + " is not a valid include");
		} else {
			System.out.println("NewPortlet:include viewJSP '" + viewJSP
					+ "' editJSP '" + editJSP + "'");
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	/**
	 * For file upload.
	 * 
	 * Reference:
	 * http://stackoverflow.com/questions/9929466/trouble-with-commons
	 * -fileupload-and-liferay
	 * http://www.liferay.com/community/forums/-/message_boards/message/6477988
	 * 
	 */
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		File uploadedFile = null;

		Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

		// Create a FileItemFactory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		PortletFileUpload upload = new PortletFileUpload(factory);
		upload.setSizeMax(67108864);

		//Create a progress listener
		ProgressListener progressListener = new ProgressListener(){
		   public void update(long pBytesRead, long pContentLength, int pItems) {
		       System.out.println("We are currently reading item " + pItems);
		       if (pContentLength == -1) {
		           System.out.println("So far, " + pBytesRead + " bytes have been read.");
		       } else {
		           System.out.println("So far, " + pBytesRead + " of " + pContentLength
		                              + " bytes have been read.");
		       }
		   }
		};
		upload.setProgressListener(progressListener);
		
		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(actionRequest);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;

		// Process the uploaded items
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = (FileItem) iter.next();

		    if (item.isFormField()) {
		        processFormField(item);
		    } else {
		        processUploadedFile(item);
		    }
		}	

	}

	private void processUploadedFile(FileItem item) {
		String fieldName = item.getFieldName();
	    String fileName = item.getName();
	    String contentType = item.getContentType();
	    boolean isInMemory = item.isInMemory();
	    long sizeInBytes = item.getSize();
	    File uploadedFile = new File(fileName);
	    
	    try {
			item.write(uploadedFile);
			//http://www.liferay.com/community/forums/-/message_boards/message/12845544
//			DLFileEntryServiceUtil.addFileEntry(groupId, repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, fileEntryTypeId, fieldsMap, file, is, size, serviceContext)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		    
	}

	private void processFormField(FileItem item) {
		// Process a regular form field
		if (item.isFormField()) {
		    String name = item.getFieldName();
		    String value = item.getString();
		}
	}



}
