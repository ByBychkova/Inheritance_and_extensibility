package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void taskSearch(){
        SimpleTask simpleTask = new SimpleTask(5, "Perform an action");
        String query = "Perform";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void taskSearch1(){
        Epic epic= new Epic (1, new String[]{"Perform an action","Perform an action 1","Perform an action 2"});
        String query = "Perform an action 2";
        boolean  expected = true;
        boolean  actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void taskSearch2(){
        Meeting meeting = new Meeting(1,"Фичи 2023", "Функционал Акцент 2.0", "23.10.2022");
        String query = "Фичи 2023";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

}

