import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = makeStudents();
        System.out.println("Уникальные курсы");
        System.out.println(filterUniqueCoursesFrom(students));
        System.out.println("Любознательные");
        System.out.println(getTopThreeInquisitiveStudents(students));
        System.out.println("Кто ходит на курс");
        System.out.println(findStudentsByCourse(students, new Course("Матан")));
    }

    public static List<Student> makeStudents() {
        List<Student> students = Arrays.asList(
                new Student(
                        "Василий",
                        Arrays.asList(
                                new Course("Матан"),
                                new Course("Информатика"),
                                new Course("Философия"),
                                new Course("Числовые методы")
                        )
                ),
                new Student(
                        "Ирина",
                        Arrays.asList(
                                new Course("Машинное обучение"),
                                new Course("Нейронные сети"),
                                new Course("Матан"),
                                new Course("Числовые методы"),
                                new Course("История")
                        )
                ),
                new Student(
                        "Анна",
                        Arrays.asList(
                                new Course("Природоведение"),
                                new Course("Матан"),
                                new Course("Естествознание"),
                                new Course("Числовые методы"),
                                new Course("История"),
                                new Course("Обществознание")
                        )
                ),
                new Student(
                        "Владимир",
                        Arrays.asList(
                                new Course("Экономика"),
                                new Course("Матан"),
                                new Course("Естествознание"),
                                new Course("Международное право"),
                                new Course("История"),
                                new Course("Обществознание"),
                                new Course("Английский язык")
                        )
                )
        );

        return students;
    }

      public static List<Course> filterUniqueCoursesFrom(List<Student> students) {
        List<Course> courses =
                students.stream()
                        .flatMap(element -> element.getAllCourses().stream())
                        .collect(Collectors.toList());

        return courses.stream()
                .filter(course -> Collections.frequency(courses, course) < 2)
                .collect(Collectors.toList());
    }


    public static List<Student> getTopThreeInquisitiveStudents(List<Student> from) {
        return from.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.getAllCourses().size() > o2.getAllCourses().size()) {
                            return -1;
                        } else if (o1.getAllCourses().size() < o2.getAllCourses().size()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                })
                .limit(3)
                .collect(Collectors.toList());
    }

        public static List<Student> findStudentsByCourse(List<Student> from, Course course) {
        return from.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}