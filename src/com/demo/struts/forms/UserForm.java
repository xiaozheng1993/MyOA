package com.demo.struts.forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = -7819458651912123880L;

	protected String id = null;

	protected String username = null;

	protected String email = null;

	protected String userTypeName = null;

	protected String userTypeId = null;

	protected String createDate = null;

	protected String password = null;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")
				|| queryString.equalsIgnoreCase("method=update")) {			
			if (username == null || username.equals("")) {
				errors.add("username", new ActionMessage("user.error.username"));
			}
			
			if (email == null || email.equals("")) {
				errors.add("email", new ActionMessage("user.error.email"));
			}

			if (userTypeName == null || userTypeName.equals("")) {
				errors.add("userTypeName", new ActionMessage("user.error.userTypeName"));
			}

			if (password == null || password.equals("")) {
				errors.add("password", new ActionMessage("user.error.password"));
			}
		}
		arg1.setAttribute("UserFormBean", this);
		return errors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
