public class MVCTest {

    public static void main(String[] args) {

        Student student =
                new Student(
                        "Navya",
                        "123",
                        "A");

        StudentView view =
                new StudentView();

        StudentController controller =
                new StudentController(
                        student,
                        view);

        controller.updateView();

        System.out.println();

        controller.setStudentName(
                "Navya Saxena");

        controller.updateView();
    }
}