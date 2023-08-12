package com.difelix.personaldataregistration.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.difelix.personaldataregistration.repository")
public class DynamoDbConfig {

  @Value("${amazon.dynamodb.endpoint}")
  private String endpoint;

  @Value("${amazon.aws.access-key}")
  private String accessKey;

  @Value("${amazon.aws.secret-key}")
  private String secretKey;

  @Value("${amazon.aws.region}")
  private String region;

  @Bean
  public AWSCredentials amazonAWSCredentials() {
    return new BasicAWSCredentials(accessKey, secretKey);
  }

  public AWSCredentialsProvider amazonAWSCredentialsProvider(){
    return new AWSStaticCredentialsProvider(amazonAWSCredentials());
  }

  @Bean
  public AmazonDynamoDB amazonDynamoDB(){
    return AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
        .withCredentials(amazonAWSCredentialsProvider())
        .build();
  }

  @Bean
  @Primary
  public DynamoDBMapper dynamoDBMapper(){
    return new DynamoDBMapper(amazonDynamoDB());
  }

}
