package com.xworkz.instuite.utility;

import java.util.Arrays;
import java.util.List;

public class Validation {

    public static List<String> getValidLocations() {
        return Arrays.asList(
            "Bagalkot", "Bangalore Rural", "Bangalore Urban", "Belagavi (Belgaum)", "Ballari (Bellary)", "Bidar", 
            "Chamarajanagar", "Chikkaballapura", "Chikkamagaluru (Chikmagalur)", "Chitradurga", 
            "Dakshina Kannada (Mangalore)", "Davanagere", "Dharwad", "Gadag", "Hassan", "Haveri", 
            "Kalaburagi (Gulbarga)", "Kodagu (Coorg)", "Kolar", "Koppal", "Mandya", "Mysuru (Mysore)", 
            "Raichur", "Ramanagara", "Shivamogga (Shimoga)", "Tumakuru (Tumkur)", "Udupi", 
            "Uttara Kannada (Karwar)", "Vijayapura (Bijapur)", "Yadgir"
        );
    }

    public static List<String> getValidTypes() {
        return Arrays.asList(
            "Java Developer", "Spring Developer", "Backend Java Developer", "Full Stack Java Developer", 
            "Microservices Developer", "J2EE Developer", "API Developer", "Spring Boot Developer", 
            "Hibernate Developer", "Enterprise Java Developer", "Cloud Java Developer", "Java Microservices Developer", 
            "Core Java Developer", "Java Web Developer", "Java Software Engineer", "Java Integration Developer", 
            "Java API Developer", "Java Solution Developer", "Java Backend Engineer"
        );
    }
}
