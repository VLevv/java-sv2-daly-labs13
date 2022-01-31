package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    ClassNoteBook noteBook = new ClassNoteBook();
    Student student = new Student(1,"Jani");
    Student student1 = new Student(3,"Dani");
    Student student2 = new Student(2,"Mari");
    @BeforeEach
    void init(){
        noteBook.addStudent(student);
        noteBook.addStudent(student1);
        noteBook.addStudent(student2);
    }

    @Test
    void addStudent() {
        assertEquals(Set.of(student,student2,student1),noteBook.getStudents().keySet());
        assertNotEquals(List.of(student,student1,student2),noteBook.getStudents().keySet().stream().toList());

    }

    @Test
    void addMark() {
        noteBook.addMark(1,4);
        assertEquals(4,noteBook.getStudents().get(student).get(0));
    }
}