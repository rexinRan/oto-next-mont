package com.tencent.test;

import com.tencent.common.HttpsRequest;
import com.tencent.common.XMLParser;
import net.sf.json.JSONObject;
import java.util.Calendar;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by JSADKFJ on 2016/12/17.
 */
public class Pay {



    private static String APPID = "";
    private static String MCHID= "";
    private static String KEY= "";
    private static String APPSECRET= "";
    private static String body= "";
    private static String notify_url= ""; // 回调地址。测试回调必须保证外网能访问到此地址


    /**
     * 统一下单接口
     * 微信二维码支付
     * @param out_trade_no
     * @param product_id
     * @param params
     * @return
     */
    public String weixin_pay(String out_trade_no,String product_id,String params) {
        JSONObject retJson = new JSONObject();
        try {

            String currTime = PayCommonUtil.getCurrTime();
            String strTime = currTime.substring(8, currTime.length());
            String strRandom = PayCommonUtil.buildRandom(4) + "";
            String nonce_str = strTime + strRandom; //生成随机字符串

            JSONObject requestObj = JSONObject.fromObject(params);

            // 正式上线的时候价格根据订单id查询
            String order_price = "1"; // 价格 注意：价格的单位是分

            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", APPID);
            packageParams.put("mch_id", MCHID);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no", out_trade_no);
            packageParams.put("total_fee", order_price);
            packageParams.put("spbill_create_ip", "用户端ip");
            packageParams.put("notify_url", notify_url);
            packageParams.put("trade_type", "NATIVE");
            packageParams.put("product_id", product_id);
            Calendar nowTime = Calendar.getInstance();
//            packageParams.put("time_start", DateFormatUtil.formatDate(
//                    nowTime.getTime(), "yyyyMMddHHmmss"));
            nowTime.add(Calendar.MINUTE, requestObj.getInt("expire_time"));
//            packageParams.put("time_expire", DateFormatUtil.formatDate(
//                    nowTime.getTime(), "yyyyMMddHHmmss"));

            String sign = PayCommonUtil.createSign("UTF-8", packageParams,
                    KEY);
            packageParams.put("sign", sign);//加密

            String requestXML = PayCommonUtil.getRequestXml(packageParams);
//            logger.info("支付请求：" + requestXML);
            long startTime=System.currentTimeMillis();
            // 请求支付
            HttpsRequest httpRequest = new HttpsRequest();
            String resXml = httpRequest.sendPost(
                    "https://api.mch.weixin.qq.com/pay/unifiedorder",
                    requestXML);
            long endTime=System.currentTimeMillis();

            Integer execute_time = (int) ((endTime-startTime)/1000);
//            Log.info("支付结果：" + resXml);
            // 获取与支付订单
            Map map= XMLParser.getMapFromXML(resXml);

            JSONObject reportParams = new JSONObject();
            reportParams.put("url", "https://api.mch.weixin.qq.com/pay/unifiedorder");
            reportParams.put("execute_time", execute_time);
            reportParams.put("return_code", map.get("return_code").toString());
            reportParams.put("return_msg", map.get("return_msg").toString());
            reportParams.put("result_code", map.get("result_code").toString());
            if (map.get("err_code") != null) {
                reportParams.put("err_code", map.get("err_code").toString());
                reportParams.put("err_code_des", map.get("err_code_des").toString());
            }
            reportParams.put("out_trade_no", out_trade_no);
            //交易保障
//            report(reportParams.toString());
            if (map.get("return_code").toString().equals("SUCCESS") && map.get("result_code").toString().equals("SUCCESS")) {
                String urlCode = (String) map.get("code_url"); //微信二维码短链接
                retJson.put("code", 0);
                retJson.put("message", "下单成功.");
                retJson.put("data", urlCode);
            } else {
                retJson.put("code", 1);
                retJson.put("message", map.get("err_code_des").toString());
                retJson.put("data", "");
            }
            return retJson.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return  null;
    }
}
