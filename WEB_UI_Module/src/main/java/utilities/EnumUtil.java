package utilities;

import java.util.Random;
import java.util.function.Predicate;

public final class EnumUtil {

    private EnumUtil() {
    }

    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration, Predicate<T> predicate, String search) {
        for (T singleEnum : enumeration.getEnumConstants()) {
            if (predicate.test(singleEnum)) {
                return singleEnum;
            }
        }
        throw new IllegalArgumentException(String.format("No enum value was found: Enum[%s] Value[%s]",
                enumeration.getSimpleName(), search));
    }

    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration,
                                                   String search) {
        return searchEnum(enumeration, s -> s.name().equalsIgnoreCase(search), search);
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumeration) {
        int size = enumeration.getEnumConstants().length;
        return enumeration.getEnumConstants()[new Random().nextInt(size)];
    }
}
