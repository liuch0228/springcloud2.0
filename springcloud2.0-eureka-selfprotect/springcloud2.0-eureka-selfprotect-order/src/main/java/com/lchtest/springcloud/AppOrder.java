package com.lchtest.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 启用feign客户端
public class AppOrder {

	public static void main(String[] args) {
		SpringApplication.run(AppOrder.class, args);
	}

	// 将RestTemplate交给spring容器管理，controller中注入并使用
	@Bean
	// 如果使用rest方式以别名方式调用服务提供者的接口，需要依赖ribbon负载均衡器， @LoadBalanced 表示启用ribbon负载均衡
//	@LoadBalanced   // 手写模拟本地负载均衡时，该注解需要注释掉！
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
