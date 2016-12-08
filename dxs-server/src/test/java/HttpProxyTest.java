import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpProxyTest {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        // TODO Auto-generated method stub
        //
        // HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // // HttpClient
        // CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        // HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
        // RequestConfig config =
        // RequestConfig.custom().setProxy(proxy).build();
        //
        // HttpPost httpPost = new HttpPost("http://www.baidu.com/");
        // httpPost.setConfig(config);
        // // httpPost.setEntity(output);
        // HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
        // int code = httpResponse.getStatusLine().getStatusCode();
        // System.out.println(code);
        // test();
        testReq();
    }

    public static void testReq() {
        HttpClient httpClient = new DefaultHttpClient();
        File path = new File("F:\\pptt\\9500\\post\\");
        try {
            iterDir(path, httpClient);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void iterDir(File path, HttpClient httpClient) throws IOException {
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            for (File f : files) {
                iterDir(f, httpClient);
            }
        } else {
            try {
                byte[] b = FileUtils.readFileToByteArray(path);
                HttpPost post = new HttpPost("http://localhost:9500/");
                HttpEntity entity=new ByteArrayEntity(b);
                post.setEntity(entity);
                HttpResponse resp = httpClient.execute(post);
                InputStream in = resp.getEntity().getContent();
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    bout.write(b, 0, len);
                }
                System.out.println(path+"::"+bout.toString());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void test() {
        final String url = "http://115.29.246.99:8080/pay";
        final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><request><paycode>2000000056</paycode><imei>${imei}</imei><imsi>${imsi}</imsi><channel>700000231</channel><userdata>10002</userdata><ip>192.168.0.1</ip></request>";
        String paycode = "2000000056";
        String imsi = null;
        String imei = null;
        String ip = "192.168.0.1";
        ExecutorService service = Executors.newFixedThreadPool(1);
        final HttpClient client = new DefaultHttpClient();

        for (int i = 0; i < 10; i++) {
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    HttpPost post = new HttpPost(url);
                    HttpEntity entity;
                    try {
                        String body = xml.replaceAll("${imsi}", randomImsi()).replaceAll("${imei}", randomImei());
                        entity = new StringEntity(body);
                        post.setEntity(entity);
                        HttpResponse resp = client.execute(post);
                        InputStream in = resp.getEntity().getContent();
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        byte[] b = new byte[1024];
                        int len = 0;
                        while ((len = in.read(b)) != -1) {
                            bout.write(b, 0, len);
                        }
                        System.out.println(bout.toString());
                    } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ClientProtocolException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            service.submit(r);
        }
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String randomImsi() {
        String imsi = "460020";
        Random r = new Random();
        imsi += r.nextInt(999999999);
        while (imsi.length() < 15) {
            imsi += 0;
        }
        return imsi;
    }

    public static String randomImei() {
        String imsi = "83020";
        Random r = new Random();
        imsi += r.nextInt(999999999);
        while (imsi.length() < 15) {
            imsi += 0;
        }
        return imsi;
    }

}
