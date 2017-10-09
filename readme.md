# springboot 多模块项目
##缘起
简单的项目可以使用直接springboot搭建一个项目工程来完成工作，例如我github上的另外一个项目  [action](https://github.com/fanqinghui/action),但是另外一些项目比较庞大就必须采用分层结构，所以这个项目就是一个比较完成的多模块项目搭建

##模块
1. platform-common：公用组建
2. platform-dao: 数据操作层
3. platform-service:业务操作层
4. platform-webapi:接口或数据展示层

## 特征&提供
- 最佳实践的项目结构、配置文件、精简的POM
- 统一响应结果封装及生成工具
- 统一异常处理
- 简单的接口签名认证
- 常用基础方法抽象封装
- 使用HikariCP数据库连接
- 集成MyBatis、通用Mapper插件、PageHelper分页插件，实现单表业务零SQL

 
## 快速开始
1. 根据业务在基础代码上进行扩展
2. 对开发环境配置文件```application-dev.properties```进行配置，启动项目！
 
## 开发建议
- 表名，建议使用小写，多个单词使用下划线拼接
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解，详情见[通用Mapper插件文档说明](https://mapperhelper.github.io/docs/2.use/)
- 建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```guava```中找，实在没有再造轮子或引入类库，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/lihengming/shared-files/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8Cv1.2.0.pdf))
- 建议在公司内部使用[ShowDoc](https://github.com/star7th/showdoc)、[SpringFox-Swagger2](https://github.com/springfox/springfox) 、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档
 
## 技术选型&文档
- SpringBoot 快速的java开发框架，大大提高程序员的开发效率
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
