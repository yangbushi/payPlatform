package com.defray.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.conn.ClientConnectionManager;  
import org.apache.http.conn.scheme.Scheme;  
import org.apache.http.conn.scheme.SchemeRegistry;  
import org.apache.http.conn.ssl.SSLSocketFactory;  
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
   

 

public class HttpUtil {
	private static final Logger LOG = LogManager.getLogger(HttpUtil.class);
	
	public enum METHOD {
		POST, GET, PUT, DELETE;
		public String value() {
			switch (this) {
			case POST:
				return "POST";
			case GET:
				return "GET";
			case PUT:
				return "PUT";
			case DELETE:
				return "DELETE";
			}
			return "POST";
		}
	}

	public static void ajaxOut(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> resultMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String callback = request.getParameter("callback");
		
		if (callback == null) {
			callback = "data";
		}
		PrintWriter out = response.getWriter();
		String rs = JsonUtil.toJson(resultMap);
		out.write(callback + "(" + rs + ");");
	}
	
	/**
	 * 输出json
	 * @param request
	 * @param response
	 * @param resultMap
	 * @throws IOException
	 */
	public static void jsonOut(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> resultMap){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String rs = JsonUtil.toJson(resultMap);
			out.write(rs);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		
	}
	
	/**
	 * 好像服务器返回的json格式，客户端还是要eval，弃用
	 * @param request
	 * @param response
	 * @param resultMap
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void ajaxOutJSONObject(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> resultMap)
			throws IOException, JSONException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String callback = request.getParameter("callback");
		LOG.debug("in ajaxout callback=" + callback);
		PrintWriter out = response.getWriter();
	//	String rs = JsonUtil.toJson(resultMap);
		JSONObject rj = new JSONObject(resultMap);
		out.write(callback + "(" + rj + ");");// 账户没有设定uid
	}
	
	/**
	 * ajax返回json格式数据
	 * @param request
	 * @param response
	 * @param str
	 * @throws IOException
	 */
	public static void ajaxOut(HttpServletRequest request,
			HttpServletResponse response, String str)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String callback = request.getParameter("callback");
		LOG.debug("in ajaxout callback=" + callback);
		PrintWriter out = response.getWriter();
		String rs = JsonUtil.toJson(str);
		out.write(callback + "(" + rs + ");");
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String JSONRequest(String url) {
		HttpClient client = new HttpClient(); 
	    HttpMethod method=new GetMethod(url);
	    String response="";
	    try {
	    	  int statusCode= client.executeMethod(method);
	    	  if (statusCode == HttpStatus.SC_OK) {
	    		  response=method.getResponseBodyAsString();
	    	  }
		} catch (  IOException e) {
			e.printStackTrace();
		}
	    method.releaseConnection();
		return response;
	}
	 
	public static String post(String apiUrl, Map<String, Object> params) {

		if (StringUtil.isEmpty(apiUrl)) {
			return null;
		}
		if (params == null) {
			return null;
		}
		String paramStr = CommentUtil.mapToUrl(params).substring(3);//JsonUtil.toJson(params);
		try {
			// Configure and open a connection to the site you will send the
			// request
			URL url = new URL(apiUrl);
			URLConnection urlConnection = url.openConnection();
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			urlConnection.setDoOutput(true);
			urlConnection.setConnectTimeout(20000);  
			urlConnection.setReadTimeout(300000); 
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			urlConnection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			// 得到请求的输出流对象
			OutputStreamWriter out = new OutputStreamWriter(
					urlConnection.getOutputStream(), "utf-8");
			// 把数据写入请求的Body
			out.write(paramStr);
			out.flush();
			out.close();

			// 从服务器读取响应
			InputStream inputStream = urlConnection.getInputStream();
			// String encoding = urlConnection.getContentEncoding();
			String body = IOUtils.toString(inputStream, "utf-8");
//			System.out.println(body);
			return body;
		} catch (IOException e) {
			// System.out.println(e);
			LOG.error(e);
		}

		return null;
	} 
	
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param apiUrl
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String get(String apiUrl, Map<String, Object> params, String charSet) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlName = apiUrl + CommentUtil.mapToUrl(params);
			URL url = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = url.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
//			Map<String, List<String>> map = conn.getHeaderFields();
//			// 遍历所有的响应头字段
//			for (String key : map.keySet()) {
//				System.out.println(key + "--->" + map.get(key));
//			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), charSet));
			String line;
			while ((line = in.readLine()) != null) {
				if("".equals(result)) {
					result = line;
				} else {
					result += "\n" + line;
				}			
			}
			
		} catch (Exception e) {
			LOG.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	} 
	
	public static String getHttpResponse(String url ){
		HttpClient client = new HttpClient(); 
	    HttpMethod method=new GetMethod(url);
	    String result;
	    try {
	    	  int statusCode= client.executeMethod(method);
	    	  if (statusCode == HttpStatus.SC_OK) {
	    		  result= null;
	    		InputStream in= method.getResponseBodyAsStream();
	    		result = getString(in);
	    	  } else{
	    		  result ="http no response";
	    	  }
		} catch (  IOException e) {
			e.printStackTrace();
			result="IOException";
		}
	    method.releaseConnection();
	    return result;
	}

	public static String getString(InputStream in){
		 BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(in,"gb2312"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			return "";
		}  
	        StringBuffer resBuffer = new StringBuffer();  
	        String resTemp = "";  
	        try {
				while((resTemp = br.readLine()) != null){  
				    resBuffer.append(resTemp);  
				}
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}  
	        String response = resBuffer.toString(); 
	        return response;
	}

	public static String request(String serviceUrl, String data, METHOD method,
			String datatype, int timeout) throws IOException {
		URL url = new URL(serviceUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method.value());
		connection.setRequestProperty("Content-Type", datatype);
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setConnectTimeout(timeout);//毫秒
		OutputStream os = connection.getOutputStream();
		os.write(data.getBytes("UTF-8"));
		os.flush();
		InputStream i = connection.getInputStream();
		BufferedReader ip = new BufferedReader(new InputStreamReader(i,"UTF-8"));
		StringBuffer sb = new StringBuffer();
		String tmp = ip.readLine();
		while (tmp != null) {
			sb.append(tmp);
			tmp = ip.readLine();
		}
		connection.disconnect();
		return sb.toString();
	}
	
	/**
	 * post请求
	 * @param url
	 * @param json
	 * @return
	 */
	
	public static String doPost(String url,JSONObject json){
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		String result = "";
		try {
			StringEntity s = new StringEntity(json.toString());
			s.setContentEncoding("utf-8");
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity entity = res.getEntity();
				result = EntityUtils.toString(entity,"utf-8");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	
	
	
	private static class TrustAnyTrustManager implements X509TrustManager {
		 
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
 
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
 
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }
 
    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
	
	/**
     * post方式请求服务器(https协议)
     * 
     * @param url
     *            请求地址
     * @param content
     *            参数
     * @param charset
     *            编码
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static byte[] httpsPost(String url, String content, String charset)
            throws Exception {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                new java.security.SecureRandom());
 
        URL console = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setRequestProperty("Content-Type", "utf-8");
        conn.setConnectTimeout(20000);  
        conn.setReadTimeout(300000); 
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setDoOutput(true); 
        conn.setUseCaches(false);  
        conn.setDoInput(true);
        conn.connect();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.write(content.getBytes(charset));
        // 刷新、关闭
        out.flush();
        out.close();       
        
        InputStream is = conn.getInputStream();
        if (is != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            return outStream.toByteArray();
        }
        return null;
    }
    
    //用于进行Https请求的HttpClient  
	private static class SSLClient extends DefaultHttpClient{  
        public SSLClient() throws Exception{  
            super();  
            SSLContext ctx = SSLContext.getInstance("TLS");  
            X509TrustManager tm = new X509TrustManager() {  
                    @Override  
                    public void checkClientTrusted(X509Certificate[] chain,  
                            String authType) throws CertificateException {  
                    }  
                    @Override  
                    public void checkServerTrusted(X509Certificate[] chain,  
                            String authType) throws CertificateException {  
                    }  
                    @Override  
                    public X509Certificate[] getAcceptedIssuers() {  
                        return null;  
                    }  
            };  
            ctx.init(null, new TrustManager[]{tm}, null);  
            SSLSocketFactory ssf = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
            ClientConnectionManager ccm = this.getConnectionManager();  
            SchemeRegistry sr = ccm.getSchemeRegistry();  
            sr.register(new Scheme("https", 443, ssf));  
        }  
    }
    
    public static String httpsPost(String url,Map<String,String> map,String charset){  
        SSLClient sslClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
        	sslClient = new SSLClient();  
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            Iterator iterator = map.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = sslClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    } 
	

	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("funcode", "100720");
		map.put("captcha", "token");
		Map<String, Object> subMap = new HashMap<String, Object>();
		subMap.put("sysCode", "1001001");
		subMap.put("hosId", "342");
		subMap.put("psnId", "1234");
		subMap.put("orderId", "123");
		subMap.put("payState", "0");
		subMap.put("payDate", TimeUtil.getInt());
		subMap.put("transactNo", "123456");
		subMap.put("payType", "10");
		subMap.put("orderAmount", "1.0");
		map.put("args", subMap);
		String requestStr = JSON.toJSON(map).toString();	
		try {
			System.out.println(httpsPost("https://phs.eheren.com/hosws/services/f/100722", requestStr, "utf-8").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
