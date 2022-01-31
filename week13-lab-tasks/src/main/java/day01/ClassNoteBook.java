package day01;

import java.util.*;

public class ClassNoteBook {
    private Map<Student, List<Integer>> students=new TreeMap<>();

    public Map<Student, List<Integer>> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.put(student,new ArrayList<>());
    }

    public void addMark(int id,int mark){
        for (Map.Entry<Student,List<Integer>> m: students.entrySet()) {
            if (m.getKey().getId()==id){
                m.getValue().add(mark);
            }
        }
    }
}
