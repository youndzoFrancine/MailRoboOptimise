/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.util.LinkedList;
import java.util.List;

/**
 * @author Marie Lemdjo
 * @author Francine Youndzo
 * 
 * Un groupe est constitu� d'un ensemble de personnes
 */
public class Group {
    private  List<Person> members = new LinkedList<Person>();

    public void addMember(Person p){
        members.add(p);
    }

    public List<Person> getmembers(){
        return members;
    }
}
