package be.howest.ti.hplusplus.values;

import be.howest.ti.hplusplus.code.HppMethodDefinition;
import be.howest.ti.hplusplus.code.HppVar;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.exceptions.execution.KeyNotPresent;
import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.types.HppClass;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.scopes.HppScope;

import java.util.*;

public class HppObject extends HppValue implements HppScope<HppValue> {

    public void addObserver(String memberName, HppFunction observer) {
        if ( hasMember(memberName) ){
            members.get(memberName).observers.add(observer);
        } else {
            throw new KeyNotPresent(memberName + " in object of class" + hppClass);
        }
    }

    private class Member {
        HppValue val;
        List<HppFunction> observers;

        Member(HppValue val){
            this.val = val;
            observers = new ArrayList<>();
        }
    }

    private final HppClass hppClass;

    private final Map<String,Member> members;


    public HppObject(HppClass hppClass){
        this.hppClass = hppClass;
        members = initMembers();
    }

    private Map<String,Member> initMembers(){
        Map<String,Member> members = new HashMap<>();

        for(HppVar field : hppClass.getFields()){
            //System.out.println("New object has field:"+field.getName());
            members.put(field.getName(), new Member(field.getType().getDefaultValue()));
        }

        for(HppMethodDefinition method : hppClass.getMethods()){
            //System.out.println("New object has method:"+method.getName());
            members.put(method.getName(),new Member(new HppFunction(method, this)));
        }

        return members;
    }

    @Override
    public HppType getType() {
        return hppClass;
    }

    public boolean hasMember(String name){
        return members.containsKey(name);
    }


    public HppValue getMember(String name) {
        if ( hasMember(name) ){
            return members.get(name).val;
        } else {
            throw new KeyNotPresent(name + " in object of class" + hppClass);
        }
    }

    public HppValue setMember(String name, HppValue val) {
        if ( hasMember(name) ){
            Member m = members.get(name);
            HppValue old = m.val;
            m.val = val;
            for(HppFunction f : m.observers){
                f.apply(Arrays.asList(old,val));
            }
            return old;
        } else {
            throw new KeyNotPresent(name + " in object of class" + hppClass);
        }
    }

    @Override
    public HppObject getSelf() {
        return this;
    }

    @Override
    public HppValue getIt() {
        throw new KeyNotPresent("No 'it' in object-scope");
    }

    @Override
    public HppValue get(String name) {
        return getMember(name);
    }

    public HppValue set(String name, HppValue val) {
        return setMember(name,val);
    }

    @Override
    public void add(String name, HppValue val) {
        throw new HppExecutionException("Cannot add members to class during execution");
    }

    @Override
    public HppProgram getProg() {
        return hppClass.getProg();
    }

    public String toString(){
        StringBuilder strBuilder = new StringBuilder("An Object of class " + hppClass + "\n");

        for(Map.Entry<String,Member> e : members.entrySet()){
            strBuilder.append(e.getKey()).append(":\t").append(e.getValue().val).append("\n");
        }

        strBuilder.append("===\n");

        return strBuilder.toString();
    }

    @Override
    public HppObject getObject(){
        return this;
    }

}
