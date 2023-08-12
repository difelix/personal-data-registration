package com.difelix.personaldataregistration.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
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
@DynamoDBTable(tableName = "person")
public class Person {

  @Builder.Default
  @DynamoDBHashKey
  private String id = UUID.randomUUID().toString();

  @DynamoDBAttribute
  private String name;

  @DynamoDBAttribute
  private String email;

  @DynamoDBAttribute
  private String cpf;

  @DynamoDBAttribute
  private String birthdate;

  private List<Address> addresses;

  @Builder.Default
  @DynamoDBAttribute
  private String createdAt = LocalDateTime.now().toString();

  @DynamoDBAttribute
  private String updatedAt;
}
