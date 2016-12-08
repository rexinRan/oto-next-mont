## 后台地址
http://csee-china.cn:8080/dxs-manager
## 接口地址
http://csee-china.cn:8888/dxs-server
## 网站地址
http://csee-china.cn

###服务器更新步骤
## 更新大学生网站
cd /opt/nginx-www/csec
git pull
##-------更新结束

## 1.更新大学生后台程序(接口：dxs-server)
cd /opt/server/csec-server/dxs-manager
git pull

## 2.打包
mvn clean package

## 3-1.上传(后台)
cp /opt/server/csec-server/dxs-manager/target/dxs-manager.war /opt/apache-tomcat-7.0.70/webapps/dxs-manager.war

## cp: overwrite `...'? 注：用cp指令复制时会提示是否覆盖文件，输入y 回车即可
##-------更新结束

## 3-2.上传(接口)
cp /opt/server/csec-server/dxs-server/target/dxs-server.war /opt/jetty9/webapps


## jetty重启(接口server服务出现问题)
service jetty restart

## Tomcat重启(后台manager服务出现问题)
cd /opt/apache-tomcat-7.0.70/bin
# 关闭
./shutdown.sh
# 启动
./startup.sh
# 查看服务端口（一般用于检测tomcat，nginx等服务是否在运行）
netstat -nptl
# 如果用shutdown没有关闭tomcat服务，则查看进程pid，直接kill
# 例如tcp  0  0 0.0.0.0:8080   0.0.0.0:*   LISTEN  2550/java
kill -9 2550
# 列出所有java进程的pid，jps -l 输出完全的包名，主类名，jar完全路径名
jps -l


## Nginx重启(如果网站出现问题)
service nginx restart

## Nginx软重启
service nginx reload

## 修改Nginx配置
vim /etc/nginx/conf.d/csec.conf


