package com.chinamobile.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinamobile.dao.ResourceDao;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.jspsmart.upload.File;
public class ResourceAddFromTxtServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		
		//����������ļ�����
		su.setAllowedFilesList("txt");
		try {
			su.upload();
			//save��������"/"��ͷ����ʾ��ǰ����Ŀ����upload�ļ�����Ҫ�ȴ�����
			su.save("/upload");
			File file = su.getFiles().getFile(0);
			String fileName = file.getFileName();
			System.out.println(fileName);
			
			//��Ҫһ������·��
			String realPath = this.getServletContext().getRealPath("\\upload")+"\\"+fileName;
			System.out.println(realPath);
			//1.����һ��io���е�File����
			java.io.File file1 = new java.io.File(realPath);
			BufferedReader reader = null;
			
			FileReader fileReader = new FileReader(file1);
			reader = new BufferedReader(fileReader);
			
			//����һ��
			/*System.out.println(reader.readLine());
			System.out.println(reader.readLine());
			System.out.println(reader.readLine());
			System.out.println(reader.readLine());//����null
			 */
			
			String type = reader.readLine();//����һ��,��SIM������UIM������type
			
			//����ÿһ�ж���һ������
			String s = "";
			//String phoneStr = "";
			ArrayList<String> phoneList = new ArrayList<String>();
			while(  (s= reader.readLine()) != null){
				//phoneStr = phoneStr +"," +s;
				phoneList.add(s);
			}
			
			System.out.println(phoneList);
			
			ResourceDao rDao = new ResourceDao();
			int r =rDao.addResource(type,phoneList );
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
	

}
