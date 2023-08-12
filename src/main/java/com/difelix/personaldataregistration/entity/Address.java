package com.difelix.personaldataregistration.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class Address {

  @DynamoDBAttribute
  private String label;

  @DynamoDBAttribute
  private String cep;

  @DynamoDBAttribute
  private String street;

  @DynamoDBAttribute
  private int number;

  @DynamoDBAttribute
  private String neighborhood;

  @DynamoDBAttribute
  private String city;

  @DynamoDBAttribute
  private String state;

  @DynamoDBAttribute
  private String complement;

  @DynamoDBAttribute
  private Boolean isPrincipal;

  @Builder.Default
  @DynamoDBAttribute
  private String createdAt = LocalDateTime.now().toString();

  @DynamoDBAttribute
  private String updatedAt;
}
