/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 * @author Marie Lemdjo
 * @author Francine Youndzo
 * 
 * Cette classe permet de g�n�rer des message, une liste de victimes al�atoire
 * et un �metteur et constitue une plaisanterie.
 */
import configuration.IConfiguration;
import configuration.ConfigurationManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import model.Group;
import model.Message;
import model.Person;

public class PrankGenerator {

    private  IConfiguration configuration;
    private List<Person> availableVictims = new LinkedList<Person>();

    public PrankGenerator(IConfiguration config) {
        this.configuration = config;

    }

    public List<Group> generateGroup(List<Person> victims, int numberOfGroup) {

        Collections.shuffle(victims); //melange les PERSONNES pour que la liste soit aléatoire

        //initialise la liste des map;
        int j = 0;
        for (Person p : victims) {
            availableVictims.add(p);
        }

        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < numberOfGroup; i++) {
            Group group = new Group();
            groups.add(group);
        }

        int index = 0;
        int indexp = 0;

        Group groupeCible;

        for (; availableVictims.size() > 0;) {
            groupeCible = groups.get(index);
            Person victim = availableVictims.remove(0);
            groups.get(index).addMember(victim);
            index = (index + 1) % groups.size(); //Pour ne pas déborder le tableau
        }
        return groups;
    }

    public List<Prank> generatePranks() {
        List<Prank> pranks = new ArrayList<>();
        List<Message> messages = configuration.getMessage();
        int indexMessage = 0;
        int numberOfGroups = configuration.getNumberOfGroup();
        int numberOfVictims = configuration.getVictim().size();


        if (numberOfVictims / numberOfGroups < 8) {
            numberOfGroups = numberOfVictims / 8;
        }

        List<Group> groups = generateGroup(configuration.getVictim(), numberOfGroups);
        Person sender = null;
        int i = 0;

        for (Group group : groups) {
            Prank p = new Prank();

            List<Person> victim = group.getmembers();
            Collections.shuffle(victim);

            if (!victim.isEmpty()) {
                sender = victim.remove(0);
            }
            p.addVictimRecipients(victim);
            Message message = messages.get(indexMessage);
            indexMessage = (indexMessage + 1) % messages.size();
            p.setVictimsender(sender);
            p.setMessage(message);
            System.out.println(p.getMessage().getBody());
            pranks.add(p);
        }
        return pranks;
    }
}
