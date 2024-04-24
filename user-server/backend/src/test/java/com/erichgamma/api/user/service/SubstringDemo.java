package com.erichgamma.api.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
public class SubstringDemo {
    @Test
    public void stringSplit(){
        String str = "a.b.c";
        String[] arr = str.split("\\.");
        String[] arr2 = new StringBuilder(str).append(".d.e.f").toString().split("\\.");
        assertThat(arr.length).isEqualTo(3);
        assertThat(arr2.length).isEqualTo(6);
    }
    
    @Test
    public void TestSSN(){
        String[] humans = {"970101-1", "950101-2", "020101-3", "020101-4", "240101-5", "950101-6", "990506-1"};
        String[] correct = {"27 M", "29 F", "22 M", "22 F", "100 M", "29 F", "24 M"};

        for(int i = 0; i < humans.length; i++)
            assertThat(new StringBuilder().append(getAge(humans[i])).append(" ").append(getGen(humans[i])).toString()).isEqualTo(correct[i]);
    }

    public String getGen(String ssn){
        return ((ssn.charAt(7)) % 2) == 1 ? "M" : "F";
    }

    public Integer getAge(String ssn){
        return Stream.of(ssn)
        .map(i -> new StringBuilder()
            .append(
                switch(i.charAt(7)){
                    case '9', '0'-> "18";
                    case '1', '2', '5', '6' -> "19";
                    default -> "20";
                }
            ).append(i.substring(0, 6)).toString())
        .map(i -> Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString()) - Integer.parseInt(i))
        .map(i -> i / 10000)
        .findAny().get();
    }
}
