package com.chanyun.common.util;

import com.chanyun.common.constants.WeChatPayConstants;
import com.chanyun.common.constants.WechatKeyConstants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Map;

/**
 * @author hao.li
 * @date 2017年8月21日
 * @version 1.0.0
 * @description 微信请求工具类
 */
public class WeChatPayRequestUtil {

    /**
     * 请求，只请求一次，不做重试
     * 
     * @param weixinPayApiUrl
     * @param data
     * @param connectTimeoutMs
     * @param readTimeoutMs
     * @param useCert
     *            是否使用证书，针对退款、撤销等操作
     * @return
     * @throws Exception
     */

    public String requestOnce(String weixinPayApiUrl, String data, int connectTimeoutMs, int readTimeoutMs, boolean useCert,
                    byte[] weixinCert) throws Exception {

        BasicHttpClientConnectionManager connManager;
        Map<String, String> dataMap = WeChatPayUtil.xmlToMap(data);
        if (useCert) {
            // 证书
            char[] password = dataMap.get(WechatKeyConstants.MCH_ID).toCharArray();
            //            File file = new File(certUrl);
            //            InputStream certStream = new FileInputStream(file);
            InputStream certStream = new ByteArrayInputStream(weixinCert);
            KeyStore ks = KeyStore.getInstance(WeChatPayConstants.PKCS12);
            ks.load(certStream, password);

            // 实例化密钥库 & 初始化密钥工厂
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, password);

            // 创建 SSLContext
            SSLContext sslContext = SSLContext.getInstance(WeChatPayConstants.TLS);
            sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" },
                            null, new DefaultHostnameVerifier());

            connManager = new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory> create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslConnectionSocketFactory)
                            .build(), null, null, null);
        } else {
            connManager = new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory> create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", SSLConnectionSocketFactory.getSocketFactory()).build(), null, null, null);
        }

        HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connManager).build();

        HttpPost httpPost = new HttpPost(weixinPayApiUrl);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
        httpPost.setConfig(requestConfig);
        data = WeChatPayUtil.mapToXml(dataMap);
        StringEntity postEntity = new StringEntity(data, WeChatPayConstants.UTF8);
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", "wechatpay sdk java v1.0 " + dataMap.get(WechatKeyConstants.MCH_ID));
        httpPost.setEntity(postEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, WeChatPayConstants.UTF8);

    }

}
