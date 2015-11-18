package jp.co.fitec.training.project.typing.ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.traning.project.typing.service.GameServiceException;

public interface Controller {
	public String doAction(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, GameServiceException;
}
