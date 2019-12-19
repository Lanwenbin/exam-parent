## 12/2

创建数据库

## 12/5

#### json数据传递bug(已解决)

实现题目questionbank的增删改查中遇到的问题：

访问页面报 Content type 'application/json;charset=UTF-8' not supported的错误

问题：不支持json数据类型的传递，

解决方法：配置如下依赖，把返回的json类型交给HttpMessageConverter处理

```xml
	<!-- SpringMVC转换JSON数据使用 -->
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>${jackson-mapper-asl.version}</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.8.1</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.8.1</version>
		</dependency>
```

#### 删除题目bug(未解决)





## 12/6

#### 字段状态Start bug

比如试卷是否可用，数据库是用0或1表示，如何在后台用可用或不可用来表达呢？



#### 修改试卷信息bug(未解决)

如果修改试卷题目后再去修改题目的信息

比如试卷选择了五题选择五题判断，然后再去修改题目，就有可能变成六题选择四题判断。

解决办法v1.0:去掉修改题目类型的功能，只能改选项或对错

#### 删除试卷信息bug

## 12/9

实现考试功能，但还不够完善



# 目标

- [x] 实现手机验证码验证登陆     12/11

  阿里云短信服务

  生成随机验证码

  注册初始头像

  注册初始权限

- [ ] 实现个人资料的修改(文件上传下载)  12/12

  问题：

  - [x] 登录时存入session
  - [x] 在模板页面中添加个人信息，头像
  - [x] 点击更改个人信息弹出模态框进行填写
  - [x] 图片的上传(没有把图片存入session中 bug找了好久)  12/13
  - [ ] 图片上传截取
  - [ ] 保存并修改

- [ ] 增加职位，对学生的增删改查

- [ ] 对考试系统的完善

- [x] 实现权限管理

  12/16 完成数据库创建和dao层代码编写

  12/17 准备完成tree的实现
  



