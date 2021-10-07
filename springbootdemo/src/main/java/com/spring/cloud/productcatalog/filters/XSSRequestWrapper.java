package com.spring.cloud.productcatalog.filters;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.input.BoundedInputStream;


public class XSSRequestWrapper extends HttpServletRequestWrapper {
	private StringBuilder body;
	public static final Integer MAX_BYTE_SIZE = 1_048_576; 
	
	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
		
		body = new StringBuilder("");
	    try (
	        InputStream bounded = new BoundedInputStream(request.getInputStream(), MAX_BYTE_SIZE);
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bounded));){
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            body.append(line);
	        }
	    } catch(Exception e) {
	       e.printStackTrace();
	    }
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		String strippedBody=stripXSS(body.toString());
	    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(strippedBody.getBytes());
	    return new ServletInputStream() {
	        public int read() throws IOException {
	            return byteArrayInputStream.read();
	        }
	        @Override
	        public boolean isFinished() {
	            return byteArrayInputStream.available() == 0;
	        }
	        @Override
	        public boolean isReady() {
	            return true;
	        }
	        @Override
	        public void setReadListener(ReadListener readListener) {
	            //do nothing
	        }
	    };
	}
	@Override
	public BufferedReader getReader() throws IOException {
	    return new BufferedReader(new InputStreamReader(this.getInputStream()));
	 }

	private String stripXSS(String value) {
		if (value != null) {
			// NOTE: It's highly recommended to use the ESAPI library and uncomment the
			// following line to
			// avoid encoded attacks.
			//value = ESAPI.encoder().canonicalize(value);
			//System.out.println("Formatted value is ..." + value);
			// Avoid null characters
			
			// Avoid null characters
            value = value.replaceAll("", "");
 
            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
 
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
 
            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
			 
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String parameter) {
		System.out.println("getParameterValues.... ");
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		String[] strippedValues = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			strippedValues[i] = stripXSS(values[i]);
		}
		return strippedValues;
	}

	@Override
	public String getParameter(String parameter) {
		System.out.println("getParameter.... ");
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		String strippedValue = stripXSS(value);
		return strippedValue;
	}

}
