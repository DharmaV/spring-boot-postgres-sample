package org.jug.algeria.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.List;


@Entity
@Table(name="SavedSet")
@Data
@RequiredArgsConstructor
public class SavedSet {

 @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="KeySavedSet")
  private Long KeySavedSet;

  @NotNull
   @Column(name="KeyOnlineUser")
  private long KeyOnlineUser;

  @NotNull
   @Column(name="SavedSet")
  private String SavedSet;

 @Column(name="FormOrder")
  private short FormOrder;


 @Column(name="KeySavedSetCategory")
  private int KeySavedSetCategory;


 @Column(name="KeySavedSetType")
  private short KeySavedSetType;

 @Column(name="UpdOperation")
  private short UpdOperation;


 @Column(name="UpdDate")
  private Date UpdDate;

 @Column(name="KeyProductQueryItem")
  private long KeyProductQueryItem;

 @Column(name="UserDefault")
  private int UserDefault;

 @Column(name="KeyServer")
  private short KeyServer;

 @Column(name="UserLastSaved")
  private Date UserLastSaved;

 @Column(name="LastCriteriaSaved")
  private Date LastCriteriaSaved;


 @Column(name="LastMemberBuild")
  private Date LastMemberBuild;

  @Column(name="KeyWebClientWorkflow")
  private short KeyWebClientWorkflow;

 @Column(name="SavedSetAssumption")
  private String SavedSetAssumption;


 @Column(name="SavedSetVersion")
  private String SavedSetVersion;


     @Column(name="UserLastAccessed")
  private Date UserLastAccessed;

   private String[] Keys;
}
