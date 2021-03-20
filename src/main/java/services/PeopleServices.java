package services;

import curs02.people.People;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class PeopleServices {
    List<People> people = readPersons();
//    Map<Varste, List<People>> peopleArranged = people.stream()
//            .collect(groupingBy(Varste::));




    public List<People> readPersons() {
        try {
            return Files.lines(Path.of("src/main/resources/people/people.txt"))
                    .map(this::readPerson)
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Error reading " + "src/main/resources/people/people.txt");
        }
        return List.of();
    }

    private People readPerson(String line) {
        String[] personInfo = line.split(",");
        Varste varsta;
        if(Integer.parseInt(personInfo[2])<30)
            varsta = Varste.YOUNG;
        else if(Integer.parseInt(personInfo[2])>30 && Integer.parseInt(personInfo[2])<50)
            varsta = Varste.MIDDLE;
        else
            varsta = Varste.OLD;

        return new People(personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2]),
                varsta);
    }
}
