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
public class Contact {

  @DynamoDBAttribute
  private String label;

  @DynamoDBAttribute
  private Boolean principal;

  @DynamoDBAttribute
  private String ddd;

  @DynamoDBAttribute
  private String phoneNumber;

  @DynamoDBAttribute
  private Boolean whatsApp;

  @DynamoDBAttribute
  @Builder.Default
  private String createdAt = LocalDateTime.now().toString();

  @DynamoDBAttribute
  private String updatedAt;
}
