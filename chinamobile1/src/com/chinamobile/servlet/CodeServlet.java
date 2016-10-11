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
		//设置输出为图片格式
		response.setContentType("image/jpeg");
		int width = 80;
		int height = 30;
		
		int imageType = BufferedImage.TYPE_INT_RGB;
		
		//1.创建一个BufferedImage对象
		BufferedImage img = new BufferedImage(width, height, imageType);
		
		//2.获取绘画的上下文对象（画布）
		Graphics g = img.getGraphics();
		
		//3.设置画矩形的颜色
		Color c  = Color.gray;
		g.setColor(c);
		
		//4.画矩形
		g.fillRect(0, 0, width, height);
		
		//5.换一种颜色
		Color c1  = Color.black;
		g.setColor(c1);
		
		Random r = new Random();
		
		//6.画数字
/*		for(int i=0; i <4; i++){
			int x = r.nextInt(10);
			g.drawString(x+"", 5+20*i, 18);
		}*/
		
		//画大写字母
	/*	for(int i=0; i <4; i++){
			char x = (char) (65 + r.nextInt(26));
			g.drawString(x +"" , 5+20*i, 18);
		}*/
		
		//画汉字
		String str = "耶鲁的毕业生们我很抱歉--如果你们不喜欢这样的开" +
				"匙我想请你们为我" +
				"做一件事请你好好看一看周围看一看站在你左边的同学看" +
				"一看站在你右边的同学请你设想这样的情况";
		
		//保存正确的验证码
		String realCode = "";
		
		for(int i=0; i <4; i++){
			int index = r.nextInt(str.length());
			char x = str.charAt(index);
			realCode += x;
			g.drawString(x +"" , 5+20*i, 18);
		}
		
		//写到session中
		HttpSession session = request.getSession();
		session.setAttribute("realCode", realCode);
		
		//7.输出图片
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

}
