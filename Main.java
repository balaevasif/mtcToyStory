import java.util.ArrayList;
import java.util.List;

public class Main {

    static abstract class Creation{
        String name;
        int age;
        int HP;// Health points
        int satiety;
        void ruinFood(Food food){
            food.usability = false;
        }
        boolean isAlive(){
            return HP > 0;
        }
        List<String> communication = new ArrayList<>();

        void ThrowToFire(Thing thing){
//            if (thing.name.equals("Кастрюля")){
//                thing.
//            }
            Fire.Burn(thing);
        }
        static void appear(Building build, Creation creation){
            build.building.add(creation);
        }
        static void disappear(Building build, Creation creation){
            build.building.remove(creation);
        }

        static boolean inBuilding(Building build, Creation creation){
            int ex = 0;
            for (int i = 0; i < build.building.size(); i++) {
                if (build.building.get(i).getClass() == creation.getClass()){
                    ex++;
                }
            }
            return ex > 0;
            //return false;
        }

        void ask(Creation anyone){

        }

        void refuse(Creation anyone){}

        void goTo(Thing thing){

        }
        void wantTo(){

        }

        void takeCreationForSomething(Thing thing, Creation creation){

        }

        void scream(String text){
            this.communication.add(text);
        }
        void scream(String text, Creation creation){
            creation.communication.add(this.name + ": " + text);
        }

        void laugh(){

        }

    }
    static abstract class Human extends Creation{
        String name;
        String mood;

        boolean positionUp;
        //List<String> dialog = new ArrayList<>();
        void setName(String name) {
            this.name = name;
        }
        void setMood(String mood) {
            this.mood = mood;
        }
        void setHP(int HP) {
            this.HP = HP;
        }
        void setSatiety(int satiety) {
            this.satiety = satiety;
        }
        void makingFood(Creation creation, Food food, Crutch crutch){
            crutch.food.add(food);
            food.usability = false;
            //creation.satiety += food.satiety;
        }
        void makeFood(Creation creation, Food food, Crutch crutch){
            //crutch.food.add(food);
            food.usability = true;
            creation.satiety += food.satiety;
        }
        void tell(String text){
            System.out.println(text);
        }
        void tell(Creation creation, String text){
            creation.communication.add(this.name + ": " + text);
        }
        void standUp(){
            positionUp = true;
        }
        void sitDown(){ positionUp = false; }
        void whisper(String text){
            this.communication.add(text);
        }
        void whisper(String text, Creation creation){
            creation.communication.add(this.name + ": " + text);
        }
    }
    static abstract class Animal extends Creation{
    }
    static class StoryHeroPerson extends Human{

    }
    static class StoryHeroAnimal extends Animal{
        String name;
        String mood;
        //List<String> dialog = new ArrayList<>();
        void setName(String name) {
            this.name = name;
        }
        void setMood(String mood) {
            this.mood = mood;
        }
        void tell(String text){
            System.out.println(text);
        }
        void tell(Creation creation, String text){
            creation.communication.add(this.name + ": " + text);
        }
    }

    static class King extends StoryHeroPerson{
        King(){
            setName("Король");
        }
    }
    static class Queen extends StoryHeroPerson{
        Queen(){
            setName("Королева");
        }
    }
    static class Daughter extends StoryHeroPerson{}
    static class Courtier extends StoryHeroPerson{}
    static class RatKing extends StoryHeroAnimal{
        public RatKing(){
            setName("Крысиный король");
        }
        public boolean thirstForRevenge = false;
        public void Revenge(){
            thirstForRevenge = true;
        }
    }
    static class SonRatKing extends StoryHeroAnimal{
        public SonRatKing(){
            setName("Сын крысиного короля");
        }
    }
    static class RelativeRatKing extends StoryHeroAnimal{
    }
    static class GodFather extends Human{
        GodFather(){
            setName("Крёстный");
        }
    }
    static class Maria extends Human{
        Maria(){
            setName("Мария");
        }
    }
    static class Fritz extends Human{
        Fritz(){
            setName("Фриц");
        }
    }
    static class Mother extends Human{
        Mother(){
            setName("Матушка");
        }
    }
    static class Advisor extends Human{
        Advisor(){
            setName("Советик");
        }
    }

    static abstract class Building{
        List<Creation> building = new ArrayList<>();
    }
    static class KingDom extends Building{
    }

    ////////////////////FOOD////////////////////////
    static abstract class Food{
        String name;
        int satiety;
        boolean usability;
        List<Ingredients> ingredients = new ArrayList<>();
        void setName(String name){
            this.name = name;
        }
        void setSatiety(int satiety){this.satiety = satiety;}

    }
    static class Sauce extends Food{
        Sauce(){
            setName("Соус");
            setSatiety(5);
        }
    }
    static class SauceGiblets extends Sauce{
        SauceGiblets(){
            setName("Соус из потрохов");
            ingredients.add(Ingredients.Giblets);
            setSatiety(10);
        }
    }
    ////////////////////FOOD////////////////////////


    ////////////////////ENUMS////////////////////////
    enum Ingredients {
        Giblets,
    }
    enum Mood{
        Exult,
        Worried,
        Scared,
        Good,
        Bad,
        SpecialImpression,
        greatAnger;
    }
    ////////////////////ENUMS////////////////////////


    static abstract class Thing{
        String name;
        boolean usability = true;

        public void setName(String name) {
            this.name = name;
        }
    }

    static abstract class Clothes extends Thing{
        int size;
        String material;
        String color;
    }
    static class Coattails extends Clothes{
        Coattails(String name){
            this.name = name;
        }
    }
    static class Crutch extends Thing{
        String form;
        double vol;
        public List<Food> food = new ArrayList<>();
        Crutch(String name){
            this.name = name;
        }
    }

    static class Door extends Thing{
        int size;
        int material;
        int color;
    }
    static class Fire{
        static void Burn(Thing thing){
            thing.usability = false;
        }
    }


//    static class Story{
//        KingDom kingDom = new KingDom();
//        King king = new King();
//        Queen queen = new Queen();
//        Courtier courtierF = new Courtier();
//        Courtier courtierS = new Courtier();
//        Courtier courtierT = new Courtier();
//        RatKing ratKing = new RatKing();
//        SonRatKing sonRatKing = new SonRatKing();
//        RelativeRatKing relativeRatKingFirst = new RelativeRatKing();
//        RelativeRatKing relativeRatKingSecond = new RelativeRatKing();
//    }

    public static void main(String[] args) {


        KingDom kingDom = new KingDom();

        King king = new King();
        Queen queen = new Queen();
        Courtier courtierFirst = new Courtier();
        Courtier courtierSecond = new Courtier();
        Courtier courtierThird = new Courtier();
        RatKing ratKing = new RatKing();
        SonRatKing sonRatKing = new SonRatKing();
        RelativeRatKing relativeRatKingFirst = new RelativeRatKing();
        RelativeRatKing relativeRatKingSecond = new RelativeRatKing();
        SauceGiblets sauceGiblets = new SauceGiblets();
        Crutch crutch = new Crutch("Кастрюля");
        GodFather godFather = new GodFather();
        Maria maria = new Maria();
        Fritz fritz = new Fritz();
        Mother mother = new Mother();
        Advisor advisor = new Advisor();


        Door door = new Door();
        Coattails coattails = new Coattails("Фалды");


        kingDom.building.add(king);
        kingDom.building.add(queen);
        kingDom.building.add(courtierFirst);
        kingDom.building.add(courtierSecond);
        kingDom.building.add(courtierThird);

        if (!sonRatKing.isAlive() && !relativeRatKingFirst.isAlive() && !relativeRatKingSecond.isAlive()){
            king.mood = String.valueOf(Mood.Exult);
            courtierFirst.mood = String.valueOf(Mood.Exult);
            courtierSecond.mood = String.valueOf(Mood.Exult);
            courtierThird.mood = String.valueOf(Mood.Exult);
            queen.mood = String.valueOf(Mood.Worried);
            ratKing.Revenge();
        }

        queen.makingFood(king, sauceGiblets, crutch);

        Creation.appear(kingDom, ratKing);

        if (!Creation.inBuilding(kingDom, ratKing)){
            queen.makeFood(king, sauceGiblets, crutch);
        }
        else {
            ratKing.tell(queen, "Мои сыновья и родственники убиты! Смотри, королева, чтоб я за это не перекусила пополам твою дочку Пирлипат! Берегись!");
            Creation.disappear(kingDom, ratKing);
            queen.mood = String.valueOf(Mood.Scared);
            queen.ThrowToFire(crutch);
            king.mood = String.valueOf(Mood.greatAnger);
        }
        godFather.tell("Но, впрочем, на сегодня довольно; конец расскажу в другой раз");
        maria.mood = String.valueOf(Mood.SpecialImpression);
        maria.ask(godFather);
        godFather.refuse(maria);
        godFather.standUp();
        godFather.tell(maria, "Много сразу — вредно для здоровья! Продолжение завтра");
        //godFather.wantTo(godFather.goTo(door));
        godFather.goTo(door);
        fritz.takeCreationForSomething(coattails, godFather);
        fritz.scream("Крестный, крестный! Это правда, что ты выдумал мышеловки?", godFather);


        mother.tell(fritz, "Какой вздор ты городишь, Фриц!");

        advisor.laugh();
        advisor.whisper("— Ведь ты знаешь, какой я искусный часовщик; так почему же мне не выдумать.", fritz);

    }
}