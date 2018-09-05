package com.physical.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

public interface UploadMapper {

	ApiResult upload(HttpServletRequest request, HttpServletResponse response, String paramTip);

	ApiResult createImage();

	ApiResult downloadTest(HttpServletResponse response)throws LogicalException;

}
