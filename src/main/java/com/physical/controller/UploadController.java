package com.physical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.physical.services.UploadMapper;
import com.physical.util.ApiResult;

@RestController
@RequestMapping("file")
public class UploadController {

	@Autowired
	private UploadMapper uploadMapper;

	@RequestMapping(value = "upload", method = { RequestMethod.POST })
	public ApiResult upload(HttpServletRequest request, HttpServletResponse response, String paramTip) {

		return uploadMapper.upload(request, response, paramTip);
	}

	@RequestMapping(value = "createImage", method = { RequestMethod.POST })
	public ApiResult createImage() {

		return uploadMapper.createImage();
	}

	@RequestMapping(value = "downloadTest", method = { RequestMethod.POST })
	public ApiResult downloadTest(HttpServletResponse response) {
		try {
			return uploadMapper.downloadTest(response);
		} catch (Exception e) {
			return ApiResult.fail("操作失败");
		}

	}
}
