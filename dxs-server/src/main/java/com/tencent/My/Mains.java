package com.tencent.My;

import com.tencent.common.MD5;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;

/**
 * 分析链接
 * https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&srcqid=499958200548323857&
 * tn=50000021_hao_pg&wd=java%E5%BC%80%E5%8F%91%E5%BE%AE%E4%BF%A1%E6%89%AB%
 * E7%A0%81%E6%94%AF%E4%BB%98demo%E4%B8%AD%E7%9A%84%E7%BB%9F%E4%B8%80%E4%B8%
 * 8B%E5%8D%95%E6%97%B6%E9%82%A3%E4%B8%AA%E6%8E%A5%E5%8F%A3&oq=java%E5%BC%80%
 * E5%8F%91%E5%BE%AE%E4%BF%A1%E6%89%AB%E7%A0%81%E6%94%AF%E4%BB%98&rsv_pq=e34ed7cb0000db52&
 * rsv_t=91faVzsAS2uFWmkopkq8XBmeuC0PnCJWSI9czCwXKCKFIOnEMF1XLBSC0SGIgjNrU9%
 * 2BtnDoR&rqlang=cn&rsv_enter=1&rsv_sug3=14&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&
 * inputT=30093&rsv_sug4=31539&rsv_sug=1
 * 主入口
 *
 * 微信支付分析：http://www.2cto.com/kf/201606/514199.html
 * Created by HongXinGuoJi-yzg on 2016/12/16.
 */
@Controller
@RequestMapping("/mains")
public class Mains {

    /**
     * 准备：根据统一下单接口API我先定义了三个对象：UnifiedOrderRequest（统一下单请求参数(必填)）、
     * UnifiedOrderRequestExt（统一下单请求参数(非必填)）、UnifiedOrderRespose（统一下单返回参数）；
     * 具体如下代码，get、set方法可自行生产，太占篇幅。
     *
     * UnifiedOrderRequest.class        (必填)
     * UnifiedOrderRequestExt.class     (非必填)
     * UnifiedOrderRespose              (统一返回参数)
     */



    /**
     * 创建二维码
     */
    /*@RequestMapping("createQRCode")
    public void createQRCode(String orderId, HttpServletResponse response) {

        //生成订单
        String orderInfo = createOrderInfo(orderId);
        //调统一下单API
        String code_url = httpOrder(orderInfo);
        //将返回预支付交易链接（code_url）生成二维码图片
        //这里使用的是zxing   说明1(见文末)
        try {
            int width = 200;
            int height = 200;
            String format = "png";
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(code_url, BarcodeFormat.QR_CODE, width, height, hints);
            OutputStream out = null;
            out = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, format, out);

            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }*/



   /**
    * 生成订单:分两部分：一部分是业务需求的订单信息，就是发起支付前的订单信息，
    * 业务系统自行创建存储；另一部分是满足统一下单API要求的订单信息（也是我们这里要讲的）。
    * “xxxxxx”:是你需要自己填写的对应信息：
    * @param orderId
    * @return
    */
    /*private String createOrderInfo(String orderId) {
        //生成订单对象
        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        unifiedOrderRequest.setAppid("xxxxxxxxxxxxx");//公众账号ID
        unifiedOrderRequest.setMch_id("xxxxxxxxx");//商户号
        unifiedOrderRequest.setNonce_str(StringUtil.makeUUID());//随机字符串       说明2(见文末)
        unifiedOrderRequest.setBody("xxxxxx");//商品描述
        unifiedOrderRequest.setOut_trade_no(orderId);//商户订单号
        unifiedOrderRequest.setTotal_fee("x");	//金额需要扩大100倍:1代表支付时是0.01
        unifiedOrderRequest.setSpbill_create_ip("xxxxxxxxxxxxx");//终端IP
        unifiedOrderRequest.setNotify_url("xxxxxxxxxxxxxx");//通知地址
        unifiedOrderRequest.setTrade_type("NATIVE");//JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
        unifiedOrderRequest.setSign(createSign(unifiedOrderRequest));//签名说明5(见文末，签名方法一并给出)
        //将订单对象转为xml格式
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_"))); //说明3(见文末)
        xStream.alias("xml", UnifiedOrderRequest.class);//根元素名需要是xml
        return xStream.toXML(unifiedOrderRequest);
    }*/


    /**
     * 调统一下单API:
     *
     *   根据要求将生成订单中返回的xml向微信给定的统一下单URL地址：
     *      https://api.mch.weixin.qq.com/pay/unifiedorder，发送请求，成功并获得二维码。
     * @param orderInfo
     * @return
     */
    private String httpOrder(String orderInfo) {
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            //加入数据
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
            buffOutStr.write(orderInfo.getBytes());
            buffOutStr.flush();
            buffOutStr.close();

            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line = reader.readLine())!= null){
                sb.append(line);
            }

            XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));//说明3(见文末)
            //将请求返回的内容通过xStream转换为UnifiedOrderRespose对象
            xStream.alias("xml", UnifiedOrderRespose.class);
            UnifiedOrderRespose unifiedOrderRespose = (UnifiedOrderRespose) xStream.fromXML(sb.toString());

            //根据微信文档return_code 和result_code都为SUCCESS的时候才会返回code_url
            //说明4(见文末)
            if(null!=unifiedOrderRespose
                    && "SUCCESS".equals(unifiedOrderRespose.getReturn_code())
                    && "SUCCESS".equals(unifiedOrderRespose.getResult_code())){
                return unifiedOrderRespose.getCode_url();
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建UUID
     *   随机字符串：微信对随机字符串的要求是不超过32位。我这边是这样生成的，用时间戳。
     * @return
     */
    /*public static synchronized String makeUUID() {
        Date date = new Date();
        StringBuffer s = new StringBuffer(DateUtil.formatYmdhmsm(date));
        return s.append((new Random().nextInt(900) + 100)).toString();
    }*/


    /**
     * 生成签名
     *
     * @param appid_value
     * @param mch_id_value
     * @param productId
     * @param nonce_str_value
     * @param trade_type
     * @param notify_url
     * @param spbill_create_ip
     * @param total_fee
     * @param out_trade_no
     * @return
     */
    /*private String createSign(UnifiedOrderRequest unifiedOrderRequest) {
        //根据规则创建可排序的map集合
        SortedMap packageParams = new TreeMap();
        packageParams.put("appid", unifiedOrderRequest.getAppid());
        packageParams.put("body", unifiedOrderRequest.getBody());
        packageParams.put("mch_id", unifiedOrderRequest.getMch_id());
        packageParams.put("nonce_str", unifiedOrderRequest.getNonce_str());
        packageParams.put("notify_url", unifiedOrderRequest.getNotify_url());
        packageParams.put("out_trade_no", unifiedOrderRequest.getOut_trade_no());
        packageParams.put("spbill_create_ip", unifiedOrderRequest.getSpbill_create_ip());
        packageParams.put("trade_type", unifiedOrderRequest.getTrade_type());
        packageParams.put("total_fee", unifiedOrderRequest.getTotal_fee());

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();//字典序
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            //为空不参与签名、参数名区分大小写
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        //第二步拼接key，key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
        sb.append("key=" +"xxxxxxxxxxxxxxxxx");
        String sign = MD5.MD5Encode(sb.toString(), "utf-8")
                .toUpperCase();//MD5加密
        return sign;
    }*/
}
