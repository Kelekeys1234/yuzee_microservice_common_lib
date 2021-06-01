package com.yuzee.common.lib.config;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.getstream.client.Client;

@Configuration
@ConditionalOnProperty(name = "getstream.key")
public class GetStreamConfiguration {

	@Bean
	public Client client(@Value("${getstream.key}") String apiKey, @Value("${getstream.secret}") String apiSecret)
			throws MalformedURLException {
		return Client.builder(apiKey, apiSecret).build();
	}

}
