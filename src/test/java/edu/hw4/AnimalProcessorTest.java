package edu.hw4;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;

public class AnimalProcessorTest {
    private final static String SAMPLE_NAME = "Sample name";
    @DisplayName("Сортировка по росту")
    @Test
    void sortByHeight() {
        assertThat(AnimalProcessor.sortByHeight(List.of(
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 100, 0, false),
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 130, 0, false),
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 10, 0, false)
            ))).isSortedAccordingTo(Comparator.comparing(Animal::height));
    }

    @DisplayName("Сортировка по весу от большего к малому с лимитом")
    @Test
    void sortByWeightReversedWithLimit() {
        int limit = 2;

        assertThat(AnimalProcessor.sortByWeightReversedWithLimit(List.of(
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 130,  false),
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 13, false)
            ), limit))
            .isSortedAccordingTo(Comparator.comparing(Animal::weight).reversed())
            .hasSize(limit);
    }

    @DisplayName("Число животных каждого типа")
    @Test
    void animalsNumberByType() {
        assertThat(AnimalProcessor.animalsNumberByType(List.of(
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 1, 0, 130,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 1, 0, 13, false),
                new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 1, 0, 13, false)
            ))).contains(
                entry(Animal.Type.DOG, 1),
                entry(Animal.Type.FISH, 2),
                entry(Animal.Type.CAT, 1)
            );
    }

    @DisplayName("У какого животного самое длинное имя")
    @Test
    void animalWithLongestName() {
        assertThat(AnimalProcessor.animalWithLongestName(List.of(
                new Animal("One", Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
                new Animal("Two", Animal.Type.FISH, Animal.Sex.M, 1, 0, 130,  false),
                new Animal("Three", Animal.Type.FISH, Animal.Sex.M, 1, 0, 13, false),
                new Animal("Four", Animal.Type.CAT, Animal.Sex.M, 1, 0, 13, false)
            ))).extracting(Animal::name).isEqualTo("Three");
    }

    @DisplayName("Каких животных больше")
    @Test
    void dominatingSex() {
        assertThat(AnimalProcessor.dominatingSex(List.of(
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 1, 0, 130,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 1, 0, 13, false),
                new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 1, 0, 13, false)
            ))).isEqualTo(Animal.Sex.M);
    }

    @DisplayName("Самое тяжелое животное каждого вида")
    @Test
    void heaviestAnimalOfEachType() {
        assertThat(AnimalProcessor.heaviestAnimalForType(List.of(
                new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 1, 0, 130,  false),
                new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 1, 0, 13, false),
                new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 1, 0, 13, false)
            ))).extractingFromEntries(
                e -> tuple(e.getKey(), e.getValue().weight())
            ).contains(
                tuple(Animal.Type.DOG, 100),
                tuple(Animal.Type.FISH, 130),
                tuple(Animal.Type.CAT, 13)
            );
    }

    @DisplayName("к-ое самое старое животное")
    @Test
    void oldestAnimalNth() {
        assertThat(AnimalProcessor.oldestAnimalNth(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 0, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 0, 130,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 4, 0, 13, false),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 2, 0, 13, false)
        ), 1)).extracting(Animal::age).isEqualTo(3);
    }

    @DisplayName("Самое тяжелое животное среди тех, что ниже k см")
    @Test
    void heaviestWithHeightLimit() {
        assertThat(AnimalProcessor.heaviestWithHeightLimit(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 5, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 4, 0, 13, false),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 2, 0, 12, false)
        ), 5)).get().extracting(Animal::weight).isEqualTo(13);
    }

    @DisplayName("Сколько в сумме лап у животных в списке")
    @Test
    void countTotalPaws() {
        assertThat(AnimalProcessor.sumOfAllPaws(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 5, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 4, 0, 13, false),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 2, 0, 12, false)
        ))).isEqualTo(8);
    }

    @DisplayName("Список животных, возраст у которых не совпадает с количеством лап")
    @Test
    void listAnimalsWithPawsNotMatchingAge() {
        assertThat(AnimalProcessor.listAnimalsWithPawsNotMatchingAge(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 5, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 2, 0, 13, false),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 4, 0, 12, false)
        ))).allMatch(e -> e.paws() != e.age()).hasSize(3);
    }

    @DisplayName("Список животных, которые могут укусить и рост превышает 100 см")
    @Test
    void listAnimalsThatCanBiteAndHeightAboveHundred() {
        assertThat(AnimalProcessor.listAnimalsThatCanBiteAndHeightAboveHundred(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 101, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  true),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 2, 101, 13, true),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 4, 0, 12, false)
        ))).allMatch(e -> e.bites() && e.height() > 100).hasSize(1);
    }

    @DisplayName("Сколько животных, у которых вес превышает рост")
    @Test
    void countAnimalsWeightAboveHeight() {
        assertThat(AnimalProcessor.countAnimalsWeightAboveHeight(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 101, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  true),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.M, 2, 101, 13, true),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 4, 0, 12, false)
        ))).isEqualTo(2);
    }

    @DisplayName("Список животных с длинными именами")
    @Test
    void listAnimalsHavingLongNames() {
        assertThat(AnimalProcessor.listAnimalsHavingLongNames(List.of(
            new Animal("One Two", Animal.Type.DOG, Animal.Sex.M, 1, 101, 100,  false),
            new Animal("One Two Three", Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  true),
            new Animal("One Two Three Four", Animal.Type.FISH, Animal.Sex.M, 2, 101, 13, true),
            new Animal("One", Animal.Type.CAT, Animal.Sex.M, 4, 0, 12, false)
        ))).extracting(Animal::name).contains("One Two Three", "One Two Three Four");
    }

    @DisplayName("Есть ли в списке собака ростом более k см")
    @Test
    void isThereDogHeightMoreThanN() {
        assertThat(AnimalProcessor.isThereDogHeightMoreThanN(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 1, 80, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 3, 5, 130,  true),
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 2, 101, 13, true),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 4, 0, 12, false)
        ), 90)).isTrue();
    }

    @DisplayName("Найти суммарный вес животных каждого вида, которым от k до l лет")
    @Test
    void findSumOfWeightWithinAgeRange() {
        assertThat(AnimalProcessor.findSumOfWeightWithinAgeRange(List.of(
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  false),
            new Animal(SAMPLE_NAME, Animal.Type.FISH, Animal.Sex.F, 16, 5, 130,  true),
            new Animal(SAMPLE_NAME, Animal.Type.DOG, Animal.Sex.M, 17, 101, 13, true),
            new Animal(SAMPLE_NAME, Animal.Type.CAT, Animal.Sex.M, 30, 0, 12, false)
        ), 15, 20)).isEqualTo(143);
    }

    @DisplayName("Список животных, отсортированный по виду, затем по полу, затем по имени")
    @Test
    void sortByTypeSexName() {
        assertThat(AnimalProcessor.sortByTypeSexName(List.of(
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  false),
            new Animal("Two", Animal.Type.FISH, Animal.Sex.F, 16, 5, 130,  true),
            new Animal("Three", Animal.Type.DOG, Animal.Sex.M, 17, 101, 13, true),
            new Animal("Four", Animal.Type.CAT, Animal.Sex.M, 30, 0, 12, false)
        ))).extracting(Animal::name).containsExactly("Four", "One", "Three", "Two");
    }

    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки\n" +
        "(если данных для ответа недостаточно, вернуть false)")
    @Test
    void spidersBitingMoreThanDogs() {
        assertThat(AnimalProcessor.spidersBitingMoreThanDogs(List.of(
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  true),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  false),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  false),
            new Animal("One", Animal.Type.DOG, Animal.Sex.M, 10, 80, 100,  false),
            new Animal("Two", Animal.Type.FISH, Animal.Sex.F, 16, 5, 130,  true),
            new Animal("Three", Animal.Type.SPIDER, Animal.Sex.M, 17, 101, 13, true),
            new Animal("Four", Animal.Type.SPIDER, Animal.Sex.M, 30, 0, 12, true)
        ))).isTrue();
    }

    @DisplayName("Найти самую тяжелую рыбку в 2-х или более списках")
    @Test
    void heaviestFish() {
        assertThat(AnimalProcessor.heaviestFish(
            List.of(
                List.of(
                    new Animal("A", Animal.Type.FISH, Animal.Sex.M, 0, 0, 10, false),
                    new Animal("A", Animal.Type.FISH, Animal.Sex.M, 0, 0, 10, false)
                ),
                List.of(
                    new Animal("B", Animal.Type.FISH, Animal.Sex.M, 0, 0, 15, false)
                )
            )
        )).extracting(Animal::weight).isEqualTo(15);
    }
}
