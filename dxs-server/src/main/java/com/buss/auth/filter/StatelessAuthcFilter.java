package com.buss.auth.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

public class StatelessAuthcFilter extends AccessControlFilter {
	 
     
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

	@SuppressWarnings("unchecked")
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	return true;
        
    }


}