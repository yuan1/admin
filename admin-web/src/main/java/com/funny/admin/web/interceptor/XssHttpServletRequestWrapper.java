package com.funny.admin.web.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.util.HtmlUtils;

/**
 * @author funny
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
    }

    /**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    private static String xssEncode(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
//		StringReader reader = new StringReader(s);
//		StringWriter writer = new StringWriter();
//		try {
//			HTMLParser.process(reader, writer, new XSSFilter(), true);
//			return writer.toString();
//		} catch (NullPointerException e) {
//			return s;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
        return s;
    }
    private String cleanXSS(String value) {
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return escapeSql(HtmlUtils.htmlEscape(value));
    }

    public static String escapeSql(String str) {
        return str == null?null: str.replace("\'", "\'\'");
    }
}
