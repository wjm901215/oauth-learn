# Oauth

 ## 1.1授权码模式测试

 (1) 资源拥有者打开客户端，客户端要求资源拥有者给予授权，它将浏览器被重定向到授权服务器，重定向时会 附加客户端的身份信息。

请求地址

```
http://localhost:53020/uaa/oauth/authorize?client_id=c1&response_type=code&scope=all&redirect_uri=http://www.baidu.com
参数列表如下:
client_id:客户端准入标识。
response_type:授权码模式固定为code。
scope:客户端权限。 
redirect_uri:跳转uri //授权码申请成功后会跳转到此地址，并在后边带上code参数(授权码)
```

(2)浏览器出现向授权服务器授权页面，之后将用户同意授权。

(3)授权服务器将授权码(AuthorizationCode)转经浏览器发送给client(通过redirect_uri)。

(4)客户端拿着授权码向授权服务器索要访问access_token，请求如下:

```
http://localhost:53020/uaa/oauth/token?client_id=c1&client_secret=secret&grant_type=authorization_code&username=zhangsan&password=123&code=xFZ0AY&redirect_uri=http://www.baidu.com

client_id:客户端准入标识。
client_secret:客户端秘钥。
grant_type:授权类型，填写authorization_code，表示授权码模式 
code:授权码，就是刚刚获取的授权码，注意:授权码只使用一次就无效了，需要重新申请。 
redirect_uri:申请授权码时的跳转url，一定和申请授权码时用的redirect_uri一致。
```

 ## 1.2.简单模式测试

(1)资源拥有者打开客户端，客户端要求资源拥有者给予授权，它将浏览器被重定向到授权服务器，重定向时会 附加客户端的身份信息。如:

```
http://localhost:53020/uaa/oauth/authorize?client_id=c1&response_type=token&scope=all&redirect_uri=http://www.baidu.com
user/pwd:zhangsan/123
```

参数描述同授权码模式 ，注意response_type=token，说明是简化模式。 

(2)浏览器出现向授权服务器授权页面，之后将用户同意授权。

(3)授权服务器将授权码将令牌(access_token)以Hash的形式存放在重定向uri的fargment中发送给浏览 器。

 ## 1.3.密码模式测试

(1)资源拥有者将用户名、密码发送给客户端

 (2)客户端拿着资源拥有者的用户名、密码向授权服务器请求令牌(access_token)，请求如下:

```
http://localhost:53020/uaa/oauth/token?client_id=c1&client_secret=secret&grant_type=password&username=zhangsan&password=123
参数列表如下:
client_id:客户端准入标识。
client_secret:客户端秘钥。 
grant_type:授权类型，填写password表示密码模式 
username:资源拥有者用户名。 
password:资源拥有者密码。
```

(3)授权服务器将令牌(access_token)发送给client

 ## 1.4.客户端模式测试

(1)客户端向授权服务器发送自己的身份信息，并请求令牌(access_token)

 (2)确认客户端身份无误后，将令牌(access_token)发送给client，请求如下

```
http://localhost:53020/uaa/oauth/token?client_id=c1&client_secret=secret&grant_type=client_credentials
参数列表如下:
client_id:客户端准入标识。
client_secret:客户端秘钥。 
grant_type:授权类型，填写client_credentials表示客户端模式
```


 ## 2.1资源服务测试

(1)令牌申请成功(access_token)

(2)按照oauth2.0协议要求，请求资源需要携带token，如下: token的参数名称为:Authorization，值为:Bearer token值

```
http://localhost:53021/order/r1
Headers参数列表如下:
Authorization:Bearer access_token

```

