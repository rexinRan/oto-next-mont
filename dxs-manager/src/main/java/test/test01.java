package test;

import com.buss.dataStatistics.controller.UserStatisticsController;
import org.codehaus.groovy.vmplugin.v5.JUnit4Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/7/16.
 */
public class test01{

    private static HttpServletRequest request;


    @Test
    public void test(){
        UserStatisticsController userStatisticsController = new UserStatisticsController();
        ReplyDataMode replyDataMode = userStatisticsController.selectQuery();
        System.out.println("success");
    }
}
