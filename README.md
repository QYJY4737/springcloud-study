# springcloud-study
分布式微服务基础架构，采用官网最新版本进行整合，涉及主要模块：SpringCloud-Greenwich.RELEASE，Eureka，Hystrix，Ribbon，Zuul，Zipkin，Feign，Config，Swagger2，SpringBoot Admin监控等

微服务架构
====
简单来说，微服务架构是 SOA 架构思想的一种扩展，更加强调服务个体的独立性、拆分粒度更小。
微服务架构强调业务系统需要彻底的组件化和服务化，一个组件就是一个产品，可以独立对外提供服务
微服务不再强调传统SOA架构里面比较重的ESB企业服务总线
微服务强调每个微服务都有自己独立的运行空间，包括数据库资源。
微服务架构本身来源于互联网的思路，因此组件对外发布的服务强调了采用HTTP Rest API的方式来进行
微服务的切分粒度会更小
简单来说，每一个应用功能区都使用微服务完成，是相互独立的，之间通过轻量级的通信协议(Http)进行服务通信，这样的话，各个应用可以按实际业务需求，选择自己的技术栈和开发语言。
所以可以看出，微服务的好处有：服务独立、扩展性好、可靠性强，但同时，也面临一些新的问题，比如运维复杂性，分布式复杂性、监控复杂性等等。

什么是SpringCloud
====
SpringCloud是基于SpringBoot的一整套实现微服务的框架。它提供了微服务开发所需的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等组件。最重要的是，基于SpringBoot，会让开发微服务架构非常方便。
本身SpringCloud包含了很多的组件，下面简单列举说明下：

核心组件

SpringCloudGateway
-------
Spring Cloud Gateway是Spring官方基于Spring 5.0，Spring Boot 2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供一种简单而有效的统一的API路由管理方式。Spring Cloud Gateway作为Spring Cloud生态系中的网关，目标是替代Netflix ZUUL，其不仅提供统一的路由方式，并且基于Filter链的方式提供了网关基本的功能，例如：安全，监控/埋点，和限流等。

SpringCloudNetflix
-------
这可是个大boss，地位仅次于老大，老大各项服务依赖与它，与各种Netflix OSS组件集成，组成微服务的核心，它的小弟主要有Eureka,Hystrix,Zuul… 太多了

Netflix Eureka
-------
服务中心，云端服务发现，一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。服务中心，任何小弟需要其它小弟支持什么都需要从这里来拿，同样的你有什么独门武功的都赶紧过报道，方便以后其它小弟来调用；它的好处是你不需要直接找各种什么小弟支持，只需要到服务中心来领取，也不需要知道提供支持的其它小弟在哪里，还是几个小弟来支持的，反正拿来用就行，服务中心来保证稳定性和质量。

Netflix Hystrix
-------
熔断器，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。比如突然某个小弟生病了，但是你还需要它的支持，然后调用之后它半天没有响应，你却不知道，一直在等等这个响应；有可能别的小弟也正在调用你的武功绝技，那么当请求多之后，就会发生严重的阻塞影响老大的整体计划。这个时候Hystrix就派上用场了，当Hystrix发现某个小弟不在状态不稳定立马马上让它下线，让其它小弟来顶上来，或者给你说不用等了这个小弟今天肯定不行，该干嘛赶紧干嘛去别在这排队了。

Netflix Zuul
-------
Zuul是在云平台上提供动态路由,监控,弹性,安全等边缘服务的框架。Zuul相当于是设备和Netflix流应用的 Web 网站后端所有请求的前门。当其它门派来找大哥办事的时候一定要先经过zuul,看下有没有带刀子什么的给拦截回去，或者是需要找那个小弟的直接给带过去。

SpringCloudConfig
-------
俗称的配置中心，配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion。就是以后大家武器、枪火什么的东西都集中放到一起，别随便自己带，方便以后统一管理、升级装备。

SpringCloudBus
-------
事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。相当于水浒传中日行八百里的神行太保戴宗，确保各个小弟之间消息保持畅通。

SpringCloudforCloudFoundry
-------
Cloud Foundry是VMware推出的业界第一个开源PaaS云平台，它支持多种框架、语言、运行时环境、云平台及应用服务，使开发人员能够在几秒钟内进行应用程序的部署和扩展，无需担心任何基础架构的问题
其实就是与CloudFoundry进行集成的一套解决方案，抱了Cloud Foundry的大腿。

SpringCloudCluster
-------
Spring Cloud Cluster将取代Spring Integration。提供在分布式系统中的集群所需要的基础功能支持，如：选举、集群的状态一致性、全局锁、tokens等常见状态模式的抽象和实现。
如果把不同的帮派组织成统一的整体，Spring Cloud Cluster已经帮你提供了很多方便组织成统一的工具。

SpringCloudConsul
-------
Consul是一个支持多数据中心分布式高可用的服务发现和配置共享的服务软件,由 HashiCorp 公司用 Go 语言开发, 基于 Mozilla Public License 2.0 的协议进行开源. Consul 支持健康检查,并允许 HTTP 和 DNS 协议调用 API 存储键值对.
Spring Cloud Consul封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。

其他组件
当然，除了以上列举的，还有比如Spring Cloud Security、Spring Cloud Sleuth、Spring Cloud Data Flow、Spring Cloud Stream、Spring Cloud Zookeeper等等。

Spring Cloud Security
-------
基于spring security的安全工具包，为你的应用程序添加安全控制。这个小弟很牛鼻专门负责整个帮派的安全问题，设置不同的门派访问特定的资源，不能把秘籍葵花宝典泄漏了。

Spring Cloud Sleuth
-------
日志收集工具包，封装了Dapper和log-based追踪以及Zipkin和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。

Spring Cloud Data Flow
-------
Data flow 是一个用于开发和执行大范围数据处理其模式包括ETL，批量运算和持续运算的统一编程模型和托管服务。
对于在现代运行环境中可组合的微服务程序来说，Spring Cloud data flow是一个原生云可编配的服务。使用Spring Cloud data flow，开发者可以为像数据抽取，实时分析，和数据导入/导出这种常见用例创建和编配数据通道 （data pipelines）。

Spring Cloud data flow 是基于原生云对 spring XD的重新设计，该项目目标是简化大数据应用的开发。Spring XD 的流处理和批处理模块的重构分别是基于 Spring Boot的stream 和 task/batch 的微服务程序。这些程序现在都是自动部署单元而且他们原生的支持像 Cloud Foundry、Apache YARN、Apache Mesos和Kubernetes 等现代运行环境。
Spring Cloud data flow 为基于微服务的分布式流处理和批处理数据通道提供了一系列模型和最佳实践。

Spring Cloud Stream
-------
Spring Cloud Stream是创建消息驱动微服务应用的框架。Spring Cloud Stream是基于Spring Boot创建，用来建立单独的／工业级spring应用，使用spring integration提供与消息代理之间的连接。数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。
一个业务会牵扯到多个任务，任务之间是通过事件触发的，这就是Spring Cloud stream要干的事了

Spring Cloud Task
-------
Spring Cloud Task主要解决短命微服务的任务管理，任务调度的工作，比如说某些定时任务晚上就跑一次，或者某项数据分析临时就跑几次。

Spring Cloud Zookeeper
-------
ZooKeeper是一个分布式的，开放源码的分布式应用程序协调服务，是Google的Chubby一个开源的实现，是Hadoop和Hbase的重要组件。它是一个为分布式应用提供一致性服务的软件，提供的功能包括：配置维护、域名服务、分布式同步、组服务等。ZooKeeper的目标就是封装好复杂易出错的关键服务，将简单易用的接口和性能高效、功能稳定的系统提供给用户。
操作Zookeeper的工具包，用于使用zookeeper方式的服务发现和配置管理，抱了Zookeeper的大腿。

Spring Cloud Connectors
-------
Spring Cloud Connectors简化了连接到服务的过程和从云平台获取操作的过程，有很强的扩展性，可以利用Spring Cloud Connectors来构建你自己的云平台。
便于云端应用程序在各种PaaS平台连接到后端，如：数据库和消息代理服务。

Spring Cloud CLI
-------
基于Spring Boot CLI，可以让你以命令行方式快速建立云组件。
题外话：这么多组件，目前用到的还比较少的⊙﹏⊙‖∣。常用的还是Netflix的全家桶。学习之路，路漫漫其修远兮！

为何选择SpringCloud
微服务的框架那么多比如：dubbo，为什么就要使用Spring Cloud的呢？
产出于spring大家族，spring在企业级开发框架中无人能敌，来头很大，可以保证后续的更新、完善。
题外话：年初的时候，Dubbo又开始疯狂更新了，而且还成为Apache基金会孵化项目。希望越来越好把，毕竟之前的坑比较多，还希望能尽快修复。
有Spring Boot 这个独立干将可以省很多事，大大小小的活Spring Boot都搞的挺不错。
作为一个微服务治理的大家伙，考虑的很全面，几乎服务治理的方方面面都考虑到了，方便开发开箱即用。
Spring Cloud 活跃度很高，教程很丰富，遇到问题很容易找到解决方案
轻轻松松几行代码就完成了熔断、均衡负责、服务中心的各种平台功能.


    与Dubbo对比
    做一个简单的功能对比：
    核心要素DubboSpring Cloud
    服务注册中心ZookeeperSpring Cloud Netflix Eureka
    服务调用方式RPCREST API
    服务监控Dubbo-monitorSpring Boot Admin
    断路器不完善Spring Cloud Netflix Hystrix
    服务网关无Spring Cloud Netflix Zuul
    分布式配置无Spring Cloud Config
    服务跟踪无Spring Cloud Sleuth
    消息总线无Spring Cloud Bus
    数据流无Spring Cloud Stream
    批量任务无Spring Cloud Task

  这样对比其实是不够公平的，首先Dubbo是SOA时代的产物，它的关注点主要在于服务的调用，流量分发、流量监控和熔断。而Spring Cloud诞生于微服务架构时代，考虑的是微服务治理的方方面面，另外由于依托了Spirng、Spirng Boot的优势之上，两个框架在开始目标就不一致，Dubbo定位服务治理、Spirng Cloud是一个生态。
  如果仅仅关注于服务治理的这个层面，Dubbo其实还优于Spring Cloud很多：
    Dubbo 支持更多的协议，如：rmi、hessian、http、webservice、thrift、memcached、redis 等。
    Dubbo 使用 RPC 协议效率更高，在极端压力测试下，Dubbo 的效率会高于 Spring Cloud 效率一倍多。
    Dubbo 有更强大的后台管理，Dubbo 提供的后台管理 Dubbo Admin 功能强大，提供了路由规则、动态配置、访问控制、权重调节、均衡负载等诸多强大的功能。
  可以限制某个 IP 流量的访问权限，设置不同服务器分发不同的流量权重，并且支持多种算法，利用这些功能我们可以在线上做灰度发布、故障转移等。
  所以Dubbo专注于服务治理；Spring Cloud关注于微服务架构生态。

    SpringCloud版本说明
    Spring Cloud项目目前仍然是快速迭代期，版本变化很快。Spring Cloud并没有熟悉的数字版本号，而是对应一个开发代号。 
    本系列教程使用的都是Finchley SR1版本，基于Spring Boot 2.0.3。
    官网给出了目前各版本对应组件的版本信息：
    ComponentEdgware.SR4Finchley.SR1Finchley.BUILD-SNAPSHOT
    spring-cloud-aws1.2.3.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-bus1.3.3.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-cli1.4.1.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-commons1.3.4.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-contract1.2.5.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-config1.4.4.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-netflix1.4.5.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-security1.2.3.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-cloudfoundry1.1.2.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-consul1.3.4.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-sleuth1.3.4.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-streamDitmars.SR4Elmhurst.SR1Elmhurst.BUILD-SNAPSHOT
    spring-cloud-zookeeper1.2.2.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-boot1.5.14.RELEASE2.0.4.RELEASE2.0.4.BUILD-SNAPSHOT
    spring-cloud-task1.2.3.RELEASE2.0.0.RELEASE2.0.1.BUILD-SNAPSHOT
    spring-cloud-vault1.1.1.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-gateway1.0.2.RELEASE2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-openfeign2.0.1.RELEASE2.0.2.BUILD-SNAPSHOT
    spring-cloud-function1.0.0.RELEASE1.0.0.RELEASE1.0.1.BUILD-SNAPSHOT

简单说明：
规律，但实际上首字母是有顺序的，比如：Dalston版本，我们可以简称D版本，对应的Edgware版本我们可以简称E版本，目前最新的Finchley就是所说的F版本。
SpringCloud E版 对应 SpringBoot 1.5.x
SpringCloud F版 对应 SpringBoot 2.x

    小版本：
    SNAPSHOT： 快照版本，随时可能修改。
    SRx： Service Release，SR1表示第1个正式版本，一般同时标注GA：(GenerallyAvailable),表示稳定版本。

    同时，注意官网的一句话：
    Finchley builds and works with Spring Boot 2.0.x, and is not expected to work with Spring Boot 1.5.x

    总结
    Talk is cheap. Show me the code。


