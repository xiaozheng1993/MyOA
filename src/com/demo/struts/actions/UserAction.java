package com.demo.struts.actions;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.dao.UserDAO;
import com.demo.struts.forms.PageForm;
import com.demo.struts.forms.UserForm;
import com.demo.struts.util.Constants;
import com.demo.struts.util.Pager;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserAction extends BaseAction {

	protected UserDAO userDAO;

	Logger log = Logger.getLogger(this.getClass());

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
							  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PageForm pageForm = (PageForm) form;

		// get pager
		Pager pager = userDAO.findPager(pageForm.getPageSize(), pageForm
				.getPageNo());

		// set meetingList
		request.setAttribute("UserList", pager.getResultList());

		// set pager
		request.setAttribute("pager", pager);

		// save session
		setSession(request, Constants.PAGER_ADDRESS, pageForm);

		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PageForm pageForm = (PageForm) getSession(request,
				Constants.PAGER_ADDRESS);

		// get pager
		Pager pager = userDAO.findPager(pageForm.getPageSize(), pageForm
				.getPageNo());

		// set meetingList
		request.setAttribute("meetingList", pager.getResultList());

		// set pager
		request.setAttribute("pager", pager);

		// save session
		setSession(request, Constants.PAGER_ADDRESS, pageForm);

		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = mapping.findForward(Constants.ADD_KEY);
		return (forward);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		UserForm userForm = (UserForm) form;
		String username = getUsername(request);

		// insert object
		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setEmail(userForm.getEmail());
		user.setUserTypeName(userForm.getUserTypeName());
		user.setUserTypeId(Integer.valueOf(userForm.getUserTypeId()));
		/*用户注册时给用户表增加注册时间*/
		Date nowTimes = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(nowTimes);
		Date crateDate = sdf.parse(nowTime);
		user.setCreateDate(crateDate);


		userDAO.insertUser(user);

		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"user.message.add.success"));
		saveErrors(request, messages);

		// get pageform from session
		PageForm pageForm = (PageForm) getSession(request,
				Constants.PAGER_ADDRESS);

		// get pager form list page
		Pager pager = userDAO.findPager(pageForm.getPageSize(), pageForm
				.getPageNo());
		request.setAttribute("meetingList", pager.getResultList());
		request.setAttribute("pager", pager);

		return mapping.findForward(Constants.LIST_KEY);
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		String id = request.getParameter("id");

		if (id == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"user.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			User user = userDAO.findById(id);
			if (user == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"user.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}

			// save form object
			UserForm userForm = new UserForm();
			userForm.setId(user.getId().toString());
			userForm.setUsername(user.getUsername());
			userForm.setEmail(user.getEmail());
			userForm.setUserTypeName(user.getUserTypeName());
			userForm.setUserTypeId(user.getUserTypeId().toString());
			userForm.setCreateDate(user.getCreateDate().toString());


			// save in request
			request.setAttribute("userFormBean", userForm);

			return mapping.findForward(Constants.EDIT_KEY);
		}
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		/*MeetingForm meetingForm = (MeetingForm) form;
		Meeting meeting = new Meeting();

		// update object
		meeting.setId(new Integer(meetingForm.getId()));
		meeting.setSender(meetingForm.getSender());
		meeting.setStarttime(meetingForm.getStarttime());
		meeting.setEndtime(meetingForm.getEndtime());
		meeting.setAddress(meetingForm.getAddress());
		meeting.setTitle(meetingForm.getTitle());
		meeting.setContent(meetingForm.getContent());
		userDAO.u(meeting);

		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"meeting.message.edit.success"));
		saveErrors(request, messages);

		// get pageForm from session
		PageForm pageForm = (PageForm) getSession(request,
				Constants.PAGER_ADDRESS);

		// get pager form list page
		Pager pager = meetingDAO.findPager(pageForm.getPageSize(), pageForm
				.getPageNo());
		request.setAttribute("meetingList", pager.getResultList());
		request.setAttribute("pager", pager);

		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);*/
		return null;
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();

		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"meeting.message.edit.notexist"));
		} else {
			/*// delete object
			meetingDAO.delete(id);

			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"meeting.message.delete.success"));

			// get pageForm from session
			PageForm pageForm = (PageForm) getSession(request,
					Constants.PAGER_ADDRESS);

			// get pager form list page
			Pager pager = meetingDAO.findPager(pageForm.getPageSize(), pageForm
					.getPageNo());
			request.setAttribute("meetingList", pager.getResultList());
			request.setAttribute("pager", pager);*/
		}
		saveErrors(request, messages);
		return mapping.findForward(Constants.LIST_KEY);
	}
}
