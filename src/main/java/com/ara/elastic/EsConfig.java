package com.ara.elastic;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories
public class EsConfig {

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Value("${elasticsearch.host}")
    private String elasticsearchHost;

    @Value("#{new Integer('${elasticsearch.port}')}")
    private Integer elasticsearchPort;

    @Bean
    public Client client() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.builder()
                .put("cluster.name", clusterName)
                .build());
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
}
