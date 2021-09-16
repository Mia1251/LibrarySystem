package se.lexicon.librarysystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(unique = true)
    private String userName;
    private String passWord;
    private LocalDate regDate;
    @OneToOne(
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private Details userDetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "borrower")
    private List<BookLoan> loans;

    public void borrowBook(BookLoan bookLoan){
        loans.add(bookLoan);
        bookLoan.setBorrower(this);
    }
    public void returnBook(BookLoan bookLoan){
        bookLoan.setBorrower(null);
        loans.remove(bookLoan);
    }




    public AppUser() {
    }

    public AppUser(int appUserId, String userName, String passWord, LocalDate regDate, Details userDetails, List<BookLoan> loans) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.passWord = passWord;
        this.regDate = regDate;
        this.userDetails = userDetails;
        this.loans = loans;
    }





    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public List<BookLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userName, appUser.userName) && Objects.equals(passWord, appUser.passWord) && Objects.equals(userDetails, appUser.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, passWord, userDetails);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                ", loans=" + loans +
                '}';
    }
}