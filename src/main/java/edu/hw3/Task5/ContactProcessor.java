package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactProcessor {
    private ContactProcessor() {

    }

    public static List<Contact> parseContacts(List<String> nameSurnamePairs) {
        if (nameSurnamePairs == null) {
            return List.of();
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
        return result
            .stream()
            .sorted(
                Comparator.comparing(
                    c -> ((Contact)c).getSurname() != null ? ((Contact)c).getSurname() : ""
                ).thenComparing(
                    c -> ((Contact)c).getName()
                )
            ).toList();
    }
}
