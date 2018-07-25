package com.physical.services.imp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.physical.services.UploadMapper;
import com.physical.util.ApiResult;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class UploadServiceImp implements UploadMapper {

	@Override
	public ApiResult upload(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (request.getCharacterEncoding() == null) {
				request.setCharacterEncoding("UTF-8");// 你的编码格式
			}
			Iterator<String> itr = ((MultipartHttpServletRequest) request).getFileNames();
			Map<String, MultipartFile> itrs = ((MultipartHttpServletRequest) request).getFileMap();
			String fileName = "";
			String fileNameKey = "";
			while (itr.hasNext()) {
				fileNameKey = itr.next(); // 原来的文件名的key
				MultipartFile file2 = itrs.get(fileNameKey);
				fileName = file2.getOriginalFilename(); // 原文件名
			}
			
			MultipartFile file = ((MultipartHttpServletRequest) request).getFile(fileNameKey);
			InputStream stream = file.getInputStream();
			File ff = new File("/www/images/"+fileName);
			Thumbnails.of(stream).scale(1f).outputQuality(0.5f).toFile(ff);
			
			String url = "http://119.29.108.164:90/image/"+fileName;
			return ApiResult.success(url);
		} catch (Exception e) {
		}
		return ApiResult.success();
	}

}
