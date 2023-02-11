package com.example.springproject5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name field is required")
    private String name ;

//    @NotNull(message = "age field is required")
//    @Min(0)
//    private int age;
//    @NotEmpty(message = "email field is required")
//    @Email(message = "please enter a valid email")
//    private String email ;
//
//    @NotNull(message = "Salary field is required")
//    @Min(5000)
//    private int salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    List<Book> books;

    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;


}
