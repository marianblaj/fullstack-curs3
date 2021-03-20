import curs02.people.People;
import services.PeopleServices;
import services.Varste;

import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        PeopleServices peopleServices =new PeopleServices();
        List<People> listPeople = peopleServices.readPersons();
        Map<Varste, Collection<People>> lista = listPeople.stream()
                .collect(groupingBy(People::getVarsta,
                        toCollection(ArrayList::new)));

        lista.forEach((integer, people) -> System.out.println(integer+ " "+people));




    }
}
