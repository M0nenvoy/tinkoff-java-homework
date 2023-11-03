package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class AnimalProcessor {
    private static final int HUNDRED = 100;
    private static final int LONG_WORD_THRESHOLD = 2;

    private AnimalProcessor() {

    }

    /**
     * Задание 1. Отсортировать животных по росту от самого маленького к самому большому
     */
    public static List<Animal> sortByHeight(List<Animal> animals) {
        animalsNotNull(animals);
        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::height))
            .toList();
    }

    /**
     * Задание 2. Отсортировать животных по весу от самого тяжелого к самому легкому. Выбрать k первых
     */
    public static List<Animal> sortByWeightReversedWithLimit(List<Animal> animals, int limit) {
        animalsNotNull(animals);
        if (limit <= 0) {
            throw new IllegalArgumentException("limit должен быть положительным числом");
        }

        if (limit >= animals.size()) {
            throw new IllegalArgumentException("limit не может превышать размер коллекции");
        }

        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(limit)
            .toList();
    }

    /**
     * Задание 3. Сколько животных каждого вида
     */
    public static Map<Animal.Type, Integer> animalsNumberByType(List<Animal> animals) {
        animalsNotNull(animals);
        var map = new HashMap<Animal.Type, Integer>();

        for (var animal : animals) {
            int count = map.getOrDefault(animal.type(), 0);
            map.put(animal.type(), count + 1);
        }

        return map;
    }

    /**
     * Задание 4. У какого животного самое длинное имя
     */
    public static Animal animalWithLongestName(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .max(Comparator.comparing(a -> a.name().length()))
            .orElse(null);
    }

    /**
     * Задание 5. Каких животных больше: Самцов или самок
     */
    public static Animal.Sex dominatingSex(List<Animal> animals) {
        animalsNotNull(animals);

        long males = animals
            .stream()
            .filter(a -> a.sex() == Animal.Sex.M)
            .count();

        long females = animals
            .stream()
            .filter(a -> a.sex() == Animal.Sex.F)
            .count();

        if (males == females) {
            return null;
        }

        return males > females ? Animal.Sex.M : Animal.Sex.F;
    }

    /**
     * Задание 6. Самое тяжелое животное каждого вида
     */
    public static Map<Animal.Type, Animal> heaviestAnimalForType(List<Animal> animals) {
        animalsNotNull(animals);

        var map = new HashMap<Animal.Type, Animal>();
        for (var animal : animals) {
            int maxWeight = map.containsKey(animal.type())
                ? map.get(animal.type()).weight()
                : 0;
            map.put(animal.type(), maxWeight < animal.weight()
                ? animal
                : map.get(animal.type())
            );
        }

        return map;
    }

    /**
     * Задание 7. к-ое самое старое животное
     */
    public static Animal oldestAnimalNth(List<Animal> animals, int n) {
        animalsNotNull(animals);

        if (n < 0) {
            throw new IllegalArgumentException("Номер животного не может быть меньше нуля");
        }

        if (n >= animals.size()) {
            throw new IllegalArgumentException("Номер животного не может превышать размера коллекции");
        }

        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::age).reversed())
            .skip(n)
            .findFirst()
            .orElse(null);
    }

    /**
     * Задание 8. Самое тяжелое животное среди тех, что ниже k см
     */
    public static Optional<Animal> heaviestWithHeightLimit(List<Animal> animals, int height) {
        animalsNotNull(animals);

        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть положительным числом");
        }

        return animals
            .stream()
            .filter(a -> a.height() < height)
            .max(Comparator.comparing(Animal::weight));
    }

    /**
     * Задание 9. Сколько в сумме лап у животных в списке
     */
    public static Integer sumOfAllPaws(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    /**
     * Задание 10. Список животных, возраст у которых не совпадает с количеством лап
     */
    public static List<Animal> listAnimalsWithPawsNotMatchingAge(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .filter(a -> a.paws() != a.age())
            .toList();
    }

    /**
     * Задание 11. Список животных, которые могут укусить и рост превышает 100 см
     */
    public static List<Animal> listAnimalsThatCanBiteAndHeightAboveHundred(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .filter(a -> a.bites() && a.height() > HUNDRED)
            .toList();
    }

    /**
     * Задание 12. Сколько животных, у которых вес превышает рост
     */
    public static Integer countAnimalsWeightAboveHeight(List<Animal> animals) {
        animalsNotNull(animals);

        return (int) animals
            .stream()
            .filter(a -> a.weight() > a.height())
            .count();
    }

    /**
     * Задание 13. Список животных, имена которых состоят из более чем двух слов
     */
    public static List<Animal> listAnimalsHavingLongNames(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .filter(a -> a.name().split(" ").length > LONG_WORD_THRESHOLD)
            .toList();
    }

    /**
     * Задание 14. Есть ли в списке собака ростом более k см
     */
    public static Boolean isThereDogHeightMoreThanN(List<Animal> animals, int height) {
        animalsNotNull(animals);

        if (height <= 0) {
            throw new IllegalArgumentException("Высота должна быть положительной");
        }

        return animals
            .stream()
            .anyMatch(a -> a.type() == Animal.Type.DOG && a.height() > height);
    }

    /**
     * Задание 15. Найти суммарный вес животных каждого вида, которым от k до l лет
     */
    public static Integer findSumOfWeightWithinAgeRange(List<Animal> animals, int startAge, int endAge) {
        animalsNotNull(animals);

        if (startAge <= 0) {
            throw new IllegalArgumentException("Начало возраста должно быть положительным");
        }

        if (endAge <= 0) {
            throw new IllegalArgumentException("Окончание возраста должно быть положительным");
        }

        if (endAge <= startAge) {
            throw new IllegalArgumentException("Конец возраста должен быть позже начала");
        }

        return animals
            .stream()
            .filter(a -> a.age() > startAge && a.age() < endAge)
            .mapToInt(Animal::weight)
            .sum();
    }

    /**
     * Задание 16. Список животных, отсортированный по виду, затем по полу, затем по имени
     */
    public static List<Animal> sortByTypeSexName(List<Animal> animals) {
        animalsNotNull(animals);

        return animals
            .stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name)
            ).toList();
    }

    /**
     * Задание 17. Правда ли, что пауки кусаются чаще, чем собаки
     * (если данных для ответа недостаточно, вернуть false)
     */
    public static Boolean spidersBitingMoreThanDogs(List<Animal> animals) {
        animalsNotNull(animals);

        int dogsBiting = (int) animals
            .stream()
            .filter(a -> a.type() == Animal.Type.DOG && a.bites())
            .count();

        int spidersBiting = (int) animals
            .stream()
            .filter(a -> a.type() == Animal.Type.SPIDER && a.bites())
            .count();

        if (dogsBiting == spidersBiting) {
            return false;
        }

        return spidersBiting > dogsBiting;
    }

    /**
     * Задание 18. Найти самую тяжелую рыбку в 2-х или более списках
     */
    public static Animal heaviestFish(List<List<Animal>> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Список списков животных не должен быть null");
        }

        Stream<Animal> stream = Stream.of();

        for (var a : animals) {
            stream = Stream.concat(stream, a.stream());
        }

        return stream
            .filter(a -> a.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight))
            .orElse(null);
    }

    private static void animalsNotNull(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Список животных не может быть null");
        }
    }
}
