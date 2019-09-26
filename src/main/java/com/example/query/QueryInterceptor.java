package com.example.query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class QueryInterceptor implements HandlerInterceptor {

	private String queryString;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		queryString = request.getQueryString();
		return true;
	}

	public String getQueryString() {
		return queryString;
	}
}
