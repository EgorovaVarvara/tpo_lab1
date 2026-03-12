package itmo;

import itmo.commands.*;
import itmo.models.*;
import itmo.models.Object;
import itmo.utils.StrengthState;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var bombing = new Bombing("Бомбардировка");
        var gnom = new Person("Емеля");
        var trol = new Person("Дундук");
        var metal = new Alloy();
        var panel = new FrontPanel("Передняя панель", StrengthState.INTACT, metal);
        var comp = new CompBank("Компьютерный банк", panel, StrengthState.INTACT);
        var corner = new Corner("угол", 10, 10);
        var env = new Environment("Окружение", corner);

        List<Person> people = new ArrayList<>();

        people.add(gnom);
        people.add(trol);

        var scenario = new Controller() {{
            addCommand(new MetalFlowCommand(metal, corner));
            addCommand(new DestroyCommand(bombing, comp));
            addCommand(new MetalFlowCommand(metal, corner));


//            addCommand(new DestroyCommand(bombing, env));
//            addCommand(new HuddleCommand(people));
//            addCommand(new DestroyCommand(bombing, env));
//            addCommand(new HitCommand(bombing, gnom));
//            addCommand(new DestroyCommand(bombing, comp));
//            addCommand(new SitCommand(gnom, corner));
//            addCommand(new PlakiPlakCommand(people));
        }};

        scenario.execute();
    }
}