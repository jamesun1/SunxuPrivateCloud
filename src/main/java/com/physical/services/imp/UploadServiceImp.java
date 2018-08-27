package com.physical.services.imp;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.jdbc.StringUtils;
import com.physical.services.UploadMapper;
import com.physical.util.ApiResult;
import com.physical.util.ImageCode;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class UploadServiceImp implements UploadMapper {

	@Override
	public ApiResult upload(HttpServletRequest request, HttpServletResponse response, String paramTip) {
		try {
			if (request.getCharacterEncoding() == null) {
				request.setCharacterEncoding("UTF-8");// 你的编码格式
			}
			Iterator<String> itr = ((MultipartHttpServletRequest) request).getFileNames();
			Map<String, MultipartFile> itrs = ((MultipartHttpServletRequest) request).getFileMap();
			String fileName = UUID.randomUUID().toString()+".jpg";
			String fileNameKey = "";
			while (itr.hasNext()) {
				fileNameKey = itr.next(); // 原来的文件名的key
			}

			MultipartFile file = ((MultipartHttpServletRequest) request).getFile(fileNameKey);
			InputStream stream = file.getInputStream();
			File ff = new File("/www/images/" + fileName);
			float f ;
			if(StringUtils.isNullOrEmpty(paramTip)) {
				f = 10.00f;
			}else {
				f = Integer.valueOf(paramTip)/100f;
			}
			Thumbnails.of(stream).scale(1f).outputQuality(0.5f).toFile(ff);

			String url = "http://119.29.108.164:90/image/" + fileName;
			return ApiResult.success(url);
		} catch (Exception e) {
		}
		return ApiResult.success();
	}

	@Override
	public ApiResult createImage() {
        try {
        	ImageCode imagecode=new ImageCode();
            BufferedImage img=imagecode.getImage();
            String name = UUID.randomUUID().toString()+".jpg";;
			imagecode.saveImage(img, new FileOutputStream("/home/images/"+name));
			String url = "http://119.29.108.164:90/home/" + name;
			return ApiResult.success(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
