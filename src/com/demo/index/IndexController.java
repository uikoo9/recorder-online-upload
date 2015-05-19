package com.demo.index;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index() {
		setAttr("base", getHttpPath(getRequest()));
		render("/WEB-INF/view/index.html");
	}
	private String getHttpPath(HttpServletRequest request){
		StringBuilder path = new StringBuilder();
		
		path.append(request.getScheme() + "://");
		path.append(request.getServerName() + ":");
		path.append(request.getServerPort());
		path.append(request.getContextPath());
		
		return path.toString();
	}
	
	/**
	 * 在线上传音频示例
	 * @throws Exception
	 */
	public void qrecord() throws Exception{
		Iterator<FileItem> iter = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(getRequest()).iterator();
		while (iter.hasNext()) {
		    FileItem item = iter.next();

		    if(!item.isFormField()){
		    	// 保存文件，简单的保存到本地，可以自行修改
		    	item.write(new File("d://" + item.getName()));
		    }
		}
		
		// 返回值，1是成功
		renderJson("{\"saved\": 1}");
	}
	
}