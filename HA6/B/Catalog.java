import java.io.*;
import java.util.*;

class Catalog {

    interface ICommand {
        String getCommand();

        String[] getParameters();

        String getHelpDescription();

        boolean operate(Catalog cat, String args);
    }

    class HelpCommand implements ICommand {
        public String getCommand() {
            return "help";
        }

        public String[] getParameters() {
            return new String[] {};
        }

        public String getHelpDescription() {
            return "Shows this Help text";
        }

        public boolean operate(Catalog cat, String args) {
            System.out.println("Syntax: [command] [parameter(s)]");
            System.out.println("Available commands:");

            for (ICommand command : cat.commands) {
                cat.printCommandHelp(command.getCommand(), command.getParameters(), command.getHelpDescription());
            }

            return true;
        }
    }

    class AddCourseCommand implements ICommand {
        public String getCommand() {
            return "addcourse";
        }

        public String[] getParameters() {
            return new String[] { "title", "docent" };
        }

        public String getHelpDescription() {
            return "Adds a Course with the given title and docent name. The title must be unique";
        }

        public boolean operate(Catalog cat, String args) {
            String[] argsArray = args.split(" ");
            String title = argsArray[0];
            String docent = argsArray[1];

            for (Course existingCourse : cat.courses) {
                if (title.equals(existingCourse.getTitle())) {
                    cat.printError("An course with the name '" + title + "' already exists.");
                    return false;
                }
            }
            cat.courses.add(new Course(title, docent));
            return true;
        }
    }

    class AddFacultyCommand implements ICommand {
        public String getCommand() {
            return "addfaculty";
        }

        public String[] getParameters() {
            return new String[] { "name" };
        }

        public String getHelpDescription() {
            return "Adds a faculty with the given name. The name must be unique.";
        }

        public boolean operate(Catalog cat, String args) {
            String facultyName = args;

            for (Faculty existingFaculty : cat.faculties) {
                if (existingFaculty.getName().equals(facultyName)) {
                    cat.printError("A faculty with the name '" + facultyName + "' already exists.");
                    return false;
                }
            }
            cat.faculties.add(new Faculty(facultyName));
            return true;
        }
    }

    class AssignCourseToFacultyCommand implements ICommand {
        public String getCommand() {
            return "assign";
        }

        public String[] getParameters() {
            return new String[] { "course", "faculty" };
        }

        public String getHelpDescription() {
            return "Assigns the course to the faculty.";
        }

        public boolean operate(Catalog cat, String args) {
            String[] argsArray = args.split(" ");
            String courseTitle = argsArray[0];
            String facultyName = argsArray[1];

            for (Course course : cat.courses) {
                if (course.getTitle().equals(courseTitle)) {
                    for (Faculty faculty : cat.faculties) {
                        if (faculty.getName().equals(facultyName)) {
                            faculty.courses.add(course);
                            return true;
                        }
                    }
                    cat.printError("No faculty '" + facultyName + "' exists");
                    return false;
                }
            }
            cat.printError("No course '" + courseTitle + "' exists");
            return false;
        }
    }

    class ListCoursesCommand implements ICommand {
        public String getCommand() {
            return "list";
        }

        public String[] getParameters() {
            return new String[] { "faculty?" };
        }

        public String getHelpDescription() {
            return "Lists all courses in the specified faculty. The courses from all faculties will be listed if you do not specify a faculty name.";
        }

        public boolean operate(Catalog cat, String args) {
            String facultyName = args;

            if (facultyName.equals("")) {
                if (cat.faculties.size() == 0) {
                    System.out.println("No Faculties found");
                } else {
                    for (Faculty faculty : cat.faculties) {
                        System.out.println("Faculty: " + faculty.getName());

                        if (faculty.courses.size() == 0) {
                            System.out.println("No Courses found in this faculty");
                        } else {
                            for (Course course : faculty.courses) {
                                cat.printCourse(course);
                            }
                        }
                    }
                }

                return true;
            } else {
                for (Faculty faculty : cat.faculties) {
                    if (faculty.getName().equals(facultyName)) {

                        for (Course course : faculty.courses) {
                            cat.printCourse(course);
                        }

                        return true;
                    }
                }
                cat.printError("Faculty '" + facultyName + "' not found.");
                return false;
            }
        }
    }

    class SearchCourseByTitleCommand implements ICommand {
        public String getCommand() {
            return "SearchTitle";
        }

        public String[] getParameters() {
            return new String[] { "title" };
        }

        public String getHelpDescription() {
            return "Search a course by title.";
        }

        public boolean operate(Catalog cat, String args) {
            String courseTitle = args;

            for (Course course : cat.courses) {
                if (course.getTitle().toLowerCase().contains(courseTitle.toLowerCase())) {
                    cat.printCourse(course);
                }
            }

            return true;
        }
    }

    class SearchCourseByDocentCommand implements ICommand {
        public String getCommand() {
            return "SearchDocent";
        }

        public String[] getParameters() {
            return new String[] { "docent" };
        }

        public String getHelpDescription() {
            return "Search a course by docent.";
        }

        public boolean operate(Catalog cat, String args) {
            String courseDocent = args;

            for (Course course : cat.courses) {
                if (course.getDocent().toLowerCase().contains(courseDocent.toLowerCase())) {
                    cat.printCourse(course);
                }
            }

            return true;
        }
    }

    private List<Course> courses = new ArrayList<Course>();
    private List<Faculty> faculties = new ArrayList<Faculty>();
    private List<ICommand> commands = new ArrayList<ICommand>() {
        {
            add(new AddCourseCommand());
            add(new HelpCommand());
            add(new AddFacultyCommand());
            add(new AssignCourseToFacultyCommand());
            add(new ListCoursesCommand());
            add(new SearchCourseByTitleCommand());
            add(new SearchCourseByDocentCommand());
        }
    };

    public static void main(String[] args) {
        boolean exit = false;
        try (Scanner s = new Scanner(System.in)) {
            Catalog cat = new Catalog();

            do {
                System.out.print("Catalog: ");
                String input = s.nextLine();

                switch (input.toLowerCase()) {
                case "quit":
                case "exit":
                    exit = true;
                    break;
                default:
                    try {
                        boolean foundCommand = false;
                        for (ICommand command : cat.commands) {
                            if (input.toLowerCase().startsWith(command.getCommand().toLowerCase())) {
                                try {
                                    command.operate(cat, input.substring(command.getCommand().length()).trim());
                                } catch (Exception ex) {
                                    cat.printError(
                                            "An error occured while executing the command. Please review the syntax of the command:");
                                    cat.printCommandHelp(command.getCommand(), command.getParameters(),
                                            command.getHelpDescription());
                                }
                                foundCommand = true;
                                break;
                            }
                        }
                        if (!foundCommand) {
                            cat.printError("Unknown command. Type 'help' to get a list of all available commands.");
                        }
                    } catch (Exception ex) {
                        cat.printError("An unknown error occured.");
                    }
                    System.out.println();
                    break;
                }

            } while (!exit);
        }
    }

    private void printError(String message) {
        System.out.println(message);
    }

    private void printCourse(Course course) {
        System.out.println(course.getTitle() + " (Docent: " + course.getDocent() + ")");
    }

    private void printCommandHelp(String command, String[] parameters, String description) {
        System.out.println("  " + command + " " + String.join(" ", parameters));
        System.out.println("    " + description);
    }
}