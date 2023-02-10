package com.allstate.claimsfirstserver.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "claim")
public class Claim {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String policyNumber;
   private String title;
   private String firstName;
   private String surname;
   private String email;
   private String phoneNumber;
   private String insuranceType;
   private LocalDate date;
   private Double estimatedWorth;
   private String vehicleMake;
   private String vehicleModel;
   private Integer vehicleYear;
   private String propertyAddress;
   private String animalType;
   private String animalBreed;
   private String reason;
   private String description;
   private String status;
   private LocalDate taskDate;
   private String taskNote;

   public Claim(Integer id, String policyNumber, String title, String firstName, String surname, String email, String phoneNumber, String insuranceType, LocalDate date, Double estimatedWorth, String vehicleMake, String vehicleModel, Integer vehicleYear, String propertyAddress, String animalType, String animalBreed, String reason, String description, String status, LocalDate taskDate, String taskNote)
   {
      this.id = id;
      this.policyNumber = policyNumber;
      this.title = title;
      this.firstName = firstName;
      this.surname = surname;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.insuranceType = insuranceType;
      this.date = date;
      this.estimatedWorth = estimatedWorth;
      this.vehicleMake = vehicleMake;
      this.vehicleModel = vehicleModel;
      this.vehicleYear = vehicleYear;
      this.propertyAddress = propertyAddress;
      this.animalType = animalType;
      this.animalBreed = animalBreed;
      this.reason = reason;
      this.description = description;
      this.status = status;
      this.taskDate = taskDate;
      this.taskNote = taskNote;
   }

   public Claim() {}

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getPolicyNumber()
   {
      return policyNumber;
   }

   public void setPolicyNumber(String policyNumber)
   {
      this.policyNumber = policyNumber;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getSurname()
   {
      return surname;
   }

   public void setSurname(String surname)
   {
      this.surname = surname;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   public String getInsuranceType()
   {
      return insuranceType;
   }

   public void setInsuranceType(String insuranceType)
   {
      this.insuranceType = insuranceType;
   }

   public LocalDate getDate()
   {
      return date;
   }

   public void setDate(LocalDate date)
   {
      this.date = date;
   }

   public Double getEstimatedWorth()
   {
      return estimatedWorth;
   }

   public void setEstimatedWorth(Double estimatedWorth)
   {
      this.estimatedWorth = estimatedWorth;
   }

   public String getVehicleMake()
   {
      return vehicleMake;
   }

   public void setVehicleMake(String vehicleMake)
   {
      this.vehicleMake = vehicleMake;
   }

   public String getVehicleModel()
   {
      return vehicleModel;
   }

   public void setVehicleModel(String vehicleModel)
   {
      this.vehicleModel = vehicleModel;
   }

   public Integer getVehicleYear()
   {
      return vehicleYear;
   }

   public void setVehicleYear(Integer vehicleYear)
   {
      this.vehicleYear = vehicleYear;
   }

   public String getPropertyAddress()
   {
      return propertyAddress;
   }

   public void setPropertyAddress(String propertyAddress)
   {
      this.propertyAddress = propertyAddress;
   }

   public String getAnimalType()
   {
      return animalType;
   }

   public void setAnimalType(String animalType)
   {
      this.animalType = animalType;
   }

   public String getAnimalBreed()
   {
      return animalBreed;
   }

   public void setAnimalBreed(String animalBreed)
   {
      this.animalBreed = animalBreed;
   }

   public String getReason()
   {
      return reason;
   }

   public void setReason(String reason)
   {
      this.reason = reason;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getStatus()
   {
      return status;
   }

   public void setStatus(String status)
   {
      this.status = status;
   }

   public LocalDate getTaskDate()
   {
      return taskDate;
   }

   public void setTaskDate(LocalDate taskDate)
   {
      this.taskDate = taskDate;
   }

   public String getTaskNote()
   {
      return taskNote;
   }

   public void setTaskNote(String taskNote)
   {
      this.taskNote = taskNote;
   }

   @Override
   public String toString()
   {
      return "Claim{" +
            "id=" + id +
            ", policyNumber='" + policyNumber + '\'' +
            ", title='" + title + '\'' +
            ", firstName='" + firstName + '\'' +
            ", surname='" + surname + '\'' +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", insuranceType='" + insuranceType + '\'' +
            ", date=" + date +
            ", estimatedWorth=" + estimatedWorth +
            ", vehicleMake='" + vehicleMake + '\'' +
            ", vehicleModel='" + vehicleModel + '\'' +
            ", vehicleYear=" + vehicleYear +
            ", propertyAddress='" + propertyAddress + '\'' +
            ", animalType='" + animalType + '\'' +
            ", animalBreed='" + animalBreed + '\'' +
            ", reason='" + reason + '\'' +
            ", description='" + description + '\'' +
            ", status='" + status + '\'' +
            ", taskDate=" + taskDate +
            ", taskNote='" + taskNote + '\'' +
            '}';
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Claim claim = (Claim) o;
      return Objects.equals(id, claim.id) && Objects.equals(policyNumber, claim.policyNumber) && Objects.equals(title, claim.title) && Objects.equals(firstName, claim.firstName) && Objects.equals(surname, claim.surname) && Objects.equals(email, claim.email) && Objects.equals(phoneNumber, claim.phoneNumber) && Objects.equals(insuranceType, claim.insuranceType) && Objects.equals(date, claim.date) && Objects.equals(estimatedWorth, claim.estimatedWorth) && Objects.equals(vehicleMake, claim.vehicleMake) && Objects.equals(vehicleModel, claim.vehicleModel) && Objects.equals(vehicleYear, claim.vehicleYear) && Objects.equals(propertyAddress, claim.propertyAddress) && Objects.equals(animalType, claim.animalType) && Objects.equals(animalBreed, claim.animalBreed) && Objects.equals(reason, claim.reason) && Objects.equals(description, claim.description) && Objects.equals(status, claim.status) && Objects.equals(taskDate, claim.taskDate) && Objects.equals(taskNote, claim.taskNote);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(id, policyNumber, title, firstName, surname, email, phoneNumber, insuranceType, date, estimatedWorth, vehicleMake, vehicleModel, vehicleYear, propertyAddress, animalType, animalBreed, reason, description, status, taskDate, taskNote);
   }
}
