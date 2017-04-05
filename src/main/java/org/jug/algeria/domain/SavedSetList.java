package org.jug.algeria.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Column;
@Entity
@Data
@RequiredArgsConstructor
public class SavedSetList {

 @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long KeySavedSetList;

  @NotNull
    @Column(name="KeySavedSet")
  private long KeySavedSet;
  

  private short FormOrder;


  private String SavedSetValue;


  private long KeyProductQueryItem;

  
  private short UpdOperation;


  private Date UpdDate;

}
