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
				fileName = fileName.substring(0, fileName.lastIndexOf('.')); // 原文件名去掉后缀
			}
			MultipartFile file = ((MultipartHttpServletRequest) request).getFile(fileNameKey);
			InputStream stream = file.getInputStream();
			File ff = new File("D:/aa.jpg");
			Thumbnails.of(stream).scale(1f).outputQuality(0.5f).toFile(ff);

			InputStream fis = new FileInputStream(ff);
			byte[] bt = new byte[fis.available()];
			fis.read(bt);
			fis.close();
			
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("文件".getBytes("utf-8"),"iso8859-1"));
			response.addHeader("Content-Length", "" + ff.length());
			response.setHeader("Access-Control-Allow-Origin", "*");
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			os.write(bt);// 输出文件
            os.flush();
            os.close();
            
//			FileOutputStream outStream = new FileOutputStream(ff); //文件输出流将数据写入文件
//            outStream.write(bt);
//            outStream.close();
		} catch (Exception e) {
		}
		return ApiResult.success();
	}

}
