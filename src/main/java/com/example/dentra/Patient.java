package com.example.dentra;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Patient {
    private final SimpleStringProperty date;
    private final SimpleStringProperty fullName;
    private final SimpleStringProperty age;
    private final SimpleStringProperty address;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty email;
    private final SimpleStringProperty procedure;
    private final SimpleStringProperty emergencyContact;
    private final SimpleStringProperty transactionType;
    private final SimpleDoubleProperty remainingBalance;
    private final SimpleDoubleProperty totalAmount;




    public Patient(String date, String fullName, String age, String address, String contact, String gender, String email, String procedure, String emergencyContact, double remainingBalance, double totalAmount, String transactionType) {
        this.date = new SimpleStringProperty(date);
        this.fullName = new SimpleStringProperty(fullName);
        this.age = new SimpleStringProperty(age);
        this.address = new SimpleStringProperty(address);
        this.contact = new SimpleStringProperty(contact);
        this.gender = new SimpleStringProperty(gender);
        this.email = new SimpleStringProperty(email);
        this.procedure = new SimpleStringProperty(procedure);
        this.emergencyContact = new SimpleStringProperty(emergencyContact);
        this.remainingBalance = new SimpleDoubleProperty(remainingBalance);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.transactionType = new SimpleStringProperty(transactionType);

    }

    // Getters & Setters
    public String getDate() { return date.get(); }
    public void setDate(String value) { date.set(value); }

    public String getFullName() { return fullName.get(); }
    public void setFullName(String value) { fullName.set(value); }

    public String getAge() { return age.get(); }
    public void setAge(String value) { age.set(value); }

    public String getAddress() { return address.get(); }
    public void setAddress(String value) { address.set(value); }

    public String getContact() { return contact.get(); }
    public void setContact(String value) { contact.set(value); }

    public String getGender() { return gender.get(); }
    public void setGender(String value) { gender.set(value); }

    public String getEmail() { return email.get(); }
    public void setEmail(String value) { email.set(value); }

    public String getProcedure() { return procedure.get(); }
    public void setProcedure(String value) { procedure.set(value); }

    public String getEmergencyContact() { return emergencyContact.get(); }
    public void setEmergencyContact(String value) { emergencyContact.set(value); }

    public double getRemainingBalance() { return remainingBalance.get(); }
    public void setRemainingBalance(double value) { remainingBalance.set(value); }

    public double getTotalAmount() { return totalAmount.get(); }
    public void setTotalAmount(double value) { totalAmount.set(value); }

    public String getTransactionType() { return transactionType.get(); }
    public void setTransactionType(String value) { transactionType.set(value); }
}
