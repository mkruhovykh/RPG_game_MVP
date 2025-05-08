package maksym.kruhovykh.characterservice.service;

public interface CharacterParamsService {
    void increaseStrength(String userName);

    // Метод для увеличения мастерства
    void increaseMastery(String characterName);

    // Метод для увеличения защиты
    void increaseDefence(String characterName);

    // Метод для увеличения ловкости
    void increaseAgility(String characterName);

    // Метод для увеличения здоровья
    void increaseHealth(String characterName);

    Integer getPriceForStrengthByLvl(int level);

    Integer getPriceForMasteryByLvl(int level);

    Integer getPriceForDefenceByLvl(int level);

    Integer getPriceForAgilityByLvl(int level);

    Integer getPriceForHealthByLvl(int level);
}
