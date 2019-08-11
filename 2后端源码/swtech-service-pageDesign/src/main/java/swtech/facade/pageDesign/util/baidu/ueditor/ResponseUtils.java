package swtech.facade.pageDesign.util.baidu.ueditor;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 林致杰
 *
 * @version 1.0
 *
 *          创建时间：2018年1月8日 下午7:40:42
 *
 *          res响应类
 *
 */

public class ResponseUtils {
	private ResponseUtils() {

	}

	// 发送内容 "application/json;charset=UTF-8"
	public static void render(HttpServletResponse response, String contentType,
			String text) {
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 发送的是JSON
	public static void renderJSON(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}

	// 发送xml
	public static void renderXml(HttpServletResponse response, String text) {
		render(response, "application/xml;charset=UTF-8", text);
	}

	// 发送text
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "application/plain;charset=UTF-8", text);
	}
}
