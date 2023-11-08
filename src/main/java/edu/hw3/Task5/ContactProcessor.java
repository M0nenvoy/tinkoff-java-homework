package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactProcessor {
    private final static String ASC = "ASC";
    private final static String DESC = "DESC";

    private ContactProcessor() {

    }

    public static List<Contact> parseContacts(List<String> nameSurnamePairs, String sorting) {
        if (nameSurnamePairs == null) {
            return List.of();
        }

        if (sorting == null) {
            throw new IllegalArgumentException("Метод сортировки не может быть null");
        }

        if (!sorting.equals(ASC) && !sorting.equals(DESC)) {
            throw new IllegalArgumentException("Некорректный метод сортировки");
        }

        var result = new ArrayList<Contact>();

        for (var pair : nameSurnamePairs) {
            if (pair.isEmpty()) {
                continue;
            }

            var split = pair.split(" ");

            if (split.length == 1) {
                result.add(new Contact(split[0]));
            } else if (split.length == 2) {
                result.add(new Contact(split[0], split[1]));
            }
        }

        var cmp = Comparator.comparing(
            c -> ((Contact) c).getSurname() != null ? ((Contact) c).getSurname() : ""
        ).thenComparing(
            c -> ((Contact) c).getName()
        );

        if (sorting.equals(DESC)) {
            cmp = cmp.reversed();
        }

        return result
            .stream()
            .sorted(cmp).toList();
    }
}
