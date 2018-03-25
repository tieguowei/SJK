package com.resale.background.service;

import java.util.Map;

import com.resale.background.util.PageModel;

public interface CategoryService {
	
	PageModel getCategorytList(Map<String, Object> paramsCondition);

}
