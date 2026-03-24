package itmo;

import itmo.commands.*;
import itmo.models.*;
import itmo.models.Object;
import itmo.utils.StrengthState;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var bombing = new Bombing("Бомбардировка", 5);
        var gnom = new Person("Емеля");
        var trol1 = new Person("Андрей");
        var trol2 = new Person("Саша");
        var trol3 = new Person("Тим");
        var trol4 = new Person("Артем");
        var trol = new Person("Степа");
        var metal = new Alloy();
        var panel = new FrontPanel("Передняя панель", 100, metal);
        var comp = new CompBank("Компьютерный банк", panel, 100);
        var corner = new Corner("угол", 10, 10);
        var env = new Environment("Окружение", corner);

        List<Person> people = new ArrayList<>();

        people.add(gnom);
        people.add(trol);
        people.add(trol1);
        people.add(trol2);
        people.add(trol3);
        people.add(trol4);

        var scenario = new Controller() {{
//            addCommand(new MetalFlowCommand(metal, corner));
//            addCommand(new DestroyCommand(bombing, comp));
//            addCommand(new MetalFlowCommand(metal, corner));
//
            addCommand(new SitCommand(trol, corner));
//            addCommand(new SitCommand(trol1, corner));
//            addCommand(new SitCommand(trol2, corner));
//            addCommand(new SitCommand(trol3, corner));
//            addCommand(new SitCommand(trol4, corner));

//            addCommand(new DestroyCommand(bombing, env));
//            addCommand(new HuddleCommand(people));
//            addCommand(new DestroyCommand(bombing, env));
//            addCommand(new HitCommand(bombing, gnom));
//            addCommand(new DestroyCommand(bombing, comp));
//            addCommand(new SitCommand(gnom, corner));
//            addCommand(new PlakiPlakCommand(people, bombing));
        }};

        scenario.execute();
    }
}