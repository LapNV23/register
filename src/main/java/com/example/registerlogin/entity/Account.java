package com.example.registerlogin.entity;

import com.example.registerlogin.entity.base.BaseEntity;
import com.example.registerlogin.entity.myenum.AccountStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account extends BaseEntity {
    private int id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String passwordHash;
    private String salt;
    private String email;
    private String phone;
    private int role; // 1admin or 2 user
    private AccountStatus status;

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void  checkValidate(){
        //validate data basic
        if (username == null || username.length() == 0){
            errors.put("username", "Please enter username");
        }
        if (password == null || password.length() == 0){
            errors.put("password", "Please enter password");
        }
        if (password != null && password.length() != 0 && !password.equals(passwordConfirm)) {
            errors.put("confirmPassword", "Password and confirm password are different");
        }
        if (phone == null || phone.length() == 0){
            errors.put("phone", "Please enter phone");
        }
        if (email == null || email.length() == 0){
            errors.put("email", "Please enter email");
        }

    }

    public HashMap<String, String> getErrors(){
        return errors;
    }
    public void setErrors(HashMap<String, String> errors){
        this.errors = errors;
    }

    public void addErrors(String key, String value){
        if (this.errors == null){
            this.errors = new HashMap<>();
        }
        this.errors.put(key, value);
    }
    public List<String> getListErrors(){
        return new ArrayList<>(errors.values());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

    public Account(){
        this.username = "";
        this.email = "";
        this.phone = "";
        this.role = 2;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = AccountStatus.ACTIVE;
    }

    public Account(int id, String username, String passwordHash, String salt, String email, String phone, AccountStatus status) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.email = email;
        this.phone = phone;
        this.role = 2;
        this.status = status;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
