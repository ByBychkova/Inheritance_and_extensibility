package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void taskSearch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(11, "Создать программу"));
        todos.add(new Epic(5, new String[]{"Спрограммировать раздел 1", "Спрограммировать раздел 2"}));
        todos.add(new Meeting(1, "Сформировать ответвенную группу", "Акцент 2.0", "01.02.2023"));
        String query = "Создать программу";
        Task[] expected = {new SimpleTask(11, "Создать программу")};
        Task[] actual = todos.search("программу");
        Assertions.assertArrayEquals(expected, actual);

    }
}


