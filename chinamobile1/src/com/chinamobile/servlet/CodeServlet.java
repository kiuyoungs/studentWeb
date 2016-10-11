package com.chinamobile.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ΪͼƬ��ʽ
		response.setContentType("image/jpeg");
		int width = 80;
		int height = 30;
		
		int imageType = BufferedImage.TYPE_INT_RGB;
		
		//1.����һ��BufferedImage����
		BufferedImage img = new BufferedImage(width, height, imageType);
		
		//2.��ȡ�滭�������Ķ��󣨻�����
		Graphics g = img.getGraphics();
		
		//3.���û����ε���ɫ
		Color c  = Color.gray;
		g.setColor(c);
		
		//4.������
		g.fillRect(0, 0, width, height);
		
		//5.��һ����ɫ
		Color c1  = Color.black;
		g.setColor(c1);
		
		Random r = new Random();
		
		//6.������
/*		for(int i=0; i <4; i++){
			int x = r.nextInt(10);
			g.drawString(x+"", 5+20*i, 18);
		}*/
		
		//����д��ĸ
	/*	for(int i=0; i <4; i++){
			char x = (char) (65 + r.nextInt(26));
			g.drawString(x +"" , 5+20*i, 18);
		}*/
		
		//������
		String str = "Ү³�ı�ҵ�����Һܱ�Ǹ--������ǲ�ϲ�������Ŀ�" +
				"������������Ϊ��" +
				"��һ��������úÿ�һ����Χ��һ��վ������ߵ�ͬѧ��" +
				"һ��վ�����ұߵ�ͬѧ�����������������";
		
		//������ȷ����֤��
		String realCode = "";
		
		for(int i=0; i <4; i++){
			int index = r.nextInt(str.length());
			char x = str.charAt(index);
			realCode += x;
			g.drawString(x +"" , 5+20*i, 18);
		}
		
		//д��session��
		HttpSession session = request.getSession();
		session.setAttribute("realCode", realCode);
		
		//7.���ͼƬ
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

}
