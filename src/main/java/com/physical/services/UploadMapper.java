package com.physical.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.physical.util.ApiResult;

public interface UploadMapper {

	ApiResult upload(HttpServletRequest request, HttpServletResponse response, String paramTip);

}
